**Hilário Coelho** (1160557) - Sprint 2 - Lang03.2
===============================

# 1. General Notes

Fixed an issue retrieving multiple conditions from Persistence

# 2. Requirements

Lang03 - Tools based on Formulas


Lang03.2 - Conditional Formating of Cells

US1 - Create conditions for multiple cells within a range at once.

US2 - Remove conditions for a cell or multiple cells within a range.


# 3. Analysis

Classes created:
ConditionalRangeDTO - This class contains multiple conditions to apply at once

Solving strategies: 

When an user clicks on the Range Condition button, it should prompt the user to select the range of cells to apply the condition. If the user clicks to modify a specific cell, the range of cells is not displayed and the user will create a condition to that specific cell.



*In this section you should describe the study/analysis/research you developed in order to design a solution.*

For this feature increment, since it is the second I needed to: 

- Understand what was done and what was not completed in the first sprint regarding to what I was dependant on.

- Understand the concept of range of cells.
 
Tests:

the functional tests shall verify if: 
Conditional instances are stored in the repository.
If anytime the workbook is opened, the conditions are retrieved from the database.
If anytime an Conditional instance is created it is saved in the Extension and in the repository.
If when creating a Conditional for a range of cells it is being stored in the DB a conditional for each cell within the range.
If when deleting a conditional for a specific cell or a range of cells, it is being removed from the DB.

# 5. Implementation

Para a implementação deste UC, quando o utilizador clica no botão "Range Condition" é instanciada uma modal onde o utilizador pode definir a condição bem como a Range de cells que serão abrangidas pela condição. Ao submeter os dados da modal será feita uma iteração por todas as células que se situam dentro da establecida range instanciando um objecto Conditional para cada célula.
Para persistir na base de dados, foi criado um DTO que guarda uma lista de ConditionalDTO para que num só request ao servidor sejam gravadas todas as conditions da range.

Para o US2 o processo é idêntico.

# 6. Integration/Demonstration


# 7. Final Remarks 

# 8. Work Log

Commits:

[Range Condition UI](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/9570e13fe38366b6d485c524f8c1114d2c8a38ce)

[Range Condition UI fix](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/2c95a43a1bb9e676ab8c3d7f2b64f12e94f45f3f)  

[Range Condition Apply](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/7df4e9879275eae1cca0300ffe3157d47949883c)

[Conditions and Range Conditions persistence, DB store and retrieve](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/df2a910b21840a86d159926ede94e53345449780)

[Documentation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/47a41cfbbc07db38c915b8bcb3bc5a1322e91cfb)

[Cell Style Changing](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/c8b84dc879c2a0d97b024e1327d93042dcdcbe1f)

