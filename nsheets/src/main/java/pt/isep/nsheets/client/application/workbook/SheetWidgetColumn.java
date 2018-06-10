package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.dom.client.Style;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.cell.WidgetColumn;
import org.eclipse.jdt.internal.core.util.ExceptionTableEntry;
import pt.isep.nsheets.client.application.workbook.WorkbookView.SheetCell;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.StyleCell;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.ExtensionManager;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions.CellStyleExtension;

public class SheetWidgetColumn extends WidgetColumn<SheetCell, MaterialLabel> {
    /**
     * The lowest character to be used in a column name
     */
    public static final char LOWEST_CHAR = 'A';

    /**
     * The highest character to be used in a column name
     */
    public static final char HIGHEST_CHAR = 'Z';

    private WorkbookView view = null;

    private int colNumber = -1;

    public String getColumnName() {
        String columnStr;
        int tempColumn = this.colNumber;
        for (columnStr = ""; tempColumn >= 0; tempColumn = tempColumn
                / (HIGHEST_CHAR - LOWEST_CHAR + 1) - 1) {
            columnStr = (char) ((char) (tempColumn % (HIGHEST_CHAR
                    - LOWEST_CHAR + 1)) + LOWEST_CHAR) + columnStr;
        }
        return columnStr;
    }

    // instance initialize
    public SheetWidgetColumn(int column, WorkbookView view) {
        this.view = view;
        this.colNumber = column;
        if (this.colNumber >= 0) {
            this.setName(getColumnName());
        }
    }

    @Override
    public TextAlign textAlign() {
        return TextAlign.CENTER;
    }

   /* @Override
        public MaterialButton getValue(SheetCell object) {

        MaterialButton btn = new MaterialButton();

        Cell cell_;
        if (this.colNumber == -1) {
            cell_ = object.getCell(0);
            btn.setText("" + (cell_.getAddress().getRow() + 1));
        } else {
            cell_ = object.getCell(this.colNumber);
            String value = cell_.getValue().toString();
            if (cell_.hasChart()) {
                btn.setIconType(IconType.INSERT_CHART);
                btn.setIconPosition(IconPosition.LEFT);
            }

            btn.setText(value);
            Extension extension = ExtensionManager.getInstance().getExtension("CellStyleExtension");
            if(extension != null){
                //extension.getUIExtension(btn).decorate(object.getCell(this.colNumber));
                try {
                    btn.setBackgroundColor(Color.RED);
                    //this.view.customTable.getRow(cell.getAddress().getRow()).getWidget().getColumn(cell.getAddress().getColumn()+1).setBackgroundColor(Color.values()[20]);
                    MaterialToast.fireToast("passou celula"+cell.getAddress().toString());
                }catch(Exception e){
                    e.printStackTrace();
                    MaterialToast.fireToast("não passou nesta celula"+cell.getAddress().toString());
                }
                //this.view.customTable.getRow(aux.getAddress().getRow()).getWidget().getColumn(aux.getAddress().getColumn()).setBackgroundColor(Color.values()[CellStyleExtension.getCellStyle(aux.getAddress()).getBackgroungColor()]);
            }

        }
        btn.setBackgroundColor(Color.TRANSPARENT);






            //btn.setTextColor(Color.BLACK);
            btn.setType(ButtonType.FLAT);

           /* Extension extension = ExtensionManager.getInstance().getExtension("Value Colour Extension");
            if(extension!=null){
                extension.getUIExtension(btn).decorate(object.getCell(this.colNumber));
            }*/
            /*
            Extension extensionCell = ExtensionManager.getInstance().getExtension("CellStyleExtension");
            Extension extensionCond = ExtensionManager.getInstance().getExtension("ConditionalFormatting");
            if(extensionCell!=null && extensionCond !=null){

                Conditional cond = ConditionalFormattingExtension.containsCondition((CellImpl)object.getCell(this.colNumber));

                 //1050475 Other possibility to change CellSyle but need colaboration from Core8.1
                if(cond != null){
                    boolean flag = ConditionalFormattingExtension.setOperation(object.getCell(this.colNumber), cond.getCondOperator(), cond.getCondValue());
                    MaterialToast.fireToast("Cell"+ object.getCell(this.colNumber).getAddress().toString()+"Conditional equals "+flag);

                    CellStyleExtension.setConfig(cond.getConfiguration());
                    CellStyleExtension.setResult(ConditionalFormattingExtension.setOperation(object.getCell(this.colNumber), cond.getCondOperator(), cond.getCondValue()));
                    extensionCell.getUIExtension(btn).decorate(object.getCell(this.colNumber));
                }
            }*/
    /*    return btn;
    }*/

        /*
          @Override
    public MaterialButton render(Context context, SheetCell object) {
        MaterialButton widget = getValue(object);

        // Add a click handler...
        widget.addClickHandler(event -> {

            Cell cell = object.getCell(context.getColumn() - 1);
            if (context.getColumn() > 0) {
                this.view.setActiveCell(cell);
//				this.view.getTable().getTableTitle().setText(object.getCell(context.getColumn()-1).toString()+": "+object.getCell(context.getColumn()-1).getContent().toString());
//				this.view.getFirstBox().setText(object.getCell(context.getColumn()-1).getContent().toString());

            }

        });

        return widget;
    }*/

    @Override
    public MaterialLabel getValue(SheetCell object) {
        MaterialLabel badge = new MaterialLabel();
        //badge.setPixelSize(180,30);
        badge.setMinHeight("30px");
        if (this.colNumber == -1) {
            badge.setText("" + (object.getCell(0).getAddress().getRow() + 1));
        } else {
            badge.setText(object.getCell(this.colNumber).getValue().toString());
            Extension ui = ExtensionManager.getInstance().getExtension("CellStyleExtension");
            if(ui != null) {
                ui.getUIExtension(badge).decorate(object.getCell(this.colNumber).getAddress());
                try {
                    this.view.customTable.getRow(object.getCell(this.colNumber).getAddress().getRow()).getWidget().getColumn(object.getCell(this.colNumber).getAddress().getColumn()+1).setBackgroundColor(Color.values()[CellStyleExtension.getCellStyle(object.getCell(this.colNumber).getAddress()).getBackgroungColor()]);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
       badge.setLayoutPosition(Style.Position.RELATIVE);

        return badge;
    }

    @Override
    public MaterialLabel render(Context context, SheetCell object) {
        MaterialLabel widget = getValue(object);

        // Add a click handler...
        widget.addClickHandler(event -> {

            Cell cell = object.getCell(context.getColumn() - 1);
            if (context.getColumn() > 0) {
                this.view.setActiveCell(cell);
               MaterialToast.fireToast("Cell " + cell.getContent() + " active");

				this.view.getTable().getTableTitle().setText(object.getCell(context.getColumn()-1).toString()+": "+object.getCell(context.getColumn()-1).getContent().toString());
				this.view.getFirstBox().setText(object.getCell(context.getColumn()-1).getContent().toString());
            }

        });

        return widget;
   }

}
