**Hernâni Gil** (1050475) - Sprint 1 - Lang03.1
===============================

# 1. General Notes

Helped in the creating of the codeUI from Issue Lang06.1
Tried to Implement the Cell"Style"Extension that might be the Core08.1 to apply and me to use. But no success, however, the CellStyleExtension was created.


# 2. Requirements

Lang03 - Tools based on Formulas


Lang03.1 - Conditional Formating of Cells

Update the "style" extension so that it can be used for the conditional formatting of cells based on the result of the execution of formulas. For the style of a cell to be conditional it must have an associated formula and two formatting styles. 
One of the styles is applied when the formula evaluates to true and the other when it evaluates to false. The editing of these settings should be done in a window.

US1 - create UI dialog in the WorkbookView to select the conditional formatting options. after selecting a select by a click (activeCell), the option Icon IconType="SETTINGS" on the right, opens dialog
where it is possible to select the condition: "equal", "greater than", "less than", "equal or greater than", "equal or less than", "different than" or "between". There are formatting settings to be 
selected for both expecting results, True or False. The basic settings expected are backgroundColor, fontColor. This functionality depends on UC08.1 funcionalities provided by other collaborator.
 When "Done" button is pressed, Controller is instanced. When the "Close" button is pressed, everything is canceled.

US2 - after the "done" button is pressed, the conditionalFormattingController is created and will get the data of the Cell, Formatting settings and the condition for true and false. The condition must persist 
with the cell and change whenever the cell value changes.

US3 - Anytime the result is calculated, the style extensions shall be set depending on the result and settings selected in US1.


# 3. Analysis

Classes created:
Conditional - this class contains all the conditional info and the Configuration class, reused from Core02.1. this Configuration class has formatting value for positive and negative also a binary result.
Conditional class is stored with a cell reference in the ConditionalFormattingExtension.

Solving strategies: 

When the Sheetsreap is rendered, each cell is verified so we can verify their value. We can verify if the cell is present in this list and update the formatting settings. Also when the 
value of a Cell changes, it fires twice to CellListeners and CellEXtensions. This event makes posible to update the cell formatting layout. Also, when it has a method to remove a conditional. this way we can create and 
add a new one when the settings are changed.



*In this section you should describe the study/analysis/research you developed in order to design a solution.*

For this feature increment, since it is the first one to be developed in a new project I need to:  

- Understand how the application works and also understand the key aspects of GWT, since it is the main technology behind the application
Shall create a Dialog in the Workbook section for a fast change of settings. The window must permit the set of the relational operation, condition value and formatations for true and false results.

- Understand how the Home Page is implemented (for instance, how the UI gets the Workbook Descriptions that are displayed)  
The Workook view implements the WorkbookPresenter.view. the Second class is were we are able to change the color of the cell. However, tried to change the Core02.1 to fill the cell with color, but when I do it
with the function sizePixel("","") the cell can't resize anymore and the values if too extense, then get out of the cell.

- Understand how to integrate a relational database into the project (Will be assuming JPA since it is studied in EAPLI)  
The controller GWT UI and the controller cant operate directly. So we implement services with Asyncronous connection.  
 
Tests:

the functional tests shall verify if: 
Conditional instances are store in the repository.
If any time the workbout open, the conditions are uploaded.
If anytime a instance Conditional is created, is saved in the Extension and in the repository.
If the BinaryOperationExtension does all the operations available in the UI listbox.
If validates the value as numeric
If everytime the valueOf the cell changes, the color is changes in accordance.


# 6. Integration/Demonstration

public class ConditionalFormattingExtension extends Extension {
    public static List<Conditional> lstConditional = new ArrayList<Conditional>();

    public ConditionalFormattingExtension(String name) {
        super(name);
    }

    public static List<Conditional> getLstConditional(){return lstConditional;}

    public static void setLstConditional(List<Conditional> conditionalList) {
        lstConditional = conditionalList;
    }

    public static void addConditional(Conditional conditional){
        lstConditional.add(conditional);
    }

    public static Conditional containsCondition(Cell cell){
        for(Conditional c : lstConditional){
            if(c.getCell().compareTo(cell) == 0){
                return c;
            }
        }
        return null;
    }

    public static void removeConditional(Cell cell){
        if(lstConditional != null){
            for(Conditional conditional : lstConditional){
                if(conditional.getCell().compareTo(cell) == 0){
                    lstConditional.remove(conditional);
                }
            }
        }
    }

    public CellExtension extend(CellExtension cell) {
        if(lstConditional != null){
            for(Conditional conditional : lstConditional){
                if(conditional.getCell().compareTo(cell) == 0){
                    return new ConditionalFormattingCellExtension(cell, getName(), conditional.getCondOperator(), conditional.getCondValue() );
                }
            }
        }
        return null;
    }

