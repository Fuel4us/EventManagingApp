grammar Macro;

@header {
	//package pt.isep.nsheets.shared.core.formula.compiler;
}

expression:
	expression comparison
	| expression comment
	| comparison
	| comment;

comparison: 
	concatenation ((EQ | NEQ | GT | LT | LTEQ | GTEQ) concatenation)?;

comment: 
	COMMENT;

concatenation: 
	(MINUS)? atom
	| concatenation PERCENT
	| <assoc = right> concatenation POWER concatenation
	| concatenation ( MULTI | DIV) concatenation
	| concatenation ( PLUS | MINUS) concatenation
	| concatenation AMP concatenation
	| block;

atom:
	function_call
	| reference
	| assignment
	| literal
	| LPAR concatenation RPAR
	| temporaryreference;

block: 
	manyexpressions 
	| FOR forexpression;

manyexpressions:
	ICHA comparison (SEMI comparison)* FCHA;

forexpression: 
	assignment SEMI comparison (SEMI concatenation)+ FCHA;

function_call: 
	FUNCTION LPAR comparison RPAR;

reference: 
	CELL_REF ( ( COLON) CELL_REF)? | NAMEGLOBAL;

assignment: 
	reference ASSIGN concatenation;

literal: 
	NUMBER | STRING | nameTemporary | NAMEGLOBAL;

temporaryreference: 
	nameTemporary ASSIGN concatenation;

LETTER: 
	('a' ..'z' | 'A' ..'Z');

FUNCTION: 
	( LETTER)+;

CELL_REF: 
	( ABS)? LETTER ( LETTER)? ( ABS)? ( DIGIT)+;

nameTemporary: 
	UNDERSCORE ( LETTER)+;

NAMEGLOBAL: 
	ARROBA ( LETTER)+;





/* String literals, i.e. anything inside the delimiters */
STRING: 
	QUOT ('\\"' | ~'"')* QUOT;

QUOT: 
	'"';

/* Numeric literals */
NUMBER:
	DIGITNOTZERO (DIGIT)* FRACTIONALPART?
	| DIGIT FRACTIONALPART;

FRACTIONALPART: 
	(COMMA|DOT) DIGIT DIGIT?;

DIGIT: '0' ..'9';

DIGITNOTZERO: '1' ..'9';

/* Comparison operators */
EQ: '=';
NEQ: '<>';
LTEQ: '<=';
GTEQ: '>=';
GT: '>';
LT: '<';

/* Text operators */
AMP: '&';

/* Arithmetic operators */
PLUS: '+';
MINUS: '-';
MULTI: '*';
DIV: '/';
POWER: '^';
PERCENT: '%';

/* Reference operators */
fragment ABS: '$';
fragment EXCL: '!';
COLON: ':';
UNDERSCORE: '_';
ARROBA: '@';

/* Miscellaneous operators */
COMMA: ',';
DOT: '.';
SEMI: ';';
LPAR: '(';
RPAR: ')';
ICHA: '{';
FCHA: '}';
LBRACKET: '[';
RBRACKET: ']';

/* Assignment Operator */
ASSIGN: ':=';

/* For Operator */
FOR: 'FOR{';

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t') -> skip;

COMMENT: SEMI ~[\r\n]* -> skip;
