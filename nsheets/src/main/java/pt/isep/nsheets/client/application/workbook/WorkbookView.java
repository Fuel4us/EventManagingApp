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
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import static gwt.material.design.jquery.client.api.JQuery.$;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.ExtensionManager;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.ConditionalFormattingExtension;

import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions.CellStyleExtension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleService;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleServiceAsync;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import pt.isep.nsheets.client.lapr4.red.s1.core.n1160600.workbook.application.SortSpreadsheetController;
import pt.isep.nsheets.client.lapr4.red.s2.ipc.n1160600.workbook.application.SearchAndReplaceController;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.UnknownElementException;
import pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang.GlobalVariable;
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
    MaterialLink searchButton;
    @UiField
    MaterialModal searchModal;
    @UiField
    MaterialTitle searchTitle;
    @UiField
    MaterialTextArea searchTextArea;

    @UiField
    MaterialLink searchAndReplaceButton;

    @UiField
    MaterialButton findNextButton;
    @UiField
    MaterialButton replaceButton;
    @UiField
    MaterialButton replaceAllButton;
    @UiField
    MaterialWindow searchAndReplaceWindow;
    @UiField
    MaterialTextBox replaceWindowFirstBox;
    @UiField
    MaterialTextArea replaceWindowResultBox;

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

    //uiObjects by 1140317
    @UiField
    MaterialButton addBasicWizardButton;
    @UiField
    MaterialButton chooseButton;
    @UiField
    MaterialButton doneButton;
    @UiField
    MaterialWindow basicWizardWindow;
    @UiField
    MaterialListBox basicWizardComboBox;
    @UiField
    MaterialTextBox basicWizardTextBox;
    @UiField
    MaterialTextBox basicWizardTextBox2;

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
    @UiField
    MaterialIcon conditionalModalDeleteButton;
    
    @UiField
    MaterialCollapsibleBody colapsBody;
    
    @UiField
    MaterialTextBox nameModal;
    @UiField
    MaterialTextBox descriptionModal;

    @UiField
    MaterialLink macro;
    @UiField
    MaterialModal macroModal;
    @UiField
    MaterialTitle macroTitle;
    @UiField
    MaterialTextArea macroTextArea;
    @UiField
    MaterialIcon macroModalDoneButton;
    @UiField
    MaterialIcon macroModalCloseButton;
    
    @UiField
    MaterialCollection openWorkbooks;

    @Override
    public MaterialModal getModal() {
        return modal;
    }

    @Override
    public MaterialTextBox getNameModal() {
        return nameModal;
    }

    @Override
    public MaterialTextBox getDescriptionModal() {
        return descriptionModal;
    }

    @Override
    public MaterialButton getEditButtonModal() {
        return editButtonModal;
    }

    public MaterialButton getAddWizard() {
        return addBasicWizardButton;
    }

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

    private void openSearchAndReplaceWindow() {
        String expression = searchBox.getText();
        SearchAndReplaceController controller = new SearchAndReplaceController(this.customTable.getRow(0).getData().sheet);
        controller.searchAll(expression);
        replaceButton.setEnabled(true);
        replaceWindowFirstBox.setEnabled(true);
        searchAndReplaceWindow.open();
        Cell c = controller.getCurrent();
        if (c != null) {
            replaceWindowResultBox.setText("Content found on cell " + c.getAddress().toString() + ": " + c.getContent());
        } else {
            replaceWindowResultBox.setText("No matches found");
            replaceButton.setEnabled(false);
            replaceWindowFirstBox.setEnabled(false);
        }
        findNextButton.addClickHandler(event -> {

            Cell cell = controller.getNext();
            if (cell != null) {
                replaceWindowResultBox.setText("Content found on cell " + cell.getAddress().toString() + ": " + cell.getContent());
            } else {
                replaceWindowResultBox.setText("There's no more matches for your expression");
            }
        });
        replaceButton.addClickHandler(event -> {
            Cell cell = controller.getCurrent();
            try {
                String s = replaceWindowFirstBox.getText();
                controller.replace(s, cell);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(WorkbookView.class.getName()).log(Level.SEVERE, null, ex);
                MaterialToast.fireToast("Error replacing formula");
            }finally {
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();
            }
        });
        
        replaceAllButton.addClickHandler(event ->{
            try {
                String s = replaceWindowFirstBox.getText();
                controller.replaceAll(s);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(WorkbookView.class.getName()).log(Level.SEVERE, null, ex);
                MaterialToast.fireToast("Error replacing formula");
            }finally {
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();
            }
        });
    }

    interface Binder extends UiBinder<Widget, WorkbookView> {
    }

    private pt.isep.nsheets.shared.core.Cell activeCell = null;

    public void setActiveCell(pt.isep.nsheets.shared.core.Cell cell) {
        this.activeCell = cell;
        CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
        if (c != null) {
            backgroundcolorLst.setSelectedValue(Color.values()[c.getBackgroungColor()]);
            fontcolorLst.setSelectedValue(Color.values()[c.getFontColor()]);
            textAlignLst.setSelectedIndex(c.getTextALIGN() + 1);
            fontsizeLst.setSelectedValue(c.getFontSize());
        } else {
            backgroundcolorLst.setSelectedValue(Color.WHITE);
            fontcolorLst.setSelectedValue(Color.BLACK);
            textAlignLst.setSelectedIndex(1);
            fontsizeLst.setSelectedValue(12);
        }

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
        Spreadsheet sh = getCurrentSpreadsheet();

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

        loadCellStyles();

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
                    this.updateCellStyles(c);
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getBackgroungColor());
                } else {
                    MaterialToast.fireToast("nao existia");
                    //CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), backgroundcolorLst.getSelectedValue().ordinal(), Color.BLACK.ordinal(),0,12));
                    this.updateCellStyles(new CellStyle(activeCell.getAddress(), backgroundcolorLst.getSelectedValue().ordinal(), Color.BLACK.ordinal(), 0, 12));
                }

                //remover depois de persistencia e extensions a funcionar. resize do label
                //customTable.getRow(activeCell.getAddress().getRow()).getWidget().getColumn(activeCell.getAddress().getColumn() + 1).setBackgroundColor(backgroundcolorLst.getSelectedValue());
            }
        });

        fontcolorLst.addValueChangeHandler(event -> {
            if (activeCell != null) {

                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setFontColor(fontcolorLst.getSelectedValue().ordinal());
                    this.updateCellStyles(c);
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getFontColor());
                } else {
                    MaterialToast.fireToast("nao existia");
                    //CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), fontcolorLst.getSelectedValue().ordinal(),0,12));
                    this.updateCellStyles(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), fontcolorLst.getSelectedValue().ordinal(),0,12));
                }
            }

        });

        fontsizeLst.addValueChangeHandler(event -> {
            if (activeCell != null) {
                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setFontSize(fontsizeLst.getSelectedValue());
                    this.updateCellStyles(c);
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getFontSize());
                } else {
                    MaterialToast.fireToast("nao existia");
                    //CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), Color.BLACK.ordinal(), 0, fontsizeLst.getSelectedValue()));
                    this.updateCellStyles(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), Color.BLACK.ordinal(), 0, fontsizeLst.getSelectedValue()));
                }

                customTable.getRow(activeCell.getAddress().getRow()).getWidget().getColumn(activeCell.getAddress().getColumn() + 1).setFontSize(fontsizeLst.getSelectedValue(), Style.Unit.PX);
            }
        });

        textAlignLst.addValueChangeHandler(event -> {
            if (activeCell != null) {
                CellStyle c = CellStyleExtension.getCellStyle(activeCell.getAddress());
                if (c != null) {
                    c.setTextALIGN(textAlignLst.getSelectedIndex() - 1);
                    this.updateCellStyles(c);
                    MaterialToast.fireToast("existia " + CellStyleExtension.getCellStyle(activeCell.getAddress()).getTextALIGN());
                } else {
                    MaterialToast.fireToast("nao existia");
                    //CellStyleExtension.addCellStyle(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), Color.BLACK.ordinal(), textAlignLst.getSelectedIndex() - 1, 12));
                    this.updateCellStyles(new CellStyle(activeCell.getAddress(), Color.WHITE.ordinal(), Color.BLACK.ordinal(), textAlignLst.getSelectedIndex() - 1, 12));
                }

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
            updateCollapsible();
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

        //1140317
        addBasicWizardButton.addClickHandler(event -> {
            basicWizardWindow.open();
        });

        Language lang = new Language("basic wizard");
        for (Function function : lang.getFunctions()) {
            basicWizardComboBox.add(function.getIdentifier());
        }

        doneButton.addClickHandler(event -> {
            int i = basicWizardComboBox.getSelectedIndex();
            firstBox.setText(lang.getFunctions()[i].getIdentifier());
            basicWizardWindow.close();
        });

        chooseButton.addClickHandler(event -> {
            basicWizardTextBox.setText(getParameters(lang));
            basicWizardTextBox2.setText(getDescription(lang));

        });

        macro.addClickHandler(event -> {
            macroModal.open();
        });

        macroModalCloseButton.addClickHandler(event -> {
            macroModal.close();
        });

        macroModalDoneButton.addClickHandler(event -> {
            if (activeCell != null) {

                String result = "";
                try {
                    activeCell.setContentByMacro(macroTextArea.getText());
                    Extension extensionCond = ExtensionManager.getInstance().getExtension("ConditionalFormatting");
                    if (extensionCond != null) {

                        Conditional cond = ConditionalFormattingExtension.containsCondition((CellImpl) activeCell);

                        if (cond != null) {
                            boolean flag = ConditionalFormattingExtension.setOperation((CellImpl) activeCell, cond.getCondOperator(), cond.getCondValue());
                            MaterialToast.fireToast("Update Cell. Conditional this " + activeCell.getAddress().toString() + " " + cond.getCondOperator() + " " + cond.getCondValue().toString() + " is " + flag);

                        }
                    }
                } catch (FormulaCompilationException e) {
                    result = e.getMessage();
                } finally {
                    customTable.getView().setRedraw(true);
                    customTable.getView().refresh();

                    this.setActiveCell(activeCell);
                }
            }
            macroModal.close();
        });

        searchAndReplaceButton.addClickHandler(event -> {
            openSearchAndReplaceWindow();
        });
    }
    
    private void updateCollapsible(){
        colapsBody.clear();
        
        for(String key : Settings.getInstance().getWorkbook().globalVariables().keySet()){
            MaterialCollapsible collaps = new MaterialCollapsible();
            MaterialCollapsibleItem item = new MaterialCollapsibleItem();
            item.add(new MaterialCollapsibleHeader(new MaterialLink(key)));
            int i = 0;
            
            for(GlobalVariable g : Settings.getInstance().getWorkbook().globalVariables().get(key)){
                MaterialCollapsibleBody body = new MaterialCollapsibleBody();
                
                MaterialRow rowToAdd = new MaterialRow();
            
                MaterialLabel label = new MaterialLabel("[" + i + "] - " + g.getValue().toString());
                MaterialModal changeModal = createModal(key, g.getValue().toString(), i);
                label.add(changeModal);
                
                rowToAdd.addClickHandler(event -> {
                    changeModal.open();
                });
                
                rowToAdd.add(label);

                body.add(rowToAdd);
                item.add(body);
                collaps.add(item);
                i++;
            }
            colapsBody.add(collaps);
        }
    }
    
    private MaterialModal createModal(String globalName, String value, Integer position){
        MaterialModal changeModal = new MaterialModal();
                    
        MaterialModalContent content = new MaterialModalContent();

        MaterialLabel valueLabel = new MaterialLabel("Actual Value: " + value);
        MaterialTextBox changeValue = new MaterialTextBox();
        
        MaterialButton button = new MaterialButton();
        button.setText("CHANGE");
        button.setIconType(IconType.SAVE);
        button.setIconPosition(IconPosition.RIGHT);
        
        button.addClickHandler(event -> {
            String newValue = changeValue.getText();
            Settings.getInstance().getWorkbook().globalVariables().get(globalName).get(position).setValue(new Value(newValue));
            changeModal.close();
            updateCollapsible();
            
            customTable.getView().setRedraw(true);
            customTable.getView().refresh();
        });
        
        content.add(valueLabel);
        content.add(changeValue);
        content.add(button);

        changeModal.add(content);
        
        return changeModal;
    }
    
    private String getParameters(Language lang) {
        String par = "Parameters: \n";
        try {
            for (FunctionParameter fp : lang.getFunction(basicWizardComboBox.getSelectedValue()).getParameters()) {
                par += "   -" + fp.getName();
            }
        } catch (UnknownElementException ex) {
            MaterialToast.fireToast("No parameters");
        }
        return par;
    }

    private String getDescription(Language lang) {
        String desc = "Description: ";
        try {
            desc += lang.getFunction(basicWizardComboBox.getSelectedValue()).getInformativeText();
        } catch (UnknownElementException ex) {
            MaterialToast.fireToast("No description");
        }
        return desc;
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
    public void deleteConfirmationHandler(ClickHandler cMDB) {
        conditionalModalDeleteButton.addClickHandler(cMDB);
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

    public void updateCellStyles(CellStyle cellStyle) {
        CellStyleServiceAsync cellStyleServiceAsync = GWT.create(CellStyleService.class);

        AsyncCallback<CellStyleDTO> callback = new AsyncCallback<CellStyleDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error saving cellStyle! " + caught.getMessage());
            }

            @Override
            public void onSuccess(CellStyleDTO result) {
                MaterialToast.fireToast("CellStyle repository updated!");
                CellStyleExtension.addCellStyle(CellStyle.fromDTO(result));
                customTable.getView().setRedraw(true);
                customTable.getView().refresh();
            }
        };

        cellStyleServiceAsync.saveCellStyle(cellStyle.toDTO(), callback);

        //loadCellStyles();
    }

    public void loadCellStyles() {
        //End of extension CellStyle loading

        /* 1050475 Hernani Gil
           Repository loading
         */

 /* Core08.1 */
        CellStyleServiceAsync cellStyleServiceAsync = GWT.create(CellStyleService.class);
        AsyncCallback<ArrayList<CellStyleDTO>> callbackCStyle = new AsyncCallback<ArrayList<CellStyleDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error loading cellStyles! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<CellStyleDTO> result) {
                ArrayList<CellStyle> lstResultFromDTO = new ArrayList<CellStyle>();
                for (CellStyleDTO cellStyleDTO : result) {
                    lstResultFromDTO.add(CellStyle.fromDTO(cellStyleDTO));
                }

                CellStyleExtension.lstCellStyle = lstResultFromDTO;
                MaterialToast.fireToast("Sucess loading cellStyles with " + result.size() + "cellStyles");
            }
        };

        cellStyleServiceAsync.getListCellStyle(callbackCStyle);

        /*End of extension cellSTyle loading*/
        MaterialToast.fireToast("now doing redraw");
        customTable.getView().setRedraw(true);
        customTable.getView().refresh();
    }

    @Override
    public Spreadsheet getCurrentSpreadsheet() {
        return Settings.getInstance().getWorkbook().getSpreadsheet(0);
    }

    @UiHandler("editWorkbookButton")
    void editWorkBook(ClickEvent e) {
        modal.open();
    }

    @UiHandler("cancelButtonModal")
    void cancelModal(ClickEvent e) {
        modal.close();
    }
    
    @Override
    public MaterialCollection getOpenWorkbooksCollection() {
        return this.openWorkbooks;
    }
}
