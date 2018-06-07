grammar Formula;

@header {
	//package pt.isep.nsheets.shared.core.formula.compiler;
}
	         
expression
	: EQ comparison /* EOF */
	;
	
comparison
	: concatenation
		( ( EQ | NEQ | GT | LT | LTEQ | GTEQ ) concatenation )?
	;

block
        : manyexpressions
        | FOR forexpression
        ;

forexpression
        : assignment SEMI comparison (SEMI concatenation)+ FCHA
        ;

concatenation
        : ( MINUS )? atom                                       
        | concatenation PERCENT
        | <assoc=right> concatenation POWER concatenation
        | concatenation ( MULTI | DIV ) concatenation
        | concatenation ( PLUS | MINUS ) concatenation
        | concatenation AMP concatenation
        | block
        ;
		

atom
	:	function_call
	|	reference
        |       assignment
	|	literal
	|	LPAR concatenation RPAR
        |       globalreference
	;

function_call
	:	FUNCTION LPAR
		comparison RPAR
	;

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
		| temporaryreference
	;
	
literal
	:	NUMBER
	|	STRING
        |       nameglobal
	;
	
manyexpressions
	:	ICHA comparison (SEMI comparison)* FCHA
	;
	
assignment
	:	reference ASSIGN concatenation
	;

monetary    
        : CURRENCY ICHA ACCOUNT FCHA
        ;

ACCOUNT: NUMBER COINSIGN (OPERATOR NUMBER COINSIGN)*
        ;
        
OPERATOR: PLUS 
        | MINUS 
        | DIV 
        | MULTI
        ;

CURRENCY: 'DOLLAR'
        | 'POUND'
        | 'EURO'
        ;

COINSIGN: DOLLAR
        | POUND
        | EURO
        ;

LETTER: ('a'..'z'|'A'..'Z') ;
  
FUNCTION : ( LETTER )+
	;	
	 
CELL_REF
	:	( ABS )? LETTER ( LETTER )?
		( ABS )? ( DIGIT )+
	;
	

temporaryreference
    :	temporaryreference ASSIGN concatenation
    |   UNDERSCORE LETTER+
    ;

globalreference
    :	nameglobal ASSIGN concatenation
    ;

nameglobal
    :   ARROBA ( LETTER )+
    ;

/* String literals, i.e. anything inside the delimiters */
STRING  : QUOT ('\\"' | ~'"')* QUOT
        ;


QUOT: '"' 
	;

/* Numeric literals */
NUMBER: DIGITNOTZERO ( DIGIT )* FRACTIONALPART? 
        | DIGIT FRACTIONALPART
        ;
		
FRACTIONALPART:  COMMA  DIGIT DIGIT
                | DOT DIGIT DIGIT
                ;

DIGIT : '0'..'9' ;
DIGITNOTZERO : '1'..'9' ;

/* Comparison operators */
EQ	: '=' ;
NEQ	: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT	: '>' ;
LT	: '<' ;

/* Text operators */
AMP	: '&' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV	: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;
UNDERSCORE : '_' ;
ARROBA : '@' ;
 
/* Miscellaneous operators */
COMMA	: ',' ;
DOT     : '.' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
ICHA	: '{' ;
FCHA	: '}' ;
LBRACKET : '[' ;
RBRACKET : ']' ;

/* Coin Signs */
EURO : '\u20AC' ;
DOLLAR : '\u0024' ;
POUND : '\u00A3' ;

/* Assignment Operator */
ASSIGN 	: ':=' ;

/* For Operator */
FOR : 'FOR{';	

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;