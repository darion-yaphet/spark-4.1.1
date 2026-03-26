/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.pipelines.graph

/**
 * DataflowGraph 核心流程说明：
 * 1. 结构管理：通过 flows, tables, sinks, views 维护管道的拓扑结构。
 * 2. 标识符映射：使用 lazy val (output, table, sink, flow, view) 提供各组件的快速查表能力。
 * 3. 语义解析：resolve() 方法驱动 DataflowGraphTransformer 和 CoreDataflowNodeProcessor 对图节点进行深度解析。
 * 4. 拓扑验证：validate() 确保图中无环，每个数据集都有输入源，且模式（Schema）兼容。
 * 5. 模式推导：inferredSchema 动态合并多流写入同一表时的 Schema，确保数据一致性。
 */

import scala.util.Try

import org.apache.spark.sql.AnalysisException
import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.pipelines.graph.DataflowGraph.mapUnique
import org.apache.spark.sql.pipelines.util.SchemaMergingUtils
import org.apache.spark.sql.types.StructType

/**
 * DataflowGraph represents the core graph structure for Spark declarative pipelines.
 * It manages the relationships between logical flows, tables, sinks, and views, providing
 * operations for graph traversal, validation, and transformation.
 * DataflowGraph 代表了 Spark 声明式管道的核心图结构。
 * 它管理逻辑流、表、接收器和视图之间的关系，提供图遍历、验证和转换操作。
 */
