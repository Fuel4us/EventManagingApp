**Hilário Coelho** (1160557) - Sprint 3 - Core 01.3
===============================

# 1. General Notes

Got some help from Gonçalo Fonseca

# 2. Requirements

*Core01.3 - Full Extension Mechanism - Description:*
"It should be possible to open several workbooks at the same time. It should be possible to make references between workbooks in the formulas."


# 3. Analysis

Upodated Settings class to support a list of workbooks which is gonna hold all opened workbooks.

Solving strategies: 

When an user opens a workbook, the workbook is stored in the List of settings class with all the other previosuly opened workbooks. An user can closes a previosly opened workbook anytime by pressing the close button.

When a workbook is *revealed*, the page renders a collection of all opened workbooks.

For this feature increment, since it is the third I needed to: 

- Understand how to store the opened workbooks.

- Understand how to get the current workbook.

# 4. Design


## 4.1. Tests
 
Tests:

the functional tests shall verify if: 
When an user enters a workbook, it is being stored in the collection list
When an user enters another workbook, the list displays all previously opened workbooks
When an user closes a workbook, the closed workbook is being removed from the list

## 4.2. Requirements Realization

## 4.3. Classes

## 4.4. Design Patterns and Best Practices
- MVP
- Singleton

# 5. Implementation

Para a implementação deste UC primeiro tive de adaptar a UI do workbook de modo a mostrar todas as workbooks abertas. Tive de obter a workbook aberta e grava-la numa lista que persistisse entre mudanças de página (a classe *Settings*) e renderizar a lista quando uma workbook é aberta. Também foi necessário adicionar um botão para remover as workbooks abertas.

# 6. Integration/Demonstration


# 7. Final Remarks 

Visto o UC anterior não ter sido feito e haver muitas deficiências no nosso programa, foi-me impossível fazer a segunda parte do UC, ou seja, referenciar células de outras workbooks. Os principais problemas que detetei:
Não haver múltiplas spreadsheets para uma workbook
As alterações nas workbooks não serem persistidas na base de dados
Quando se altera uma workbook, todas as outras são também alteradas da mesma forma.

# 8. Work Log

Commits:

[Documentation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/1d67bf96daf9a70dd6af412e71e65a38b937c21b)

[Open Workbooks List](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/9ff73ebb19c5015824c144d3d2c489b1bd49345d)

[Documentation](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/9c0feb93241c963a6e0392ac75bb0cce6ddffb4b)

