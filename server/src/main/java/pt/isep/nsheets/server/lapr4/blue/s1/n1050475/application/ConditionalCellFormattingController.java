package pt.isep.nsheets.server.lapr4.blue.s1.n1050475.application;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.CellExtension;
import pt.isep.nsheets.shared.ext.ExtensionManager;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.Formula.BinaryOperationExtension;
import pt.isep.nsheets.shared.core.formula.lang.*;


import java.text.ParseException;

public class ConditionalCellFormattingController {
    private Cell cell;
    private CellExtension cellExt;
    private final String EXTENSIONNAME = "Conditional Formatting Extension";
    private String operator;
    private Value conditionValue;
    private String backgroundColorTrue;
    private String fontColorTrue;
    private String backgroundColorFalse;
    private String fontColorFalse;

    public ConditionalCellFormattingController(Cell cell, String operator, String conditionValue){
        this.cell = cell;
        this.cellExt = (CellExtension)cell.getExtension(EXTENSIONNAME);
        this.operator = operator;
        try {
            this.conditionValue = Value.parseNumericValue(conditionValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setBackgroundColorTrue(String backgroundColorTrue) {
        this.backgroundColorTrue = backgroundColorTrue;
    }

    public void setBackgroundColorFalse(String backgroundColorFalse) {
        this.backgroundColorFalse = backgroundColorFalse;
    }

    public void setFontColorTrue(String fontColorTrue){
        this.fontColorTrue = fontColorTrue;
    }

    public void setFontColorFalse(String fontColorFalse) {
        this.fontColorFalse = fontColorFalse;
    }
/*
    public boolean ConditionalOperation(){


        ConditionalFormattingCellExtension cellExt = new ConditonalCellExtension();

        try {

            BinaryOperationExtension binaryOperation = new BinaryOperationExtension(this.cell.getValue(), this.operator, this.conditionValue);

            return binaryOperation.evaluate().toBoolean();
        } catch (IllegalValueTypeException | UnknownElementException e) {
            return false;
        }
    }*/
}
