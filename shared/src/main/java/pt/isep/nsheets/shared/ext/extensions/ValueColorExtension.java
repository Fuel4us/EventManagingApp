package pt.isep.nsheets.shared.ext.extensions;

import com.google.gwt.dev.shell.BrowserChannel;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.SpreadsheetExtension;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

public class ValueColorExtension extends Extension {


    /**
     * Creates a new extensions.
     *
     * @param name the name of the extensions
     */
    public ValueColorExtension(String name) {
        super(name);
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

        @Override
        public Spreadsheet fromDTO() throws FormulaCompilationException {
            return null;
        }

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

    static class Configuration {
        private String posBgColor="#ffffff";
        private String posFgColor="#000000";
        private String nesBgColor="#ffffff";
        private String nesFgColor="#000000";

        public void setPosBgColor(String posBgColor) {
            this.posBgColor = posBgColor;
        }

        public void setPosFgColor(String posFgColor) {
            this.posFgColor = posFgColor;
        }

        public void setNesBgColor(String nesBgColor) {
            this.nesBgColor = nesBgColor;
        }

        public void setNesFgColor(String nesFgColor) {
            this.nesFgColor = nesFgColor;
        }

        public String getPosBgColor() {
            return posBgColor;
        }

        public String getPosFgColor() {
            return posFgColor;
        }

        public String getNesBgColor() {
            return nesBgColor;
        }

        public String getNesFgColor() {
            return nesFgColor;
        }
    }
}
