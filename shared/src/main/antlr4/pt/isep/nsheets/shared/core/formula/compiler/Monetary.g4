grammar Monetary;

@header {
	//package pt.isep.nsheets.shared.core.formula.compiler;
}
	         
expression
        : HH monetary /* EOF */
	;

monetary    
        : currency ICHA account FCHA
        ;

account: number coinsign (operator number coinsign)*
        ;
        
operator: PLUS 
        | MINUS 
        | DIV 
        | MULTI
        ;

currency: 'dollar'
        | 'pound'
        | 'euro'
        ;

coinsign: DOLLAR
        | POUND
        | EURO
        ;

/* Numeric Monetary */
number: DIGITNOTZERO ( DIGIT )* fractionalpart? 
        | DIGIT fractionalpart
        ;
		
fractionalpart: 
                DOT DIGIT DIGIT?
                ;

DIGIT : '0'..'9' ;
DIGITNOTZERO : '1'..'9' ;


/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV	: '/' ;

/* Reference operators */
HH : '#' ; 

/* Miscellaneous operators */
DOT     : '.' ;
ICHA	: '{' ;
FCHA	: '}' ;

/* Coin Signs */
EURO : '\u20AC' ;
DOLLAR : '\u0024' ;
POUND : '\u00A3' ;

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;