/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file is an adaptation of Presto's presto-parser/src/main/antlr4/com/facebook/presto/sql/parser/SqlBase.g4 grammar.
 */

/**
 * SqlBaseLexer 核心流程说明：
 * 1. 词法单元提取：将输入的 SQL 字符串切分为关键词（Keywords）、标识符（Identifiers）、字面量（Literals）和操作符。
 * 2. 关键词管理：定义了从 ADD 到 ZONE 的所有 Spark SQL 关键词。
 * 3. 复杂类型感知：利用 complex_type_level_counter 跟踪嵌套复合类型（如 ARRAY<MAP<...>>），处理嵌套的大于号（>）与右移操作符（>>）的歧义。
 * 4. 浮点数与十进制校验：isValidDecimal 方法确保包含的小数点的标记是合法的数值分量。
 * 5. 注释与提示处理：区分普通块注释（/* ... */）和 Optimizer Hints（/*+ ... */），并将注释和空白重定向到 HIDDEN 通道。
 */
lexer grammar SqlBaseLexer;

@members {
  /**
   * When true, parser should throw ParseException for unclosed bracketed comment.
   * 为 true 时，解析器应针对未闭合的块注释抛出 ParseException。
   */
  public boolean has_unclosed_bracketed_comment = false;

  /**
   * Verify whether current token is a valid decimal token (which contains dot).
   * Returns true if the character that follows the token is not a digit or letter or underscore.
   * 验证当前标记是否为有效的十进制标记（包含小数点）。
   * 如果标记后的字符不是数字、字母或下划线，则返回 true。
   *
   * For example:
   * 示例：
   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
   * 对于字符流 "2.3"，"2." 不是有效的十进制标记，因为它后面跟着数字 '3'。
   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
   * 对于字符流 "2.3_"，"2.3" 不是有效的十进制标记，因为它后面跟着 '_'。
   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
   * 对于字符流 "2.3W"，"2.3" 不是有效的十进制标记，因为它后面跟着 'W'。
   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is followed
   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
   * which is not a digit or letter or underscore.
   * 对于字符流 "12.0D 34.E2+0.12 "，12.0D 是有效的十进制标记，因为它后面跟着一个空格。
   * 34.E2 是有效的十进制标记，因为它后面跟着符号 '+'，该符号既不是数字、字母也不是下划线。
   */
  public boolean isValidDecimal() {
    int nextChar = _input.LA(1);
    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
      nextChar == '_') {
      return false;
    } else {
      return true;
    }
  }

  /**
   * This method will be called when we see '/*' and try to match it as a bracketed comment.
   * If the next character is '+', it should be parsed as hint later, and we cannot match
   * it as a bracketed comment.
   * 当捕获到 '/*' 并尝试将其匹配为块注释时，将调用此方法。
   * 如果下一个字符是 '+'，则后续应将其解析为 Hint，因此我们不能将其匹配为块注释。
   *
   * Returns true if the next character is '+'.
   * 如果下一个字符是 '+'，则返回 true。
   */
  public boolean isHint() {
    int nextChar = _input.LA(1);
    if (nextChar == '+') {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method will be called when the character stream ends and try to find out the
   * unclosed bracketed comment.
   * If the method be called, it means the end of the entire character stream match,
   * and we set the flag and fail later.
   * 当字符流结束时调用此方法，以查找到未闭合的块注释。
   * 如果调用此方法，意味着整个字符流匹配结束，我们将设置标志位并在稍后报错。
   */
  public void markUnclosedComment() {
    has_unclosed_bracketed_comment = true;
  }

  /**
   * When greater than zero, it's in the middle of parsing ARRAY/MAP/STRUCT type.
   * 当大于零时，表示当前正处于解析 ARRAY/MAP/STRUCT 类型的过程中。
   */
  public int complex_type_level_counter = 0;

  /**
   * Increase the counter by one when hits KEYWORD 'ARRAY', 'MAP', 'STRUCT'.
   * 当遇到关键字 'ARRAY', 'MAP', 'STRUCT' 时，计数器加一。
   */
  public void incComplexTypeLevelCounter() {
    complex_type_level_counter++;
  }

  /**
   * Decrease the counter by one when hits close tag '>' && the counter greater than zero
   * which means we are in the middle of complex type parsing. Otherwise, it's a dangling
   * GT token and we do nothing.
   * 当遇到闭合标签 '>' 且计数器大于零（意味着处于复杂类型解析中）时，计数器减一。
   * 否则，它只是一个孤立的大于号标记，不做处理。
   */
  public void decComplexTypeLevelCounter() {
    if (complex_type_level_counter > 0) complex_type_level_counter--;
  }

  /**
   * If the counter is zero, it's a shift right operator. It can be closing tags of an complex
   * type definition, such as MAP<INT, ARRAY<INT>>.
   * 如果计数器为零，则为右移操作符。它也可以是复杂类型定义的闭合标签，例如 MAP<INT, ARRAY<INT>>。
   */
  public boolean isShiftRightOperator() {
    return complex_type_level_counter == 0 ? true : false;
  }
}

SEMICOLON: ';';

LEFT_PAREN: '(';
RIGHT_PAREN: ')';
COMMA: ',';
DOT: '.';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
BANG: '!';

// NOTE: If you add a new token in the list below, you should update the list of keywords
// and reserved tag in `docs/sql-ref-ansi-compliance.md#sql-keywords`, and
// modify `ParserUtils.toExprAlias()` which assumes all keywords are between `ADD` and `ZONE`.
// 注意：如果在下方列表中添加新标记，应更新 `docs/sql-ref-ansi-compliance.md#sql-keywords` 中的关键字和保留标签列表，
// 并修改 `ParserUtils.toExprAlias()`，该方法假设所有关键字都位于 `ADD` 和 `ZONE` 之间。

//============================
// Start of the keywords list
//============================
//--SPARK-KEYWORD-LIST-START
ADD: 'ADD';
AFTER: 'AFTER';
AGGREGATE: 'AGGREGATE';
ALL: 'ALL';
ALTER: 'ALTER';
ALWAYS: 'ALWAYS';
ANALYZE: 'ANALYZE';
AND: 'AND';
ANTI: 'ANTI';
ANY: 'ANY';
ANY_VALUE: 'ANY_VALUE';
ARCHIVE: 'ARCHIVE';
ARRAY: 'ARRAY' {incComplexTypeLevelCounter();};
AS: 'AS';
ASC: 'ASC';
AT: 'AT';
ATOMIC: 'ATOMIC';
AUTHORIZATION: 'AUTHORIZATION';
BEGIN: 'BEGIN';
BETWEEN: 'BETWEEN';
BIGINT: 'BIGINT';
BINARY: 'BINARY';
BINDING: 'BINDING';
BOOLEAN: 'BOOLEAN';
BOTH: 'BOTH';
BUCKET: 'BUCKET';
BUCKETS: 'BUCKETS';
BY: 'BY';
BYTE: 'BYTE';
CACHE: 'CACHE';
CALL: 'CALL';
CALLED: 'CALLED';
CASCADE: 'CASCADE';
CASE: 'CASE';
CAST: 'CAST';
CATALOG: 'CATALOG';
CATALOGS: 'CATALOGS';
CHANGE: 'CHANGE';
CHAR: 'CHAR';
CHARACTER: 'CHARACTER';
CHECK: 'CHECK';
CLEAR: 'CLEAR';
CLUSTER: 'CLUSTER';
CLUSTERED: 'CLUSTERED';
CODEGEN: 'CODEGEN';
COLLATE: 'COLLATE';
COLLATION: 'COLLATION';
COLLECTION: 'COLLECTION';
COLUMN: 'COLUMN';
COLUMNS: 'COLUMNS';
COMMENT: 'COMMENT';
COMMIT: 'COMMIT';
COMPACT: 'COMPACT';
COMPACTIONS: 'COMPACTIONS';
COMPENSATION: 'COMPENSATION';
COMPUTE: 'COMPUTE';
CONCATENATE: 'CONCATENATE';
CONDITION: 'CONDITION';
CONSTRAINT: 'CONSTRAINT';
CONTAINS: 'CONTAINS';
CONTINUE: 'CONTINUE';
COST: 'COST';
CREATE: 'CREATE';
CROSS: 'CROSS';
CUBE: 'CUBE';
CURRENT: 'CURRENT';
CURRENT_DATE: 'CURRENT_DATE';
CURRENT_TIME: 'CURRENT_TIME';
CURRENT_TIMESTAMP: 'CURRENT_TIMESTAMP';
CURRENT_USER: 'CURRENT_USER';
DAY: 'DAY';
DAYS: 'DAYS';
DAYOFYEAR: 'DAYOFYEAR';
DATA: 'DATA';
DATE: 'DATE';
DATABASE: 'DATABASE';
DATABASES: 'DATABASES';
DATEADD: 'DATEADD';
DATE_ADD: 'DATE_ADD';
DATEDIFF: 'DATEDIFF';
DATE_DIFF: 'DATE_DIFF';
DBPROPERTIES: 'DBPROPERTIES';
DEC: 'DEC';
DECIMAL: 'DECIMAL';
DECLARE: 'DECLARE';
DEFAULT: 'DEFAULT';
DEFINED: 'DEFINED';
DEFINER: 'DEFINER';
DELAY: 'DELAY';
DELETE: 'DELETE';
DELIMITED: 'DELIMITED';
DESC: 'DESC';
DESCRIBE: 'DESCRIBE';
DETERMINISTIC: 'DETERMINISTIC';
DFS: 'DFS';
DIRECTORIES: 'DIRECTORIES';
DIRECTORY: 'DIRECTORY';
DISTINCT: 'DISTINCT';
DISTRIBUTE: 'DISTRIBUTE';
DIV: 'DIV';
DO: 'DO';
DOUBLE: 'DOUBLE';
DROP: 'DROP';
ELSE: 'ELSE';
ELSEIF: 'ELSEIF';
END: 'END';
ENFORCED: 'ENFORCED';
ESCAPE: 'ESCAPE';
ESCAPED: 'ESCAPED';
EVOLUTION: 'EVOLUTION';
EXCEPT: 'EXCEPT';
EXCHANGE: 'EXCHANGE';
EXCLUDE: 'EXCLUDE';
EXISTS: 'EXISTS';
EXIT: 'EXIT';
EXPLAIN: 'EXPLAIN';
EXPORT: 'EXPORT';
EXTEND: 'EXTEND';
EXTENDED: 'EXTENDED';
EXTERNAL: 'EXTERNAL';
EXTRACT: 'EXTRACT';
FALSE: 'FALSE';
FETCH: 'FETCH';
FIELDS: 'FIELDS';
FILTER: 'FILTER';
FILEFORMAT: 'FILEFORMAT';
FIRST: 'FIRST';
FLOAT: 'FLOAT';
FLOW: 'FLOW';
FOLLOWING: 'FOLLOWING';
FOR: 'FOR';
FOREIGN: 'FOREIGN';
FORMAT: 'FORMAT';
FORMATTED: 'FORMATTED';
FOUND: 'FOUND';
FROM: 'FROM';
FULL: 'FULL';
FUNCTION: 'FUNCTION';
FUNCTIONS: 'FUNCTIONS';
GENERATED: 'GENERATED';
GEOGRAPHY: 'GEOGRAPHY';
GEOMETRY: 'GEOMETRY';
GLOBAL: 'GLOBAL';
GRANT: 'GRANT';
GROUP: 'GROUP';
GROUPING: 'GROUPING';
HANDLER: 'HANDLER';
HAVING: 'HAVING';
BINARY_HEX: 'X';
HOUR: 'HOUR';
HOURS: 'HOURS';
IDENTIFIER_KW: 'IDENTIFIER';
IDENTITY: 'IDENTITY';
IF: 'IF';
IGNORE: 'IGNORE';
IMMEDIATE: 'IMMEDIATE';
IMPORT: 'IMPORT';
IN: 'IN';
INCLUDE: 'INCLUDE';
INCREMENT: 'INCREMENT';
INDEX: 'INDEX';
INDEXES: 'INDEXES';
INNER: 'INNER';
INPATH: 'INPATH';
INPUT: 'INPUT';
INPUTFORMAT: 'INPUTFORMAT';
INSERT: 'INSERT';
INTERSECT: 'INTERSECT';
INTERVAL: 'INTERVAL';
INT: 'INT';
INTEGER: 'INTEGER';
INTO: 'INTO';
INVOKER: 'INVOKER';
IS: 'IS';
ITEMS: 'ITEMS';
ITERATE: 'ITERATE';
JOIN: 'JOIN';
JSON: 'JSON';
KEY: 'KEY';
KEYS: 'KEYS';
LANGUAGE: 'LANGUAGE';
LAST: 'LAST';
LATERAL: 'LATERAL';
LAZY: 'LAZY';
LEADING: 'LEADING';
LEAVE: 'LEAVE';
LEFT: 'LEFT';
LEVEL: 'LEVEL';
LIKE: 'LIKE';
ILIKE: 'ILIKE';
LIMIT: 'LIMIT';
LINES: 'LINES';
LIST: 'LIST';
LOAD: 'LOAD';
LOCAL: 'LOCAL';
LOCATION: 'LOCATION';
LOCK: 'LOCK';
LOCKS: 'LOCKS';
LOGICAL: 'LOGICAL';
LONG: 'LONG';
LOOP: 'LOOP';
MACRO: 'MACRO';
MAP: 'MAP' {incComplexTypeLevelCounter();};
MATCHED: 'MATCHED';
MATERIALIZED: 'MATERIALIZED';
MAX: 'MAX';
MERGE: 'MERGE';
MICROSECOND: 'MICROSECOND';
MICROSECONDS: 'MICROSECONDS';
MILLISECOND: 'MILLISECOND';
MILLISECONDS: 'MILLISECONDS';
MINUTE: 'MINUTE';
MINUTES: 'MINUTES';
MODIFIES: 'MODIFIES';
MONTH: 'MONTH';
MONTHS: 'MONTHS';
MSCK: 'MSCK';
NAME: 'NAME';
NAMESPACE: 'NAMESPACE';
NAMESPACES: 'NAMESPACES';
NANOSECOND: 'NANOSECOND';
NANOSECONDS: 'NANOSECONDS';
NATURAL: 'NATURAL';
NO: 'NO';
NONE: 'NONE';
NOT: 'NOT';
NULL: 'NULL';
NULLS: 'NULLS';
NUMERIC: 'NUMERIC';
NORELY: 'NORELY';
OF: 'OF';
OFFSET: 'OFFSET';
ON: 'ON';
ONLY: 'ONLY';
OPTION: 'OPTION';
OPTIONS: 'OPTIONS';
OR: 'OR';
ORDER: 'ORDER';
OUT: 'OUT';
OUTER: 'OUTER';
OUTPUTFORMAT: 'OUTPUTFORMAT';
OVER: 'OVER';
OVERLAPS: 'OVERLAPS';
OVERLAY: 'OVERLAY';
OVERWRITE: 'OVERWRITE';
PARTITION: 'PARTITION';
PARTITIONED: 'PARTITIONED';
PARTITIONS: 'PARTITIONS';
PERCENTLIT: 'PERCENT';
PIVOT: 'PIVOT';
PLACING: 'PLACING';
POSITION: 'POSITION';
PRECEDING: 'PRECEDING';
PRIMARY: 'PRIMARY';
PRINCIPALS: 'PRINCIPALS';
PROCEDURE: 'PROCEDURE';
PROCEDURES: 'PROCEDURES';
PROPERTIES: 'PROPERTIES';
PURGE: 'PURGE';
QUARTER: 'QUARTER';
QUERY: 'QUERY';
RANGE: 'RANGE';
READS: 'READS';
REAL: 'REAL';
RECORDREADER: 'RECORDREADER';
RECORDWRITER: 'RECORDWRITER';
RECOVER: 'RECOVER';
RECURSION: 'RECURSION';
RECURSIVE: 'RECURSIVE';
REDUCE: 'REDUCE';
REFERENCES: 'REFERENCES';
REFRESH: 'REFRESH';
RELY: 'RELY';
RENAME: 'RENAME';
REPAIR: 'REPAIR';
REPEAT: 'REPEAT';
REPEATABLE: 'REPEATABLE';
REPLACE: 'REPLACE';
RESET: 'RESET';
RESPECT: 'RESPECT';
RESTRICT: 'RESTRICT';
RETURN: 'RETURN';
RETURNS: 'RETURNS';
REVOKE: 'REVOKE';
RIGHT: 'RIGHT';
RLIKE: 'RLIKE' | 'REGEXP';
ROLE: 'ROLE';
ROLES: 'ROLES';
ROLLBACK: 'ROLLBACK';
ROLLUP: 'ROLLUP';
ROW: 'ROW';
ROWS: 'ROWS';
SECOND: 'SECOND';
SECONDS: 'SECONDS';
SCHEMA: 'SCHEMA';
SCHEMAS: 'SCHEMAS';
SECURITY: 'SECURITY';
SELECT: 'SELECT';
SEMI: 'SEMI';
SEPARATED: 'SEPARATED';
SERDE: 'SERDE';
SERDEPROPERTIES: 'SERDEPROPERTIES';
SESSION_USER: 'SESSION_USER';
SET: 'SET';
SETMINUS: 'MINUS';
SETS: 'SETS';
SHORT: 'SHORT';
SHOW: 'SHOW';
SINGLE: 'SINGLE';
SKEWED: 'SKEWED';
SMALLINT: 'SMALLINT';
SOME: 'SOME';
SORT: 'SORT';
SORTED: 'SORTED';
SOURCE: 'SOURCE';
SPECIFIC: 'SPECIFIC';
SQL: 'SQL';
SQLEXCEPTION: 'SQLEXCEPTION';
SQLSTATE: 'SQLSTATE';
START: 'START';
STATISTICS: 'STATISTICS';
STORED: 'STORED';
STRATIFY: 'STRATIFY';
STREAM: 'STREAM';
STREAMING: 'STREAMING';
STRING: 'STRING';
STRUCT: 'STRUCT' {incComplexTypeLevelCounter();};
SUBSTR: 'SUBSTR';
SUBSTRING: 'SUBSTRING';
SYNC: 'SYNC';
SYSTEM_TIME: 'SYSTEM_TIME';
SYSTEM_VERSION: 'SYSTEM_VERSION';
TABLE: 'TABLE';
TABLES: 'TABLES';
TABLESAMPLE: 'TABLESAMPLE';
TARGET: 'TARGET';
TBLPROPERTIES: 'TBLPROPERTIES';
TEMPORARY: 'TEMPORARY' | 'TEMP';
TERMINATED: 'TERMINATED';
THEN: 'THEN';
TIME: 'TIME';
TIMEDIFF: 'TIMEDIFF';
TIMESTAMP: 'TIMESTAMP';
TIMESTAMP_LTZ: 'TIMESTAMP_LTZ';
TIMESTAMP_NTZ: 'TIMESTAMP_NTZ';
TIMESTAMPADD: 'TIMESTAMPADD';
TIMESTAMPDIFF: 'TIMESTAMPDIFF';
TINYINT: 'TINYINT';
TO: 'TO';
EXECUTE: 'EXECUTE';
TOUCH: 'TOUCH';
TRAILING: 'TRAILING';
TRANSACTION: 'TRANSACTION';
TRANSACTIONS: 'TRANSACTIONS';
TRANSFORM: 'TRANSFORM';
TRIM: 'TRIM';
TRUE: 'TRUE';
TRUNCATE: 'TRUNCATE';
TRY_CAST: 'TRY_CAST';
TYPE: 'TYPE';
UNARCHIVE: 'UNARCHIVE';
UNBOUNDED: 'UNBOUNDED';
UNCACHE: 'UNCACHE';
UNION: 'UNION';
UNIQUE: 'UNIQUE';
UNKNOWN: 'UNKNOWN';
UNLOCK: 'UNLOCK';
UNPIVOT: 'UNPIVOT';
UNSET: 'UNSET';
UNTIL: 'UNTIL';
UPDATE: 'UPDATE';
USE: 'USE';
USER: 'USER';
USING: 'USING';
VALUE: 'VALUE';
VALUES: 'VALUES';
VARCHAR: 'VARCHAR';
VAR: 'VAR';
VARIABLE: 'VARIABLE';
VARIANT: 'VARIANT';
VERSION: 'VERSION';
VIEW: 'VIEW';
VIEWS: 'VIEWS';
VOID: 'VOID';
WATERMARK: 'WATERMARK';
WEEK: 'WEEK';
WEEKS: 'WEEKS';
WHEN: 'WHEN';
WHERE: 'WHERE';
WHILE: 'WHILE';
WINDOW: 'WINDOW';
WITH: 'WITH';
WITHIN: 'WITHIN';
WITHOUT: 'WITHOUT';
YEAR: 'YEAR';
YEARS: 'YEARS';
ZONE: 'ZONE';
//--SPARK-KEYWORD-LIST-END
//============================
// End of the keywords list
//============================

EQ  : '=' | '==';
NSEQ: '<=>';
NEQ : '<>';
NEQJ: '!=';
LT  : '<';
LTE : '<=' | '!>';
GT  : '>' {decComplexTypeLevelCounter();};
GTE : '>=' | '!<';
SHIFT_LEFT: '<<';
SHIFT_RIGHT: '>>' {isShiftRightOperator()}?;
SHIFT_RIGHT_UNSIGNED: '>>>' {isShiftRightOperator()}?;

PLUS: '+';
MINUS: '-';
ASTERISK: '*';
SLASH: '/';
PERCENT: '%';
TILDE: '~';
AMPERSAND: '&';
PIPE: '|';
CONCAT_PIPE: '||';
OPERATOR_PIPE: '|>';
HAT: '^';
COLON: ':';
DOUBLE_COLON: '::';
ARROW: '->';
FAT_ARROW : '=>';
HENT_START: '/*+';
HENT_END: '*/';
QUESTION: '?';

STRING_LITERAL
    : '\'' ( ~('\''|'\\') | ('\\' .) | ('\'' '\'') )* '\''
    | 'R\'' (~'\'')* '\''
    | 'R"'(~'"')* '"'
    ;

DOUBLEQUOTED_STRING
    :'"' ( ~('"'|'\\') | '""' | ('\\' .) )* '"'
    ;

// NOTE: If you move a numeric literal, you should modify `ParserUtils.toExprAlias()`
// which assumes all numeric literals are between `BIGINT_LITERAL` and `BIGDECIMAL_LITERAL`.
// 注意：如果移动数值字面量，应修改 `ParserUtils.toExprAlias()`，该方法假设所有数值字面量都位于 `BIGINT_LITERAL` 和 `BIGDECIMAL_LITERAL` 之间。

BIGINT_LITERAL
    : DIGIT+ 'L'
    ;

SMALLINT_LITERAL
    : DIGIT+ 'S'
    ;

TINYINT_LITERAL
    : DIGIT+ 'Y'
    ;

INTEGER_VALUE
    : DIGIT+
    ;

EXPONENT_VALUE
    : DIGIT+ EXPONENT
    | DECIMAL_DIGITS EXPONENT {isValidDecimal()}?
    ;

DECIMAL_VALUE
    : DECIMAL_DIGITS {isValidDecimal()}?
    ;

FLOAT_LITERAL
    : DIGIT+ EXPONENT? 'F'
    | DECIMAL_DIGITS EXPONENT? 'F' {isValidDecimal()}?
    ;

DOUBLE_LITERAL
    : DIGIT+ EXPONENT? 'D'
    | DECIMAL_DIGITS EXPONENT? 'D' {isValidDecimal()}?
    ;

BIGDECIMAL_LITERAL
    : DIGIT+ EXPONENT? 'BD'
    | DECIMAL_DIGITS EXPONENT? 'BD' {isValidDecimal()}?
    ;

// Generalize the identifier to give a sensible INVALID_IDENTIFIER error message:
// * Unicode letters rather than a-z and A-Z only
// * URI paths for table references using paths
// We then narrow down to ANSI rules in exitUnquotedIdentifier() in the parser.
// 将标识符泛化，以提供合理的 INVALID_IDENTIFIER 错误消息：
// * 支持 Unicode 字母，而不仅仅是 a-z 和 A-Z
// * 支持使用路径进行表引用的 URI 路径
// 随后我们会在解析器的 exitUnquotedIdentifier() 中将其缩小到符合 ANSI 规则的范围。
IDENTIFIER
    : (UNICODE_LETTER | DIGIT | '_')+
    | UNICODE_LETTER+ '://' (UNICODE_LETTER | DIGIT | '_' | '/' | '-' | '.' | '?' | '=' | '&' | '#' | '%')+
    ;

BACKQUOTED_IDENTIFIER
    : '`' ( ~'`' | '``' )* '`'
    ;

fragment DECIMAL_DIGITS
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

fragment EXPONENT
    : 'E' [+-]? DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [A-Z]
    ;

fragment UNICODE_LETTER
    : [\p{L}]
    ;

SIMPLE_COMMENT
    : '--' ('\\\n' | ~[\r\n])* '\r'? '\n'? -> channel(HIDDEN)
    ;

BRACKETED_COMMENT
    : '/*' {!isHint()}? ( BRACKETED_COMMENT | . )*? ('*/' | {markUnclosedComment();} EOF) -> channel(HIDDEN)
    ;

WS
    : [ \t\n\f\r\u000B\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u2028\u202F\u205F\u3000]+ -> channel(HIDDEN)
    ;

// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
// 捕获所有无法识别的内容。
// 我们使用它以便在用 DelimiterLexer 分割语句时能够忽略并恢复所有文本。
UNRECOGNIZED
    : .
    ;
