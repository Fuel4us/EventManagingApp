package pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629;

import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.SpreadsheetExtension;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

public class ValueColorExtension extends Extension {


    /**
     * Creates a new extensions.
     *
     * @param name the name of the extensions
     */
    public ValueColorExtension(String name) {
        super(name);
    }

    public static Configuration getConfig() {
        return config;
    }

    public static void setConfig(Configuration config) {
        ValueColorExtension.config=config;
    }

    public static Configuration config = new Configuration();

    @Override
    public SpreadsheetExtension extend(Spreadsheet spreadsheet) {
        return new ValueColorSpreadsheetExtension(spreadsheet, getName());
    }

    class ValueColorSpreadsheetExtension extends SpreadsheetExtension{

        /**
         * Creates a new spreadsheet extensions.
         *
         * @param delegate the delegate of the extensions
         * @param name     the name of the extensions to which the spreadsheet extensions belongs
         */
        public ValueColorSpreadsheetExtension(Spreadsheet delegate, String name) {
            super(delegate, name);
            addCellListener(new ValueColorListener());
        }

        @Override
        public SpreadsheetDTO toDTO() {
            return null;
        }

//        @Override
//        public Spreadsheet fromDTO() throws FormulaCompilationException {
//            return null;
//        }

        class ValueColorListener implements CellListener{

            @Override
            public void valueChanged(Cell cell) {
                if(cell.getValue().getType()== Value.Type.NUMERIC){
                    try {
                        if(cell.getValue().toDouble()>=0){
                            //set colors
                        }
                        else {
                            //set colors
                        }
                    } catch (IllegalValueTypeException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void contentChanged(Cell cell) {
            }

            @Override
            public void dependentsChanged(Cell cell) {
            }

            @Override
            public void cellCleared(Cell cell) {
            }

            @Override
            public void cellCopied(Cell cell, Cell source) {
            }
        }
    }


}
