package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.dom.client.Style;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.table.cell.WidgetColumn;
import pt.isep.nsheets.client.application.workbook.WorkbookView.SheetCell;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.services.ChartDTO;

public class SheetWidgetColumn extends WidgetColumn<SheetCell, MaterialButton> {

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

        @Override
    public MaterialButton getValue(SheetCell object) {
        MaterialButton btn = new MaterialButton();
        if (this.colNumber == -1) {
            btn.setText("" + (object.getCell(0).getAddress().getRow() + 1));
        } else {
            Cell cell = object.getCell(this.colNumber);
            String value = cell.getValue().toString();
            if(cell.hasChart()) {
                btn.setIconType(IconType.INSERT_CHART);
                btn.setIconPosition(IconPosition.LEFT);
            }
            btn.setText(value);
            
        }
        
            btn.setTextColor(Color.BLACK);
            btn.setType(ButtonType.FLAT);

        return btn;
    }
//    @Override
//    public MaterialLabel getValue(SheetCell object) {
//        MaterialLabel badge = new MaterialLabel();
//        if (this.colNumber == -1) {
//            badge.setText("" + (object.getCell(0).getAddress().getRow() + 1));
//        } else {
//            badge.setText(object.getCell(this.colNumber).getValue().toString());
//        }
//        badge.setLayoutPosition(Style.Position.RELATIVE);
//
//        return badge;
//    }

//    @Override
//    public MaterialLabel render(Context context, SheetCell object) {
//        MaterialLabel widget = getValue(object);
//
//        // Add a click handler...
//        widget.addClickHandler(event -> {
//
//            Cell cell = object.getCell(context.getColumn() - 1);
//            if (context.getColumn() > 0) {
//                this.view.setActiveCell(cell);
//                MaterialToast.fireToast("Cell " + cell.getContent() + " active");
//                if (cell.hasChart()) {
//                    updateCellCharts(cell);
//                    this.view.popChart.setPopupPosition(event.getClientX(), event.getClientY());
//                    this.view.popChart.open();
//                }
////				this.view.getTable().getTableTitle().setText(object.getCell(context.getColumn()-1).toString()+": "+object.getCell(context.getColumn()-1).getContent().toString());
////				this.view.getFirstBox().setText(object.getCell(context.getColumn()-1).getContent().toString());
//
//            }
//
//        });
//
//        return widget;
//    }
    
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
    }
}
    

