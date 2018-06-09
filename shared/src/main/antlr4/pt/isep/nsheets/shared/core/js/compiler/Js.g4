grammar Js;

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | if_stat
 | while_stat
 | log
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

assignment
 : 'var'? ID ASSIGN expr SCOL
 ;

if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : OPAR expr CPAR stat_block
 ;

stat_block
 : OBRACE block CBRACE
 | stat
 ;

while_stat
 : WHILE OPAR expr CPAR stat_block
 ;

log
 : LOG OPAR expr CPAR SCOL
 ;

expr
 : expr POW OPAR atom COMMA atom CPAR expr        #powExpr
 | MINUS expr                                     #unaryMinusExpr
 | NOT expr                                       #notExpr
 | expr op=(MULT | DIV | MOD) expr                #multiplicationExpr
 | expr op=(PLUS | MINUS) expr                    #additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr           #relationalExpr
 | expr op=(EQ | NEQ) expr                        #equalityExpr
 | expr AND expr                                  #andExpr
 | expr OR expr                                   #orExpr
 | atom                                           #atomExpr
 ;

atom
 : OPAR expr CPAR #parExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 | NIL            #nilAtom
 ;

OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
NOT : '!';

POW : 'Math.pow';

COMMA : ',';
SCOL : ';';
ASSIGN : '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';

TRUE : 'true';
FALSE : 'false';
NIL : 'null';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
LOG : 'console.log';

ID
 : ('$')? [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]*
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : '//' ~[\r\n]* -> skip
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

OTHER
 : .
 ;