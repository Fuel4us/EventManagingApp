grammar Vb;

parse: block EOF;

block: stat*;

function: initFunction stat* returnFunction endFunction;

initFunction: 'Function' functionName 'As' type;

functionName: ID OPAR /*parameters*/ CPAR;

returnFunction: 'Return' ID;

endFunction: 'End' 'Function';

functionCall: functionName;

parameters: type ID COMMA parameters | type ID;

/*procedure: initProcedure stat* endProcedure;

initProcedure: 'Sub' procedureName;

procedureName: ID OPAR CPAR;

endProcedure: 'End' 'Sub';*/

stat:
	assignment
	| declaration
	| if_stat
	| while_stat
	| log
	| function
	| functionCall
	| OTHER {System.err.println("unknown char: " + $OTHER.text);};

declaration: 'Dim' ID 'As' type;

assignment: ID ASSIGN expr;

if_stat:
	IF condition_block_if (ELSE IF condition_block_if)* (
		ELSE stat_block_if
	)?;

condition_block_if: expr stat_block_if;

stat_block_if: OPENIF block CLOSEIF | stat;

while_stat: WHILE expr stat_block_while;

stat_block_while: block ENDWHILE;

log: LOG expr;

expr:
	expr POW <assoc = right> expr				# powExpr
	| MINUS expr								# unaryMinusExpr
	| NOT expr									# notExpr
	| expr op = (MULT | DIV | MOD) expr			# multiplicationExpr
	| expr op = (PLUS | MINUS) expr				# additiveExpr
	| expr op = (LTEQ | GTEQ | LT | GT) expr	# relationalExpr
	| expr op = (EQ | NEQ) expr					# equalityExpr
	| expr AND expr								# andExpr
	| expr OR expr								# orExpr
	| atom										# atomExpr;

atom:
	OPAR expr CPAR		# parExpr
	| (INT | FLOAT)		# numberAtom
	| (TRUE | FALSE)	# booleanAtom
	| ID				# idAtom
	| STRING			# stringAtom
	| NIL				# nilAtom;

type: TYPE_INT | TYPE_FLOAT | TYPE_STRING;

TYPE_INT: 'Integer';
TYPE_FLOAT: 'Float';
TYPE_STRING: 'String';

OR: '||';
AND: '&&';
EQ: '==';
NEQ: '<>';
GT: '>';
LT: '<';
GTEQ: '>=';
LTEQ: '<=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
POW: '^';
NOT: '!';

COMMA: ',';
SCOL: ';';
ASSIGN: '=';
OPAR: '(';
CPAR: ')';
OPENIF: 'Then';
CLOSEIF: 'End' ' ' 'If';
ENDWHILE: 'End' ' ' 'While';

TRUE: 'true';
FALSE: 'false';
NIL: 'nil';
IF: 'If';
ELSE: 'Else';
WHILE: 'While';
LOG: 'Log';

ID: ('$')? [a-zA-Z_] [a-zA-Z_0-9]*;
INT: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]* | '.' [0-9]+;
STRING: '"' (~["\r\n] | '""')* '"';
COMMENT: '#' ~[\r\n]* -> skip;
SPACE: [ \t\r\n] -> skip;
OTHER: .;