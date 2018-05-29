**Pedro António de Moura Alves** (1150372)
===============================

# 1. Documentation for Sprint 1


|Sprint  | Area | 
|--------|------|
| **1**  | Lang | 

Lang01.1 - Block of Instructions

Add the possibility of writing blocks (or sequences) of instructions. 
A block must be delimited by curly braces and its instructions must be separated by ";". 
The instructions of a block are executed sequentially and the block "result" is the result of the last statement of the block. 
For example, the formula "= {1+ 2; sum (A1:A10); B3 + 4 }" must result in the sequential execution of all expressions and the result is the value of the expression "B3 + 4". 
Add the assign operator (its symbol is ":="). 
This operator assigns to its left the result of the right expression. 
At the moment the left of the assign operator can only be a cell reference. 
The FOR loop should also be implemented based on instruction blocks. 
For example, the formula"= FOR {A1: = 1 ; A1<10; A2: = A2 + A1; A1: = A1 + 1 }" executes a for loop in which: the first expression is the initialization, the second term is the boundary condition, all other expressions are performed for each iteration of the loop.																		
