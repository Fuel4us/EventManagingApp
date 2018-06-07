/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.chart;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.ColumnChart;
import com.googlecode.gwt.charts.client.corechart.ColumnChartOptions;
import com.googlecode.gwt.charts.client.options.Bar;
import com.googlecode.gwt.charts.client.options.Gridlines;
import com.googlecode.gwt.charts.client.options.HAxis;
import com.googlecode.gwt.charts.client.options.Legend;
import com.googlecode.gwt.charts.client.options.LegendAlignment;
import com.googlecode.gwt.charts.client.options.LegendPosition;
import com.googlecode.gwt.charts.client.options.TextPosition;
import com.googlecode.gwt.charts.client.options.VAxis;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.base.validator.RegExValidator;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialAnchorButton;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialSwitch;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import javax.inject.Inject;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartsService;
import pt.isep.nsheets.shared.services.ChartsServiceAsync;

/**
 * The Chart View Class.
 *
 * @author pedromonteiro
 */
public class ChartView extends ViewImpl implements ChartPresenter.MyView {

    private static final int ENTER_TIME = 700;
    private static final int EXIT_TIME = 500;
    private ColumnChart chart;
    private boolean edit = false;
    public static ChartDTO chartDTO;
    Spreadsheet s = Settings.getInstance().getWorkbook().getSpreadsheet(0);
    

    @Override
    public String getFistCell() {
        return start_textbox.getValue();
    }

    @Override
    public String getLastCell() {
        return end_textbox.getValue();
    }

    @Override
    public String chartName() {
        return name_textbox.getValue();
    }

    @Override
    public boolean isConsiderFirstField() {
        return switch_considerFist.getValue();
    }

    @Override
    public boolean isRow() {
        return switch_isRow.getValue();
    }

    @Override
    public void saveDataHandler(ClickHandler click) {
        save_btn.addClickHandler(click);
    }

    @Override
    public void saveChart(ClickHandler click) {
        save_chart_btn.addClickHandler(click);
    }
    
    @Override
    public void click_edit(ClickHandler e) {
        edit_card.setVisible(false);
        chart_card.setVisible(true);

        enterEditCard(false);
    }

    @Override
    public boolean isEditMode() {
        return this.edit;
    }

    

    interface Binder extends UiBinder<Widget, ChartView> {
    }

    class CellValidator extends RegExValidator {

        public CellValidator() {
            super("[A-Za-z]+[0-9]+", "The cell pattern should be \"[a-zA-Z]{1,}[1-9]{1}[0-9]{0,}\", i.e: \"A3\"");
        }
    }

    class RequiredValidator extends RegExValidator {

        public RequiredValidator() {
            super(".+", "Required");
        }
    }

    @UiField
    MaterialCardContent cardContent;

    @UiField
    MaterialCard chart_card, edit_card;

    @UiField
    MaterialAnchorButton chart_button, edit_button;

    @UiField
    MaterialButton save_btn, save_chart_btn;

    @UiField
    MaterialTextBox name_textbox, start_textbox, end_textbox;

    @UiField
    MaterialSwitch switch_isRow, switch_considerFist;

    @UiField
    MaterialCardTitle chart_name;

    @UiHandler("chart_button")
    void click_chart(ClickEvent e) {
        chart_card.setVisible(false);
        edit_card.setVisible(true);

        enterChartCard();
    }

    @UiHandler("edit_button")
    void edit_button(ClickEvent e){
        click_edit(event->{});
    }

    @UiHandler("start_textbox")
    void typingStart(KeyPressEvent e) {
        start_textbox.validate();
    }

    @UiHandler("end_textbox")
    void typingEnd(KeyPressEvent e) {
        end_textbox.validate();
    }

    @UiHandler("save_btn")
    void click_save(ClickEvent e) {
        if (!edit) {
            if (enableElements(false)) {
                edit = true;
            }

        } else {
            if (enableElements(true)) {
                edit = false;
            }
        }
    }

