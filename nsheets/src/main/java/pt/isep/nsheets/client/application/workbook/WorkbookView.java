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
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import gwt.material.design.client.constants.Color;
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

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import static gwt.material.design.jquery.client.api.JQuery.$;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.ExtensionManager;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.ConditionalFormattingExtension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions.CellStyleExtension;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import pt.isep.nsheets.client.lapr4.red.s1.core.n1160600.workbook.application.SortSpreadsheetController;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.services.*;

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
    MaterialTextBox searchBox;
    @UiField
    MaterialIcon searchButton;
    @UiField
    MaterialModal searchModal;
    @UiField
    MaterialTitle searchTitle;
    @UiField
    MaterialTextArea searchTextArea;

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
    @UiField
    MaterialListValueBox<Color> backgroundColorTrue;
    @UiField
    MaterialListValueBox<Color> fontColorTrue;
    @UiField
    MaterialListValueBox<Color> backgroundColorFalse;
    @UiField
    MaterialListValueBox<Color> fontColorFalse;
    /* End of Conditional UI Objects */

 /*
    Style UI objects by 1050475
     */
    @UiField
    MaterialListValueBox<Color> backgroundcolorLst;
    @UiField
    MaterialListValueBox<Color> fontcolorLst;
    @UiField
    MaterialListValueBox<Integer> fontsizeLst;
    @UiField
    MaterialListValueBox<TextAlign> textAlignLst;

    @UiField
    MaterialDropDown chart_dropdown;
    @UiField
    MaterialPopupMenu popChart;
    @UiField
    static MaterialPopupMenu popupMenu;

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
    @UiField
    MaterialButton newSpreadSheetButton;
    @UiField
    MaterialButton editWorkbookButton;
    @UiField
    MaterialModal modal;
    @UiField
    MaterialButton editButtonModal;
    @UiField
    MaterialButton cancelButtonModal;
    @UiField
    MaterialButton deleteButtonModal;
    
    @UiField
    MaterialLink rangeConditionButton;
    @UiField
    MaterialTextBox conditionalCell;
    @UiField
    MaterialRow conditionalRange;
    @UiField
    MaterialTextBox rangeConditionalStart;
    @UiField
    MaterialTextBox rangeConditionalEnd;

    @UiHandler("click_chart")
    void onclick(ClickEvent e) {
        this.activeCell = null;
        selectedChart = null;
    }

    public static MaterialPopupMenu getPopupMenu() {
        return popupMenu;
    }

    @Override
    public MaterialDropDown getChartDropDown() {
        return chart_dropdown;
    }

    @Override
    public MaterialPopupMenu getPopChart() {
        return popChart;
    }

    @Override
    public void setText(String string) {
        searchTextArea.setText(string);
        searchTextArea.setReadOnly(true);
    }

    @Override
    public void setContents(WorkbookDTO contents) {
        Settings.getInstance().updateWorkbook(contents);
        customTable.getView().setRedraw(true);
        customTable.getView().refresh();
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

    @Override
    public void initWorkbook() {
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

//            if (k == 1) {
//                cell.getCell(4).addChart(initChartTEST());
//            }
            rows.add(cell);
        }
        customTable.setRowData(0, rows);
    }

    @Inject
    WorkbookView(Binder uiBinder) {

        initWidget(uiBinder.createAndBindUi(this));

        populateColourListBox();

        populateTextAlignListBox();

        firstButton.addClickHandler(event -> {
            if (activeCell != null) {

                String result = "";
                try {
                    activeCell.setContent(firstBox.getText());
//                    SpreadsheetImpl.fromDTO(Settings.getInstance().getWorkbook().spreadsheets.get(0).cells(activeCell.getAddress()).setContent(firstBox.getText());
                    Extension extensionCond = ExtensionManager.getInstance().getExtension("ConditionalFormatting");
                    if (extensionCond != null) {

                        Conditional cond = ConditionalFormattingExtension.containsCondition((CellImpl) activeCell);

                        /*1050475 Other possibility to change CellSyle but need colaboration from Core8.1*/
                        if (cond != null) {
                            boolean flag = ConditionalFormattingExtension.setOperation((CellImpl) activeCell, cond.getCondOperator(), cond.getCondValue());
                            MaterialToast.fireToast("Update Cell. Conditional this " + activeCell.getAddress().toString() + " " + cond.getCondOperator() + " " + cond.getCondValue().toString() + " is " + flag);

                        }
                    }
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

        searchButton.addClickHandler(event -> {
            searchModal.open();
            CellsServiceAsync cellsServiceAsync = GWT.create(CellsService.class);
            AsyncCallback<String> asyncCallback = new AsyncCallback<String>() {
                @Override
                public void onFailure(Throwable throwable) {
                    MaterialToast.fireToast("Error! " + throwable.getMessage());
                    setText("Supposed Search Results");
                }

                @Override
                public void onSuccess(String aVoid) {
                    MaterialToast.fireToast("Cells Searched Sucessfully", "rounded");
                    setText(aVoid);
                }

            };

            cellsServiceAsync.getResult(searchBox.getText(), Settings.getInstance().getWorkbook().toDTO(), asyncCallback);

        });

        // It is possible to create your own custom renderer per table
        // When you use the BaseRenderer you can override certain draw
        // methods to create elements the way you would like.
        customTable.getView().setRenderer(new SheetRenderer<SheetCell>());

        conditionalButton.addClickHandler(event -> {
            if (activeCell != null) {
                conditionalTitle.setTitle("Conditional Formating of Cell " + activeCell.getAddress().toString());
                conditionalCell.setValue(activeCell.getAddress().toString());
                conditionalRange.setVisibility(Style.Visibility.HIDDEN);
                conditionalModal.open();
            }
        });
        rangeConditionButton.addClickHandler(event -> {
            conditionalTitle.setTitle("Conditional Formatting of a range of Cells");
            conditionalCell.setValue("_cell");
            conditionalRange.setVisibility(Style.Visibility.VISIBLE);
            conditionalModal.open();
        });
        backgroundcolorLst.addValueChangeHandler(event -> {

            if (activeCell != null) {
                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setBackgroungColor(backgroundcolorLst.getSelectedValue().ordinal());
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getBackgroungColor());
                } else {
                    MaterialToast.fireToast("nao existia");
                    CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), backgroundcolorLst.getSelectedValue().ordinal(), Color.BLACK.ordinal(), 0, 12));

                }
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();

                //remover depois de persistencia e extensions a funcionar. resize do label
                customTable.getRow(activeCell.getAddress().getRow()).getWidget().getColumn(activeCell.getAddress().getColumn() + 1).setBackgroundColor(backgroundcolorLst.getSelectedValue());
            }
        });

        fontcolorLst.addValueChangeHandler(event -> {
            if (activeCell != null) {

                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setFontColor(fontcolorLst.getSelectedValue().ordinal());
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getFontColor());
                } else {
                    MaterialToast.fireToast("nao existia");
                    CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), fontcolorLst.getSelectedValue().ordinal(), 0, 12));

                }
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();
            }

        });

        fontsizeLst.addValueChangeHandler(event -> {
            if (activeCell != null) {
                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setFontSize(fontsizeLst.getSelectedValue());
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getFontSize());
                } else {
                    MaterialToast.fireToast("nao existia");
                    CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), Color.BLACK.ordinal(), 0, fontsizeLst.getSelectedValue()));

                }
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();

                customTable.getRow(activeCell.getAddress().getRow()).getWidget().getColumn(activeCell.getAddress().getColumn() + 1).setFontSize(fontsizeLst.getSelectedValue(), Style.Unit.PX);
            }
        });

        textAlignLst.addValueChangeHandler(event -> {
            if (activeCell != null) {
                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setTextALIGN(textAlignLst.getSelectedIndex() - 1);
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getTextALIGN());
                } else {
                    MaterialToast.fireToast("nao existia");
                    CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), Color.BLACK.ordinal(), textAlignLst.getSelectedIndex() - 1, 12));

                }
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();

                customTable.getRow(activeCell.getAddress().getRow()).getWidget().getColumn(activeCell.getAddress().getColumn() + 1).setTextAlign(TextAlign.values()[textAlignLst.getSelectedValue().ordinal()]);
            }
        });

        conditionalModalCloseButton.addClickHandler(event -> {
            conditionalModal.close();
        });

        // It is possible to create your own custom renderer per table
        // When you use the BaseRenderer you can override certain draw
        // methods to create elements the way you would like.
        customTable.getView().setRenderer(new SheetRenderer<SheetCell>());

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
                boolean ascending = (sortListBox.getSelectedIndex() == 0) ? true : false;
                new SortSpreadsheetController().sortCells(windowFirstBox.getText(), windowSecondBox.getText(), this.customTable.getRow(0).getData().sheet, ascending);
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

        initWorkbook();

        customTable.getTableTitle().setText("The Future Worksheet!");
    }

    @Override
    protected void onAttach() {
        super.onAttach();
    }

