grammar Formula;

@header {
	//package pt.isep.nsheets.shared.core.formula.compiler;
}
	         
expression
	: EQ comparisonGlobal EOF
	;
	
comparisonGlobal
	: ICHA? comparison FCHA?
	| FOR ICHA concatenationFor FCHA
	;
	
comparison
	: concatenation
		( (sinal) concatenation )? (SEMI comparison)?
	;
	
concatenationFor
	:	((assignment) SEMI)? (comparison SEMI)? CELL_REF sinal concatenation SEMI assignment
	;

sinal
	:	( EQ | NEQ | GT | LT | LTEQ | GTEQ )
	;

concatenation
        : ( MINUS )? atom                                       
        | concatenation PERCENT
        | <assoc=right> concatenation POWER concatenation
        | concatenation ( MULTI | DIV ) concatenation
        | concatenation ( PLUS | MINUS ) concatenation
        | concatenation AMP concatenation
        ;
		

atom
	:	function_call
	|	reference
	|	literal
	|	LPAR concatenation RPAR
	|   assignment
	;

function_call
	:	FUNCTION LPAR
		comparison RPAR
	;

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
		| temp_reference
	;
	
literal
	:	NUMBER
	|	STRING
	;
	
assignment
	: 	CELL_REF ASSIGN concatenation
	;

LETTER: ('a'..'z'|'A'..'Z') ;
  
FUNCTION : 
	  ( LETTER )+ 
	;	
	 
 
CELL_REF
	:	( ABS )? LETTER ( LETTER )?
		( ABS )? ( DIGIT )+
	;
	

temp_reference
    :	UNDERSCORE LETTER+ ( LBRACKET DIGIT RBRACKET )?
	;

/* String literals, i.e. anything inside the delimiters */
STRING  : QUOT ('\\"' | ~'"')* QUOT
        ;


QUOT: '"' 
	;

/* Numeric literals */
NUMBER: DIGITNOTZERO ( DIGIT )+ FRACTIONALPART? 
		| DIGIT FRACTIONALPART;
		
FRACTIONALPART: ( COMMA ( DIGIT )+ );

DIGIT : '0'..'9' ;
DIGITNOTZERO : '1'..'9' ;

/* Comparison operators */
EQ		: '=' ;
NEQ		: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV		: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;
UNDERSCORE : '_' ;
 
/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
ICHA	: '{' ;
FCHA	: '}' ;
LBRACKET : '[' ;
RBRACKET : ']' ;

/* Assignment Operator */
ASSIGN 	: ':=' ;

/* For Operator */
FOR : 'FOR';	

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;
	
	
 