    public static boolean setOperation(Cell cell, String conditionOperator, Value conditionValue){
        try {
            BinaryOperationExtension binaryOperation = new BinaryOperationExtension(cell.getValue(), conditionOperator, conditionValue);
            return binaryOperation.evaluate().toBoolean();
        } catch (NullPointerException | UnknownElementException | IllegalValueTypeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public class ConditionalFormattingCellExtension extends CellExtension {
        private String conditionOperator;
        private Value conditionValue;
        private boolean result;

        public ConditionalFormattingCellExtension(Cell delegate, String name, String conditionOperator, Value conditionValue) {
            super(delegate, name);
            this.conditionOperator = conditionOperator;
            this.conditionValue = conditionValue;
        }


        @Override
        public void valueChanged(Cell cell) {
            this.result = ConditionalFormattingExtension.setOperation(cell, conditionOperator, conditionValue);
            if (result) {
                    //change CellExtensionStyle colors when true
                    //fire styleTRUE listener
                    //
                    //this.getDelegate().getExtension("StyleChange");
            } else {
                //change CellExtensionStyle colors when false
                //fire styleFalse listener
                    //this.getDelegate().getExtension("StyleChange");
            }
        }

  
 

# 7. Final Remarks 

I could complete the sprint on time. Too worried about the dependency of my UC and I started to try to solve both. In the end, the plan wasn't balanced. Should focus on my UC and worry about its conclusion. In the end, next
time I shall start with the core and think about the UI after. Lost first days wondering how it works. It is the less important thing in this UC.

Some Questions/Issues identified during the work in this feature increment:

1. To complete this UC we need the Core08.1 as mention and to adapt the events to this new feature as shown in the Lang03.1 Sequence Diagram

2. The persistence of the Conditional class has a bug. it is in the Class ConditionalServiceAsync:
  void getListConditional(AsyncCallback<ArrayList<ConditionalDTO>> async)
  the services werent corrected on time with ArrayList<(...)>

# 8. Work Log

*Insert here a log of you daily work. This is in essence the log of your daily work. It should reference your commits as much as possible.*

Commits:

[#55] Lang03.1 Conditional formatting Cell dialog UI - WorkbookView	(https://bitbucket.org/lei-isep/lapr4-18-2db/commits/913c7248954262095344280597bb9a63b2f04a86)
[#67] Lang07.1 UI created (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/a3771e5993196f621d6b31cc0fc1ee5d51d5f729)
[#55] Lang03.1 - Formula/BinaryOperationExtension: (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/5c5d07af27a5e49a540077d0b8677307e42af820)
- construtor for String operator (operator is verified if exists in the Language "excel"
- Values are converted as new Literal extends Expression
- relationalOperations are working 100%
[#55] Lang03.1 - Extension ConditionalFormattingExtension created (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/b907030de9d729e376559a9f6561b12418da6fd1)
[#55] Lang03.1 - UI updates (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/744fd09c77d136bbb7092cbe48604e8e16cb905f)
[#55] Lang03.1 - ConditionalCellFormattingController (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/d577e06b55a167b80c43a3c85a61acab002f4f13)
[#55] Lang03.1: (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/427bf61876d1c8cbdf042c7b540b4d66a48034dc)
1. Conditional object with conditionValue and conditionOperator to calculate
the formatting condition.
2. Conditonal persistence created to persist the Conditions related to the cell
[#55] Configuration implementing Serializable (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/7ceebe9fc3f1564de3d347b82fb091438a6007c7)
[#55] Conditional JPa and Contional Repository created (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/b748cd766d2c82187a5594671f7b0fcf2d86a120)
[#55] Lang03.1 - UI for conditionalModal updated to offer colors from gwt (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/7512fd708a2d74644806bad30c1aee5af7122fbc)
[#55] Lang03.1: Conditional class persistence. A small unknown compilation bug in the ConditionalService result (commented the issues: https://bitbucket.org/lei-isep/lapr4-18-2db/commits/2f5e3db8ab9e5be00bf20eeb152c665d96661aef)
[#55] Lang03.1 ConditionalFormattingExtension (no StyleExtensions. Tried two different aproachs parcially commented. need Core08.1 https://bitbucket.org/lei-isep/lapr4-18-2db/commits/4a93792a00c0cd66c2ede6f9b4f63e98f11e1854)
stores Conditional with conditions and formatting configs
[#55] Lang03.1 - UC can verify if the condition is true or false but lack o Core funcionality to change colors in cell (https://bitbucket.org/lei-isep/lapr4-18-2db/commits/cc6ae8402566fe1be859414945b0a8cbc342b657)
[#55] CellStyleExtension created to StyleExtension but incomplete [extra UC boundaries](https://bitbucket.org/lei-isep/lapr4-18-2db/commits/de7a056bcde222a4bd19bbed1cf4ba4e8257beb1)