//    public ChartDTO initChartTEST() {
//        String[][] matrix = new String[][]{
//            {"a", " 2", "3"},
//            {"4", " 2", "3"},
//            {"6", " 2", "3"},
//            {"1", " 2", "3"},
//            {"1", " 4", "3"},
//            {"1", " 2", "3"},
//            {"1", " 2", "3"},
//            {"1", " 2", "3"},
//            {"1", " 2", "3"},
//            {"1", " 2", "40"}};
//
//        Workbook wb = new Workbook("Teste", "Teste", matrix);
//        Spreadsheet ss = wb.getSpreadsheet(0);
//
//        ChartDTO dto = new ChartDTO(
//                "CHART TEST",
//                new Address(1, 1),
//                new Address(5, 5),
//                matrix,
//                true,
//                false);
//
//        return dto;
//    }
    private void populateColourListBox() {

        for (Color c : Color.values()) {
            if (!c.equals(Color.DEFAULT)) {
                backgroundColorTrue.addItem(c);
                fontColorTrue.addItem(c);
                backgroundColorFalse.addItem(c);
                fontColorFalse.addItem(c);
                backgroundcolorLst.addItem(c);
                fontcolorLst.addItem(c);
            }
        }
    }

    private void populateTextAlignListBox() {
        textAlignLst.addItem(TextAlign.LEFT);
        textAlignLst.addItem(TextAlign.CENTER);
        textAlignLst.addItem(TextAlign.RIGHT);
        for (int i = 6; i < 30; i = i + 2) {
            fontsizeLst.addItem(i);
        }
    }

    @Override
    public void addConfirmationHandler(ClickHandler cMDB) {
        conditionalModalDoneButton.addClickHandler(cMDB);
    }

    @Override
    public int getBackgroudColorTrue() {
        return backgroundColorTrue.getSelectedIndex();
    }

    @Override
    public int getFontColorTrue() {
        return fontColorTrue.getSelectedIndex();
    }

    @Override
    public int getBackgroudColorFalse() {
        return backgroundColorFalse.getSelectedIndex();
    }

    @Override
    public int getFontColorFalse() {
        return fontColorFalse.getSelectedIndex();
    }

    @Override
    public String getOperator() {
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

        return operator;
    }

    @Override
    public String getConditionalValue() {
        return conditionalText.getText();
    }
    
    @Override
    public String getConditionalCell() {
        return conditionalCell.getText();
    }
    
    @Override
    public String getConditionalRangeStart() {
        return rangeConditionalStart.getText();
    }
    
    @Override
    public String getConditionalRangeEnd() {
        return rangeConditionalEnd.getText();
    }

    @Override
    public MaterialModal getConditionalModal() {
        return this.conditionalModal;
    }

    @UiHandler("editWorkbookButton")
    void editWorkBook(ClickEvent e) {
        modal.open();
    }

    @UiHandler("cancelButtonModal")
    void cancelModal(ClickEvent e) {
        modal.close();
    }

}
