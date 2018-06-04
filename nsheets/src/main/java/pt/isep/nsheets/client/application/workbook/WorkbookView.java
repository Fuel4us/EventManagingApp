/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.core.client.GWT;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

import com.gwtplatform.mvp.client.ViewImpl;

import com.google.gwt.user.client.ui.Panel;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.addins.client.window.MaterialWindow;

import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import static gwt.material.design.jquery.client.api.JQuery.$;

import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.Formula.BinaryOperationExtension;

import pt.isep.nsheets.client.lapr4.red.s1.core.n1160600.application.SortSpreadsheetController;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

// public class HomeView extends ViewImpl implements HomePresenter.MyView {
// public class WorkbookView extends NavigatedView implements WorkbookPresenter.MyView {
public class WorkbookView extends ViewImpl implements WorkbookPresenter.MyView {

    public static ChartDTO selectedChart;
    
    @Override
    public MaterialTextBox getFirstBox() {
        return firstBox;
    }

    @Override
    public MaterialIcon getFirstButton() {
        return firstButton;
    }

    @UiField
    MaterialTextBox firstBox;
    @UiField
    MaterialIcon firstButton;
    
    @UiField
    MaterialLink saveButton, click_chart;
    /*
	Conditional UI Objects @1050475
     */
    @UiField
    MaterialTitle conditionalTitle;
    @UiField
    MaterialIcon conditionalButton;
    @UiField
    MaterialTextBox conditionalText;
    //@UiField
    //MaterialTextBox conditionalText2;
    @UiField
    MaterialIcon conditionalModalCloseButton;
    @UiField
    MaterialIcon conditionalModalDoneButton;
    @UiField
    MaterialModal conditionalModal;
    @UiField
    MaterialListBox lstConditions;
    /*
    @UiField
    MaterialInput backgroundColorTrue;
    @UiField
    MaterialInput fontColorTrue;
    @UiField
    MaterialInput backgroundColorFalse;
    @UiField
    MaterialInput fontColorFalse;
    /* End of Conditional UI Objects */

    @UiField
    MaterialDropDown chart_dropdown;
    @UiField
    MaterialPopupMenu popupMenu, popChart;


    @UiField
    MaterialLink sortLink;
    @UiField
    MaterialWindow window;
    @UiField
    MaterialButton sortButton;
    @UiField
    MaterialTextBox windowFirstBox;
    @UiField
    MaterialTextBox windowSecondBox;
    @UiField
    MaterialListBox sortListBox;
    @UiField
    MaterialDataTable<SheetCell> customTable;
    
    @UiHandler("click_chart")
    void onclick(ClickEvent e){
        this.activeCell = null;
        selectedChart = null;
    }

    @Override
    public MaterialDropDown getChartDropDown() {
        return chart_dropdown;
    }

    @Override
    public MaterialPopupMenu getPopChart() {
        return popChart;
    }

    
    interface Binder extends UiBinder<Widget, WorkbookView> {
    }

    private pt.isep.nsheets.shared.core.Cell activeCell = null;

    public void setActiveCell(pt.isep.nsheets.shared.core.Cell cell) {
        this.activeCell = cell;

        this.customTable.getTableTitle().setText(cell.toString() + ": " + cell.getContent().toString());
        this.firstBox.setText(cell.getContent().toString());
    }

    @Override
    public pt.isep.nsheets.shared.core.Cell getActiveCell() {
        return this.activeCell;
    }

    @Override
    public MaterialDataTable<SheetCell> getTable() {
        return customTable;
    }

    class SheetCell {

        private Spreadsheet sheet;
        private int row = -1;

        public SheetCell(Spreadsheet sheet, int row) {
            this.row = row;
            this.sheet = sheet;
        }

        pt.isep.nsheets.shared.core.Cell getCell(int column) {
            return this.sheet.getCell(column, this.row);
        }

    }

