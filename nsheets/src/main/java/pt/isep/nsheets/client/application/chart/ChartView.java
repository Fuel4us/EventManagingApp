/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.application.chart;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.BarChart;
import com.googlecode.gwt.charts.client.corechart.BarChartOptions;
import com.googlecode.gwt.charts.client.options.Animation;
import com.googlecode.gwt.charts.client.options.AnimationEasing;
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
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import javax.inject.Inject;

/**
 *
 * @author pedromonteiro
 */
public class ChartView extends ViewImpl implements ChartPresenter.MyView {

    private static final int ENTER_TIME = 700;
    private static final int EXIT_TIME = 500;
    private boolean isLoop;
    private BarChart chart;
    private final String[] countries = new String[]{"Austria", "Bulgaria", "Denmark", "Greece"};
    private final int[] rows = new int[]{1, 2, 3};
    private int[][] columns = new int[][]{{1538156, 1336060, 1576579}, {366849, 400361, 440514}, {1001582, 993360, 1119450}, {941795, 997974, 930593}};
    private int[][] values = new int[][]{{1336060, 1538156, 1576579}, {400361, 366849, 440514}, {1001582, 1119450, 993360}, {997974, 941795, 930593}};
    private static boolean edit = false;

    interface Binder extends UiBinder<Widget, ChartView> {
    }

    class CellValidator extends RegExValidator {

        public CellValidator() {
            super("[a-zA-Z][0-9]*", "The cell pattern should be \"[a-zA-Z][0-9]*\", i.e: \"A3\"");
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
    MaterialButton save_btn;

    @UiField
    MaterialTextBox name_textbox, start_textbox, end_textbox;

    @UiField
    MaterialRadioButton row_r_btn, col_r_btn, accept_r_btn, refuse_r_btn;

    @UiHandler("chart_button")
    void click_chart(ClickEvent e) {
        chart_card.setVisible(false);
        edit_card.setVisible(true);

        enterChartCard();
    }

    @UiHandler("edit_button")
    void click_edit(ClickEvent e) {
        edit_card.setVisible(false);
        chart_card.setVisible(true);

        enterEditCard(false);
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
                save_btn.setText("Edit");
                save_btn.setIconType(IconType.CREATE);
                edit = true;
            }

        } else {
            if (enableElements(true)) {
                save_btn.setText("Save");
                save_btn.setIconType(IconType.SAVE);
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
        chart_card.setVisible(false);
        edit_button.setVisible(false);
        addValidators();
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(new Runnable() {

            @Override
            public void run() {
                chart = new BarChart();
                cardContent.add(chart);
                setLoop();
            }
        });
    }
    
    private void addValidators(){
        name_textbox.addValidator(new RequiredValidator());
        start_textbox.addValidator(new CellValidator());
        end_textbox.addValidator(new CellValidator());
    }
    
    private boolean validateForm(){
        return !(!name_textbox.validate() || !start_textbox.validate() || !end_textbox.validate());
    }

    private void setLoop() {

        Timer timer = new Timer() {

            public void run() {
                if (isLoop) {
                    drawChart(values, rows);
                    isLoop = false;
                } else {
                    drawChart(columns, rows);
                    isLoop = true;
                }

            }
        };
        timer.scheduleRepeating(1000);
    }

    private void drawChart(int[][] columns, int[] rows) {

        // Prepare the data
        DataTable dataTable = DataTable.create();
//                dataTable.
        dataTable.addColumn(ColumnType.STRING, "Year");
        for (int i = 0; i < countries.length; i++) {
            dataTable.addColumn(ColumnType.NUMBER, countries[i]);
        }
        dataTable.addRows(rows.length);
        for (int i = 0; i < rows.length; i++) {
            dataTable.setValue(i, 0, String.valueOf(rows[i]));
        }

        for (int col = 0; col < columns.length; col++) {
            for (int row = 0; row < columns[col].length; row++) {
                dataTable.setValue(row, col + 1, columns[col][row]);
            }
        }

        // Draw the chart
        chart.draw(dataTable, getOptions());
    }

    private BarChartOptions getOptions() {
        // Grid Lines
        Gridlines lines = Gridlines.create();
        lines.setColor("fff");

        // Text Positions X and Y Axis
        HAxis hAxis = HAxis.create();
        hAxis.setTextPosition(TextPosition.OUT);

        VAxis vAxis = VAxis.create();
        vAxis.setGridlines(lines);
        hAxis.setGridlines(lines);

        // Legend
        Legend legend = Legend.create();
        legend.setPosition(LegendPosition.NONE);
        legend.setAligment(LegendAlignment.START);

        // Set options
        BarChartOptions options = BarChartOptions.create();
        options.setHAxis(HAxis.create("Cups"));
        options.setVAxis(VAxis.create("Year"));
//		options.setColors("#2196f3");
//		options.setVAxis(vAxis);
        options.setHAxis(hAxis);
        options.setLegend(legend);

        // Set Animation
        Animation animation = Animation.create();
        animation.setDuration(700);
        animation.setEasing(AnimationEasing.OUT);
        options.setAnimation(animation);

        // Set Bar
        Bar bar = Bar.create();
        bar.setGroupWidth("20%");

        return options;
    }

    private void enterEditCard(boolean firstTime) {
        animate(chart_card, Transition.SLIDEOUTRIGHT, chart_button, false, firstTime, EXIT_TIME);

        animate(edit_card, Transition.SLIDEINLEFT, chart_button, true, firstTime, ENTER_TIME);

    }

    private void enterChartCard() {

        animate(edit_card, Transition.SLIDEOUTLEFT, edit_button, false, false, EXIT_TIME);

        animate(chart_card, Transition.SLIDEINRIGHT, edit_button, true, false, ENTER_TIME);

    }

    private void animate(MaterialCard card, Transition transition, MaterialAnchorButton btn, boolean setVisible, boolean firstTime, int time) {

        if (!firstTime) {

            MaterialAnimation animation = new MaterialAnimation();
            animation.setTransition(transition);
            animation.setDelay(0);
            animation.setDuration(time);
            animation.setInfinite(false);

            if (!setVisible) {
                animation.animate(card);

                Timer timer = new Timer() {

                    public void run() {
                        card.setVisible(false);
                    }
                };
                timer.schedule(time);
            } else {

                animation.animate(card);

                card.setVisible(true);

                animateButton(btn);
            }
        }

    }

    private void animateButton(MaterialAnchorButton btn) {
        btn.setVisible(false);

        MaterialAnimation animation = new MaterialAnimation();
        animation.setTransition(Transition.ROTATEIN);
        animation.setDuration(500);
        animation.setInfinite(false);

        Timer timer = new Timer() {

            public void run() {
                btn.setVisible(true);
                animation.animate(btn);
            }
        };
        timer.schedule(700);

    }

    private boolean enableElements(boolean enable) {

        if (!enable) {
            if (!validateForm()) {
                return false;
            } else if (start_textbox.getValue().length() == 0) {
                MaterialToast.fireToast("Invalid Start");
                return false;
            } else if (!accept_r_btn.getValue() && !refuse_r_btn.getValue()) {
                MaterialToast.fireToast("Select Consider First Element!");
                return false;

            }
        }
        name_textbox.setEnabled(enable);
        end_textbox.setEnabled(enable);
        start_textbox.setEnabled(enable);
        refuse_r_btn.setEnabled(enable);
        accept_r_btn.setEnabled(enable);
        row_r_btn.setEnabled(enable);
        col_r_btn.setEnabled(enable);
        return true;
    }

}
