package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import pt.isep.nsheets.shared.ext.CellExtension;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.Formula.BinaryOperationExtension;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;

public class ConditionalFormattingExtension extends Extension {

    public ConditionalFormattingExtension(String name) {
        super(name);
    }

    public CellExtension extend(CellExtension cell) {
        return new ConditionalFormattingCellExtension(cell, getName(), conditional, configuration);
    }

    public static Conditional getConditional() {
        return conditional;
    }

    public static void setConditional(Conditional conditional) {
        ConditionalFormattingExtension.conditional = conditional;
    }

    public static Conditional conditional = new Conditional();

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        ConditionalFormattingExtension.configuration = configuration;
    }

    public static Configuration configuration = new Configuration();

    class ConditionalFormattingCellExtension extends CellExtension {
        private Conditional conditional; //cell conditional info
        private Configuration configuration; //cell formatting info
        private boolean result;

        public ConditionalFormattingCellExtension(Cell delegate, String name, Conditional cond, Configuration config) {
            super(delegate, name);
            this.conditional = cond;
            this.configuration = config;
            this.valueChanged(this);
        }

        public Conditional condition() {
            return conditional;
        }

        public Configuration config() {
            return configuration;
        }

        @Override
        public void valueChanged(Cell cell) {
            try {
                if (Operation()) {
                    //fire styleTRUE
                    //this.getDelegate().getExtension("CellStyleChange");
                } else {
                    //fire styleFALSE
                    //this.getDelegate().getExtension("CellStyleChange");
                }
            } catch (UnknownElementException | IllegalValueTypeException e) {
                e.printStackTrace();
            }
        }


        private boolean Operation() throws UnknownElementException, IllegalValueTypeException {
            BinaryOperationExtension binaryOperation = new BinaryOperationExtension(this.getDelegate().getValue(), conditional.getConditionOperator(), conditional.getConditionValue());
            return binaryOperation.evaluate().toBoolean();
        }

        @Override
        public CellDTO toDTO() {
            return null;
        }
    }
}