    void initWorkbook() {
        // Test the initialization of an Workbook

        Spreadsheet sh = Settings.getInstance().getWorkbook().getSpreadsheet(0);

        int columnNumber = 0;

        // Add the columns...
        customTable.addColumn(new SheetWidgetColumn(-1, this));
        for (int i = 0; i < sh.getColumnCount(); ++i) {

            // Add a column for the column :-)
            customTable.addColumn(new SheetWidgetColumn(columnNumber, this));

            ++columnNumber;
        }

        // int rowIndex = 0;
        List<SheetCell> rows = new ArrayList<>();
        for (int k = 0; k < sh.getRowCount(); k++) {

            SheetCell cell = new SheetCell(sh, k);


            if (k == 1) {
                cell.getCell(4).addChart(initChartTEST());
            }

            rows.add(cell);
        }
        customTable.setRowData(0, rows);
    }

    @Inject
    WorkbookView(Binder uiBinder) {

        //populateColourListBox();
        initWidget(uiBinder.createAndBindUi(this));

        firstButton.addClickHandler(event -> {
            if (activeCell != null) {
                String result = "";
                try {
                    activeCell.setContent(firstBox.getText());
//                    SpreadsheetImpl.fromDTO(Settings.getInstance().getWorkbook().spreadsheets.get(0).cells(activeCell.getAddress()).setContent(firstBox.getText());
                } catch (FormulaCompilationException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                    result = e.getMessage();
                } finally {
                    //resultLabel.setText(result);

                    // refresh the table...
                    customTable.getView().setRedraw(true);
                    customTable.getView().refresh();

                    // refresh the active cell
                    this.setActiveCell(activeCell);
                }
            }
            // Window.alert("Hello");
        });

        // It is possible to create your own custom renderer per table
        // When you use the BaseRenderer you can override certain draw
        // methods to create elements the way you would like.
        customTable.getView().setRenderer(new SheetRenderer<SheetCell>());

        conditionalButton.addClickHandler(event -> {
            if (activeCell != null) {
                conditionalModal.open();
                conditionalTitle.setTitle("Conditional Formating of Cell " + activeCell.getAddress().toString());
            }
        });

        conditionalModalDoneButton.addClickHandler(event -> {
            if (conditionalText.getText().matches("[+-]?([0-9]*[.])?[0-9]+")) {
                    String operator;
                    switch (lstConditions.getSelectedIndex()) {
                        case 0:
                            operator = "=";
                            break;
                        case 1:
                            operator = ">";
                            break;
                        case 2:
                            operator = "<";
                            break;
                        case 3:
                            operator = ">=";
                            break;
                        case 4:
                            operator = "<=";
                            break;
                        case 5:
                            operator = "<>";
                            break;
                        //case 6:  operator = "<<";
                        //  break;
                        default:
                            operator = "Invalid";
                            break;
                    }

                    boolean result;
                    boolean flag;
                    try {
                        BinaryOperationExtension binaryOperation = null;
                        try {
                            binaryOperation = new BinaryOperationExtension(activeCell.getValue(), operator, Value.parseNumericValue(conditionalText.getText()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (result = binaryOperation.evaluate().toBoolean()) {
                            //fire styleTRUE
                        } else {
                            //fire styleFALSE
                        }
                        flag = true;
                        MaterialToast m = new MaterialToast();
                        m.toast("Flag =" + flag);
                        m.toast("Result =" + result);
                        //m.toast("BackgroundColorTrue selected:"+backgroundColorTrue.getSelectedIndex());


                    } catch (UnknownElementException e) {
                        flag = false; //conditionalFormatting is off
                    } catch (IllegalValueTypeException e) {
                        flag = false;
                    }
                    conditionalModal.close();

/*
                    ConditionalCellFormattingController ccfController = new ConditionalCellFormattingController(activeCell, operator, conditionalText.getText());

                    //TRUE
                    ccfController.setBackgroundColorTrue(backgroundColorTrue.getText());
                    ccfController.setFontColorTrue(fontColorTrue.getText());
                    //FALSE
                    ccfController.setBackgroundColorFalse(backgroundColorFalse.getText());
                    ccfController.setFontColorFalse(fontColorFalse.getText());
                    MaterialToast m = new MaterialToast();
                    boolean flag = ccfController.ConditionalOperation();
                    m.toast("result =" + flag);*/

            }
            conditionalModal.close();
		});

        /* BETWEEN OPTION CONDITIONAL
        lstConditions.addValueChangeHandler(event -> {
            if (lstConditions.getSelectedIndex() == 6) {
                conditionalText2.setVisibility(Style.Visibility.VISIBLE);
            } else {
                conditionalText2.setVisibility(Style.Visibility.HIDDEN);
            }
        });*/

        conditionalModalCloseButton.addClickHandler(event -> {
            conditionalModal.close();
        });

        // It is possible to create your own custom renderer per table
        // When you use the BaseRenderer you can override certain draw
        // methods to create elements the way you would like.
        customTable.getView().setRenderer(new SheetRenderer<SheetCell>());

        initWorkbook();
        
        saveButton.addClickHandler(event -> {
            WorkbooksServiceAsync workbooksSvc = GWT.create(WorkbooksService.class);

            // Set up the callback object.
            AsyncCallback<WorkbookDTO> callback = new AsyncCallback<WorkbookDTO>() {
                public void onFailure(Throwable caught) {
                    
                }
                
                public void onSuccess(WorkbookDTO result) {
                    MaterialToast.fireToast(result.name);
                }
            };
            
            workbooksSvc.addWorkbookDescription(Settings.getInstance().getWorkbook().toDTO(), callback);
        });
        
        // Set the visible range of the table for pager (later)
        customTable.setVisibleRange(0, 2001);

        // Configure the tables long press duration configuration.
        // The short press is when a click is held less than this duration.
        customTable.setLongPressDuration(400);

        customTable.addRowContextMenuHandler(event -> {
            // Firing Row Context will automatically select the row where it was right
            // clicked
            customTable.selectRow($(event.getRow()).asElement(), true);
            popupMenu.setSelected(event.getModel());
            // Get the PageX and getPageY

            popupMenu.setPopupPosition(event.getMouseEvent().getPageX(), event.getMouseEvent().getPageY());
            popupMenu.open();
        });
        
        

        // Added access to ToolPanel to add icon widget
        Panel panel = customTable.getScaffolding().getToolPanel();
        panel.clear();
        panel.setVisible(false);

        sortLink.addClickHandler(event -> {
            window.open();
        });
        sortButton.addClickHandler(event -> {
            try {
                boolean ascending = (sortListBox.getSelectedIndex() == 0)?true:false;
                SortSpreadsheetController.sortCells(windowFirstBox.getText(), windowSecondBox.getText(), this.customTable.getRow(0).getData().sheet, ascending);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Window.alert(e.getMessage());
            } finally {
                //resultLabel.setText(result);

                // refresh the table...
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();
                window.close();
            }
        });

        customTable.getTableTitle().setText("The Future Worksheet!");
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        // table.getTableTitle().setText("The Future Worksheet!");
    }

    public ChartDTO initChartTEST() {
        String[][] matrix = new String[][]{
            {"a", " 2", "3"},
            {"4", " 2", "3"},
            {"6", " 2", "3"},
            {"1", " 2", "3"},
            {"1", " 4", "3"},
            {"1", " 2", "3"},
            {"1", " 2", "3"},
            {"1", " 2", "3"},
            {"1", " 2", "3"},
            {"1", " 2", "40"}};

        Workbook wb = new Workbook("Teste", "Teste", matrix);
        Spreadsheet ss = wb.getSpreadsheet(0);

        ChartDTO dto = new ChartDTO(
                "CHART TEST",
                new Address(1, 1),
                new Address(5, 5),
                matrix,
                true,
                false);

        return dto;
    }

    /*private void populateColourListBox(){
        for (Color c : Color.values()){
            backgroundColorTrue.addItem(c);
            fontColorTrue.addItem(c);
            backgroundColorFalse.addItem(c);
            fontColorFalse.addItem(c);
        }
    }*/


}
