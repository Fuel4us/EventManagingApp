package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions;

import java.util.List;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import pt.isep.nsheets.shared.ext.CellExtension;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.Formula.BinaryOperationExtension;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.services.ChartDTO;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.core.StyleCell;
import pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables.TemporaryVariable;

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

        @Override
        public CellDTO toDTO() {
            return this.getDelegate().toDTO();
        }

        @Override
        public List<TemporaryVariable> tempVariableList() {
            return this.tempVariableList();
        }

        @Override
        public boolean addTempVariable(TemporaryVariable tempVariable) {
            return tempVariableList().add(tempVariable);
        }

        @Override
        public void setStyle(StyleCell style) {
            this.getDelegate().setStyle(style);
        }

        @Override
        public StyleCell style() {
            return this.getDelegate().style();
        }


    }
}