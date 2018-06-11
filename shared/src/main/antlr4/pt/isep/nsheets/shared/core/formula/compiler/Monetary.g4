grammar Monetary;

@header {
	//package pt.isep.nsheets.shared.core.formula.compiler;
}
start: expression EOF
     ;
	         
expression: HH currency ICHA account FCHA 
	  ;

account: number coinsign ( operator number coinsign )*
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

coinsign: SIGNDOLLAR
        | SIGNPOUND
        | SIGNEURO
        ;

/* Numeric Monetary */
number: DIGIT (DIGIT)* fractionalpart?
      ;
	
fractionalpart: DOT DIGIT 
              | DOT DIGIT DIGIT 
              ;  

/* Numerics */
DIGIT : '0'..'9' ;


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
SIGNEURO : '\u20AC' ;
SIGNDOLLAR : '\u0024' ;
SIGNPOUND : '\u00A3' ;

/* White-space (ignored) */
WS : ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;