    @Inject
    ChartView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initialize();
    }

    private void initialize() {
        enterEditCard(true);
        chart_button.setEnabled(false);
        chart_card.setVisible(false);
        edit_button.setVisible(false);
        addValidators();
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(new Runnable() {

            @Override
            public void run() {
                chart = new ColumnChart();
                cardContent.add(chart);
            }
        });
    }

    private void addValidators() {
        name_textbox.addValidator(new RequiredValidator());
        start_textbox.addValidator(new CellValidator());
        end_textbox.addValidator(new CellValidator());
    }

    private boolean validateForm() {
        
        if((!name_textbox.validate() || !start_textbox.validate() || !end_textbox.validate()))
            return false;
        return true;
    }
    

    @Override
    public void drawChart(String chart_name, ChartDTO dto) {

        // Prepare the data
        
        
        ChartsServiceAsync chartSrv = GWT.create(ChartsService.class);
            AsyncCallback<ChartDTO> callback = new AsyncCallback<ChartDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error draw chart --> " + caught.getMessage());
                    String [][]matrix = new String[][]{
                        {"1", "2", "3"},
                        {"1", "2", "3"},
                        {"1", "2", "A"}};
                    draw(chart_name, matrix, dto.isRow(), dto.isConsiderFirstField());
                    MaterialToast.fireToast("UNSUCESS drawing chart!");
                }

                @Override
                public void onSuccess(ChartDTO result) {
                    chartDTO = result;
                    draw(chart_name, result.getContent(), dto.isRow(), dto.isConsiderFirstField());
                    MaterialToast.fireToast("SUCESS drawing chart!");
                }

            };
            
            Spreadsheet spreadsheet= Settings.getInstance().getWorkbook().getSpreadsheet(0);
            
            if(spreadsheet.toDTO() != null && dto !=null) {
                chartSrv.getChartContent(dto, spreadsheet.toDTO(), callback);
            }
            
            
           
    }
    
    private void draw(String chart_name,String[][] matrix, boolean isRow, boolean considerFirstLine){
        
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "Year");
        String fieldName = "Row";
        int start;

        if (isRow) {
            
            char letter = 'A';
            for (int i = 0; i < matrix[0].length; i++) {
                dataTable.addColumn(ColumnType.NUMBER, String.valueOf(i));
            }
            dataTable.addRows(matrix.length);

            if (considerFirstLine) {
                start = 1;
                for (int i = 0; i < matrix.length; i++) {
                    dataTable.setValue(i, 0, String.valueOf(matrix[i][0]));
                }
            } else {
                start = 0;
                for (int i = 0; i < matrix.length; i++) {
                    dataTable.setValue(i, 0, String.valueOf(letter));
                    letter++;
                }
            }
            
            for (int row = 0; row < matrix.length; row++) {
                for (int col = start; col < matrix[row].length; col++) {
                    if (canAddColumn(matrix[row][col])) {
                        dataTable.setValue(row, col+1 , matrix[row][col]);
                    }
                }
            }

        } else {
            fieldName = "Column";
            char letter = 'A';
            matrix = transposeMatrix(matrix);
            for (int i = 0; i < matrix[0].length; i++) {
                dataTable.addColumn(ColumnType.NUMBER, String.valueOf(letter));
                letter++;
            }

            dataTable.addRows(matrix.length);

            if (considerFirstLine) {
                start = 1;
                for (int i = 0; i < matrix.length; i++) {
                    dataTable.setValue(i, 0, String.valueOf(matrix[i][0]));
                }

            } else {
                start = 0;
                for (int i = 0; i < matrix.length; i++) {
                    dataTable.setValue(i, 0, String.valueOf(i + 1));
                }
            }
            

            for (int row = 0; row < matrix.length; row++) {
                for (int col = start; col < matrix[row].length; col++) {
                    if (canAddColumn(matrix[row][col])) {
                        dataTable.setValue(row, col+1, matrix[row][col]);
                    }
                }
            }

        }

        // Draw the chart
        this.chart_name.setText(chart_name);
        chart.draw(dataTable, getOptions(fieldName, matrix));
    }

    private ColumnChartOptions getOptions(String HAxis_name, String[][] matrix) {
        // Grid Lines
        Gridlines lines = Gridlines.create();
        lines.setColor("fff");

        // Text Positions X and Y Axis
        HAxis hAxis = HAxis.create(HAxis_name);
        hAxis.setTextPosition(TextPosition.OUT);

        VAxis vAxis = VAxis.create("Values");
        vAxis.setMinValue(0);
        vAxis.setGridlines(lines);
        hAxis.setGridlines(lines);

        // Legend
        Legend legend = Legend.create();
        legend.setPosition(LegendPosition.NONE);
        legend.setAligment(LegendAlignment.START);

        // Set options
        ColumnChartOptions options = ColumnChartOptions.create();
        options.setVAxis(vAxis);
        options.setHAxis(hAxis);
        options.setLegend(legend);
        options.setWidth(matrix.length * matrix[0].length * 100);
        options.setHeight(300);

        // Set Bar
        Bar bar = Bar.create();
        bar.setGroupWidth("20%");

        return options;
    }

    public void enterEditCard(boolean firstTime) {
        animate(chart_card, Transition.SLIDEOUTRIGHT, chart_button, edit_button, false, firstTime, EXIT_TIME);
        animate(edit_card, Transition.SLIDEINLEFT, chart_button, edit_button, true, firstTime, ENTER_TIME);

    }

    private void enterChartCard() {
        animate(edit_card, Transition.SLIDEOUTLEFT, edit_button, chart_button, false, false, EXIT_TIME);
        animate(chart_card, Transition.SLIDEINRIGHT, edit_button, chart_button, true, false, ENTER_TIME);

    }

    private void animate(MaterialCard card, Transition transition, MaterialAnchorButton btnIn, MaterialAnchorButton btnOut, boolean setVisible, boolean firstTime, int time) {

        if (!firstTime) {

            MaterialAnimation animation = new MaterialAnimation();
            animation.setTransition(transition);
            animation.setDelay(0);
            animation.setDuration(time);
            animation.setInfinite(false);

            if (!setVisible) {
                animation.animate(card);
                animateButton(btnOut, false);

                Timer timer = new Timer() {

                    public void run() {
                        card.setVisible(false);
                    }
                };
                timer.schedule(time);
            } else {
                animation.animate(card);
                card.setVisible(true);
                animateButton(btnIn, true);
            }
        }

    }

    private void animateButton(MaterialAnchorButton btn, boolean setVisible) {

        MaterialAnimation animation = new MaterialAnimation();

        animation.setDuration(700);
        animation.setInfinite(false);

        if (setVisible) {
            btn.setVisible(false);
            animation.setTransition(Transition.ROTATEIN);
            Timer timer = new Timer() {

                public void run() {
                    btn.setVisible(true);
                    animation.animate(btn);
                }
            };
            timer.schedule(200);
        } else {
            animation.setTransition(Transition.ROTATEOUT);
            animation.animate(btn);
            Timer timer = new Timer() {

                public void run() {
                    btn.setVisible(false);

                }
            };
            timer.schedule(700);

        }

    }

    private boolean enableElements(boolean enable) {

        if (!enable) {
            if (!validateForm()) {
                return false;
            } else if (start_textbox.getValue().length() == 0) {
                MaterialToast.fireToast("Invalid Start");
                return false;
            }
            
            Address firstCell = new Address(start_textbox.getValue());
            Address lastCell = new Address(end_textbox.getValue());
            
            if(firstCell.compareTo(lastCell)>= 0){
                MaterialToast.fireToast("The first cell is should be shorter than the last");
                return false;
            }else if(firstCell.getColumn() >= s.getColumnCount() || firstCell.getRow()>=s.getRowCount() ||firstCell.getRow() < 0 || firstCell.getColumn()<0){
                MaterialToast.fireToast("The first cell is too big");
                return false;
            }else if(lastCell.getColumn() >= s.getColumnCount() || lastCell.getRow()>=s.getRowCount()||lastCell.getRow() < 0 || lastCell.getColumn()<0){
                MaterialToast.fireToast("The second cell is too big");
                return false;
            }

            save_btn.setText("Edit");
            save_btn.setIconType(IconType.CREATE);
        } else {
            save_btn.setText("Save");
            save_btn.setIconType(IconType.SAVE);
        }

        name_textbox.setEnabled(enable);
        end_textbox.setEnabled(enable);
        start_textbox.setEnabled(enable);
        switch_considerFist.setEnabled(enable);
        switch_isRow.setEnabled(enable);
        chart_button.setEnabled(!enable);

        return true;
    }

    //FIX ME
    private String[][] transposeMatrix(String[][] m) {

        String[][] temp = new String[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[j][i] = m[i][j];
            }
        }
        return temp;
    }

    @Override
    public ChartView fillChartInfo(String chart_name, Address firstCell, Address lastCell, boolean isConsideredFirst, boolean isRow) {
        this.name_textbox.setText(chart_name);
        this.switch_isRow.setValue(isRow);
        this.switch_considerFist.setValue(isConsideredFirst);
        if(firstCell == null) this.start_textbox.setText("");
        else this.start_textbox.setText(firstCell.toString());
        if(lastCell ==null) this.end_textbox.setText("");
        else this.end_textbox.setText(lastCell.toString());
        return this;
    }

    private boolean canAddColumn(String value) {
        Double number;

        try {
            number = Double.valueOf(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