case class DataflowGraph(
    flows: Seq[Flow],
    tables: Seq[Table],
    sinks: Seq[Sink],
    views: Seq[View])
  extends GraphOperations
  with GraphValidations {

  /** Map of [[Output]]s by their identifiers
   * 按标识符划分的 [[Output]] 映射表 */
  lazy val output: Map[TableIdentifier, Output] = mapUnique(sinks ++ tables, "output")(_.identifier)

  /**
   * [[Flow]]s in this graph that need to get planned and potentially executed when
   * executing the graph. Flows that write to logical views are excluded.
   * 图中需要在执行时进行计划并可能执行的 [[Flow]]。写入逻辑视图的流被排除在外。
   */
  lazy val materializedFlows: Seq[ResolvedFlow] = {
    resolvedFlows.filter(
      f => output.contains(f.destinationIdentifier)
    )
  }

  /** The identifiers of [[materializedFlows]].
   * [[materializedFlows]] 的标识符集合。 */
  val materializedFlowIdentifiers: Set[TableIdentifier] = materializedFlows.map(_.identifier).toSet

  /** Map of [[Table]]s by their identifiers
   * 按标识符划分的 [[Table]] 映射表 */
  lazy val table: Map[TableIdentifier, Table] =
    mapUnique(tables, "table")(_.identifier)

  /** Map of [[Sink]]s by their identifiers
   * 按标识符划分的 [[Sink]] 映射表 */
  lazy val sink: Map[TableIdentifier, Sink] =
    mapUnique(sinks, "sink")(_.identifier)

  /** Map of [[Flow]]s by their identifier
   * 按标识符划分的 [[Flow]] 映射表 */
  lazy val flow: Map[TableIdentifier, Flow] = {
    // Better error message than using mapUnique.
    val flowsByIdentifier = flows.groupBy(_.identifier)
    flowsByIdentifier
      .find(_._2.size > 1)
      .foreach {
        case (flowIdentifier, flows) =>
          // We don't expect this to ever actually be hit, graph registration should validate for
          // unique flow names.
          throw new AnalysisException(
            errorClass = "PIPELINE_DUPLICATE_IDENTIFIERS.FLOW",
            messageParameters = Map(
              "flowName" -> flowIdentifier.unquotedString,
              "datasetNames" -> flows.map(_.destinationIdentifier).mkString(",")
            )
          )
      }
    // Flows with non-default names shouldn't conflict with table names
    flows
      .filterNot(f => f.identifier == f.destinationIdentifier)
      .filter(f => table.contains(f.identifier))
      .foreach { f =>
        throw new AnalysisException(
          "FLOW_NAME_CONFLICTS_WITH_TABLE",
          Map(
            "flowName" -> f.identifier.toString(),
            "target" -> f.destinationIdentifier.toString(),
            "tableName" -> f.identifier.toString()
          )
        )
      }
    flowsByIdentifier.view.mapValues(_.head).toMap
  }

  /** Map of [[View]]s by their identifiers
   * 按标识符划分的 [[View]] 映射表 */
  lazy val view: Map[TableIdentifier, View] = mapUnique(views, "view")(_.identifier)

  /** The [[PersistedView]]s of the graph
   * 图中的持久化视图 [[PersistedView]] 列表 */
  lazy val persistedViews: Seq[PersistedView] = views.collect {
    case v: PersistedView => v
  }

  /** All the [[Input]]s in the current DataflowGraph.
   * 当前 DataflowGraph 中所有的 [[Input]] 标识符集合。 */
  lazy val inputIdentifiers: Set[TableIdentifier] = {
    (flows ++ tables).map(_.identifier).toSet
  }

  /** The [[Flow]]s that write to a given destination.
   * 写入给定目的地的 [[Flow]] 映射表。 */
  lazy val flowsTo: Map[TableIdentifier, Seq[Flow]] = flows.groupBy(_.destinationIdentifier)

  /** The [[Flow]]s that write to a given destination.
   * 写入给定目的地的已解析流 [[ResolvedFlow]] 映射。 */
  lazy val resolvedFlowsTo: Map[TableIdentifier, Seq[ResolvedFlow]] =
    resolvedFlows.groupBy(_.destinationIdentifier)

  /** All flows that have been successfully resolved.
   * 所有已成功解析的流列表。 */
  lazy val resolvedFlows: Seq[ResolvedFlow] = {
    flows.collect { case f: ResolvedFlow => f }
  }

  /** Map of resolved flows by their identifier.
   * 按标识符划分的已解析流映射表。 */
  lazy val resolvedFlow: Map[TableIdentifier, ResolvedFlow] = {
    resolvedFlows.map { f =>
      f.identifier -> f
    }.toMap
  }

  /** Flows that failed to be resolved during analysis.
   * 在分析过程中解析失败的流列表。 */
  lazy val resolutionFailedFlows: Seq[ResolutionFailedFlow] = {
    flows.collect { case f: ResolutionFailedFlow => f }
  }

  /** Map of resolution failed flows by their identifier.
   * 按标识符划分的解析失败流映射表。 */
  lazy val resolutionFailedFlow: Map[TableIdentifier, ResolutionFailedFlow] = {
    resolutionFailedFlows.map { f =>
      f.identifier -> f
    }.toMap
  }

  /**
   * Used to reanalyze the flow's DF for a given table or sink. This is done by finding all upstream
   * flows (until a table is reached) for the specified source and reanalyzing all upstream
   * flows.
   * 用于重新分析给定表或接收器的流的 DataFrame。这是通过查找指定源的所有上游流（直到到达表为止）并重新分析所有这些上游流来实现的。
   *
   * @param srcFlow The flow that writes into the table that we will start from when finding
   *                upstream flows
   *                写入表的流，我们将从该流开始查找上游流
   * @return The reanalyzed flow
   *         重新分析后的流
   */
  protected[graph] def reanalyzeFlow(srcFlow: Flow): ResolvedFlow = {
    val upstreamDatasetIdentifiers = dfsInternal(
      flowNodes(srcFlow.identifier).output,
      downstream = false,
      stopAtMaterializationPoints = true
    )
    val upstreamFlows =
      resolvedFlows
        .filter(f => upstreamDatasetIdentifiers.contains(f.destinationIdentifier))
        .map(_.flow)
    val upstreamViews = upstreamDatasetIdentifiers.flatMap(identifier => view.get(identifier)).toSeq

    val subgraph = new DataflowGraph(
      flows = upstreamFlows,
      views = upstreamViews,
      tables = table.get(srcFlow.destinationIdentifier).toSeq,
      sinks = sink.get(srcFlow.destinationIdentifier).toSeq
    )
    subgraph.resolve().resolvedFlow(srcFlow.identifier)
  }

  /**
   * A map of the inferred schema of each table, computed by merging the analyzed schemas
   * of all flows writing to that table.
   * 每个表的推导模式映射，通过合并写入该表的所有流的分析模式计算得出。
   */
  lazy val inferredSchema: Map[TableIdentifier, StructType] = {
    flowsTo.view.mapValues { flows =>
      flows
        .map { flow =>
          resolvedFlow(flow.identifier).schema
        }
        .reduce(SchemaMergingUtils.mergeSchemas)
    }.toMap
  }

  /** Ensure that the [[DataflowGraph]] is valid and throws errors if not.
   * 确保 [[DataflowGraph]] 有效，如无效则抛出错误。 */
  def validate(): DataflowGraph = {
    validationFailure.toOption match {
      case Some(exception) => throw exception
      case None => this
    }
  }

  /**
   * Validate the current [[DataflowGraph]] and cache the validation failure.
   * 验证当前的 [[DataflowGraph]] 并缓存验证失败信息。
   *
   * To add more validations, add them in a helper function that throws an exception if the
   * validation fails, and invoke the helper function here.
   * 欲添加更多验证，请在辅助函数中实现（若验证失败则抛出异常），并在此处调用该辅助函数。
   */
  private lazy val validationFailure: Try[Throwable] = Try {
    validateSuccessfulFlowAnalysis()
    validateUserSpecifiedSchemas()
    // Connecting the graph sorts it topologically
    validateGraphIsTopologicallySorted()
    validateMultiQueryTables()
    validatePersistedViewSources()
    validateEveryDatasetHasFlow()
    validateTablesAreResettable()
    validateFlowStreamingness()
    inferredSchema
  }.failed

  /**
   * Enforce every dataset has at least one input flow. For example its possible to define
   * streaming tables without a query; such tables should still have at least one flow
   * writing to it.
   * 强制要求每个数据集至少有一个输入流。例如，可以定义没有查询的流式表；此类表仍应至少有一个流写入其中。
   */
  private def validateEveryDatasetHasFlow(): Unit = {
    (tables.map(_.identifier) ++ views.map(_.identifier)).foreach { identifier =>
      if (!flows.exists(_.destinationIdentifier == identifier)) {
        throw new AnalysisException(
          "PIPELINE_DATASET_WITHOUT_FLOW",
          Map("identifier" -> identifier.quotedString)
        )
      }
    }
  }

  /** Returns true iff all [[Flow]]s are successfully analyzed.
   * 当且仅当所有 [[Flow]] 都成功分析时返回 true。 */
  def resolved: Boolean =
    flows.forall(f => resolvedFlow.contains(f.identifier))

  /**
   * Resolve the DataflowGraph by processing nodes through the DataflowGraphTransformer.
   * 通过 DataflowGraphTransformer 处理节点来解析 DataflowGraph。
   * @return A new resolved DataflowGraph.
   *         一个新的已解析 DataflowGraph。
   */
  def resolve(): DataflowGraph =
    DataflowGraphTransformer.withDataflowGraphTransformer(this) { transformer =>
      val coreDataflowNodeProcessor =
        new CoreDataflowNodeProcessor(rawGraph = this)
      transformer
        .transformDownNodes(coreDataflowNodeProcessor.processNode)
        .getDataflowGraph
    }
}

object DataflowGraph {
  /**
   * Helper method to map a sequence of elements to a map by a unique key.
   * 将元素序列映射到以唯一键为索引的映射表。
   * @param input Input sequence of elements. / 输入元素序列。
   * @param tpe The type of elements (used for error reporting). / 元素类型（用于错误报告）。
   * @param f Function to extract the unique key. / 提取唯一键的函数。
   * @return A map of elements by their unique key. / 按唯一键索引的元素映射表。
   */
  protected[graph] def mapUnique[K, A](input: Seq[A], tpe: String)(f: A => K): Map[K, A] = {
    val grouped = input.groupBy(f)
    grouped.filter(_._2.length > 1).foreach {
      case (name, _) =>
        throw new AnalysisException(
          errorClass = "DUPLICATE_GRAPH_ELEMENT",
          messageParameters = Map("graphElementType" -> tpe, "graphElementName" -> name.toString)
        )
    }
    grouped.view.mapValues(_.head).toMap
  }
}
