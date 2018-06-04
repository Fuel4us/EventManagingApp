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

public class ConditionalFormattingExtension extends Extension {

    public ConditionalFormattingExtension(String name) {
        super(name);
    }

    public CellExtension extend(CellExtension cell) {
        return new ConditionalFormattingCellExtension(cell, getName());
    }

    class ConditionalFormattingCellExtension extends CellExtension {

        private Value conditionValue;
        private String conditionOperator;
        private boolean result;

        public ConditionalFormattingCellExtension(Cell delegate, String name) {
            super(delegate, name);
        }

        public void setConditionValue(Value conditionValue) {
            this.conditionValue = conditionValue;
        }

        public void setConditionOperator(String operator) {
            this.conditionOperator = conditionOperator;
        }

        @Override
        public void valueChanged(Cell cell) {
            try {
                BinaryOperationExtension binaryOperation = new BinaryOperationExtension(this.getDelegate().getValue(), conditionOperator, conditionValue);
                if (this.result = binaryOperation.evaluate().toBoolean()) {
                    //fire styleTRUE
                    //this.getDelegate().getExtension("StyleChange");
                } else {
                    //fire styleFALSE
                    //this.getDelegate().getExtension("StyleChange");
                }
            } catch (UnknownElementException | IllegalValueTypeException e) {
                e.printStackTrace();
            }
        }

        @Override
        public CellDTO toDTO() {
            return null;
        }

    }
}