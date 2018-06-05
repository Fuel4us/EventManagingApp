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

import gwt.material.design.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.table.MaterialDataTable;
import pt.isep.nsheets.client.application.workbook.WorkbookView.SheetCell;
import pt.isep.nsheets.client.place.ParameterTokens;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellListener;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.ext.ExtensionManager;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.ConditionalFormattingExtension;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.shared.services.ChartsService;
import pt.isep.nsheets.shared.services.ChartsServiceAsync;

import java.text.ParseException;

public class WorkbookPresenter extends Presenter<WorkbookPresenter.MyView, WorkbookPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        public MaterialTextBox getFirstBox();

        public MaterialIcon getFirstButton();

        public MaterialDataTable<SheetCell> getTable();

        public Cell getActiveCell();

        public MaterialDropDown getChartDropDown();

        public MaterialPopupMenu getPopChart();

        public MaterialModal getConditionalModal();

        public void addConfirmationHandler(ClickHandler cMDB);

        public int getBackgroudColorTrue();

        public int getFontColorTrue();

        public int getBackgroudColorFalse();

        public int getFontColorFalse();

        public String getOperator();

        public String getConditionalValue();

        void setText(String string);

        void setContents(WorkbookDTO contents);
    }

    private WorkbookDTO wDTO;

    @ProxyStandard
    @NameToken(NameTokens.workbook)
    interface MyProxy extends ProxyPlace<WorkbookPresenter> {
    }

    @Inject
    WorkbookPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;
        view.addConfirmationHandler(event -> {
            if (view.getConditionalValue().matches("[+-]?([0-9]*[.])?[0-9]+")) {
                conditionalFormattingAction();

                view.getConditionalModal().close();
            }
        });

        /* 1050475 Hernani Gil
           Repository loading
         */
        //conditionalService();
        this.wDTO = Settings.getInstance().getWorkbook().toDTO();
        this.view = view;

        this.placeManager = placeManager;
    }

    PlaceManager placeManager;

    @Override
    protected void onReset() {
        super.onReset();

        getView().getFirstButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                // Let's test formulas...
//				String source=getView().getFirstBox().getText();
//				
//				// Fetches a cell
//				Workbook workbook = new Workbook(1);
//				Spreadsheet sheet = workbook.getSpreadsheet(0);
//				Cell cell = sheet.getCell(new Address(0, 0));
//
//				Formula formula;
//				String result="";
//				try {
//					formula = FormulaCompiler.getInstance().compile(cell, source);
//					
//					Expression expression = formula.getExpression();
//					result="Formula: " + expression + " = " + expression.evaluate();
//					
//				} catch (FormulaCompilationException e) {
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//					result=e.getMessage();
//				} catch (IllegalValueTypeException e) {
//					// TODO Auto-generated catch block
//					// e.printStackTrace();
//					result=e.getMessage();
//				} finally {
//					getView().getResultLabel().setText(result);
//				}

                // Example on how to jump to another place
//				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.about)
//						.with("name", result).build();
//
//				placeManager.revealPlace(request);
            }
        });

//        getView().getTable().addClickHandler(handler -> {
//            if (getView().getActiveCell().hasChart()) {
//                updateCellCharts(getView().getActiveCell());
//                getView().getPopChart().setPopupPosition(handler.getClientX(), handler.getClientY());
//                getView().getPopChart().open();
//            } else {
//                WorkbookView.selectedChart = null;
//            }
//        });
        updateCellCharts();
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        updateCellCharts();
        SetPageTitleEvent.fire("Workbook", "The current Workbook", "", "", this);
        

        this.timer();
    }

    private void redirectToChartPage() {
        String token = placeManager
                .getCurrentPlaceRequest()
                .getParameter(ParameterTokens.REDIRECT, NameTokens.getChart());
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(token).build();

        placeManager.revealPlace(placeRequest);
    }

    private void updateCellCharts() {

        ChartsServiceAsync chartSrv = GWT.create(ChartsService.class);
        AsyncCallback<ArrayList<ChartDTO>> callback = new AsyncCallback<ArrayList<ChartDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error draw chart --> " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<ChartDTO> result) {
                getView().getChartDropDown().clear();
                for (ChartDTO chart : result) {
                    Settings.getInstance().getWorkbook().getSpreadsheet(0).getCell(chart.getAssociatedCell()).addChart(chart);
                }
                addPopUptoCell();
                MaterialToast.fireToast("Chart Information successfully updated ");
            }

        };
        chartSrv.getCharts(callback);

    }

    private void addPopUptoCell() {

        getView().getChartDropDown().clear();

        getView().getTable().addClickHandler(handler -> {
            if (getView().getActiveCell().hasChart()) {
                for (ChartDTO chart : getView().getActiveCell().chartList()) {
                    MaterialLink link = new MaterialLink(chart.getGraph_name(), null, IconType.INSERT_CHART);
                    link.setTextColor(Color.BLACK);
                    link.addClickHandler(event -> {
                        WorkbookView.selectedChart = chart;
                        MaterialToast.fireToast(WorkbookView.selectedChart.getGraph_name());
                        redirectToChartPage();
                    });
                    getView().getChartDropDown().add(link);
                }
                getView().getPopChart().setPopupPosition(handler.getClientX(), handler.getClientY());
                getView().getPopChart().open();
            } else {
                WorkbookView.selectedChart = null;
            }
        });

    }

    protected void conditionalFormattingAction() {

        try {
            Value conditionalValue = Value.parseNumericValue(this.view.getConditionalValue());
            int[] values = new int[4];
            values[0] = view.getBackgroudColorTrue();
            values[1] = view.getFontColorTrue();
            values[2] = view.getBackgroudColorFalse();
            values[3] = view.getFontColorFalse();

            Configuration configuration = new Configuration(values);

            Conditional conditional = new Conditional(this.view.getActiveCell(), configuration, view.getOperator(), conditionalValue);

            /*1050475 lang03.1 persistencia com erro no Conditional service
            ConditionalServiceAsync conditionalSvc = GWT.create(ConditionalService.class);

            AsyncCallback<ConditionalDTO> callback = new AsyncCallback<ConditionalDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error configuring Conditionalextension! " + caught.getMessage());
                }

                @Override
                public void onSuccess(ConditionalDTO result) {
                    MaterialToast.fireToast("Conditionalextension conditional configured!");
                }
                conditionalSvc.saveConditional(conditional.toDTO(), callback);
            };
             */
            Extension extension = ExtensionManager.getInstance().getExtension("ConditionalExtension");
            ConditionalFormattingExtension.addConditional(conditional);
            this.view.getActiveCell().getExtension("ConditionalExtension");
            MaterialToast.fireToast(this.view.getActiveCell().getAddress().toString() + " conditional result ="
                    + ConditionalFormattingExtension.setOperation(this.view.getActiveCell(), conditional.getCondOperator(), conditional.getCondValue()));

            for (CellListener l : this.view.getActiveCell().getCellListeners()) {
                l.valueChanged(this.view.getActiveCell());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /* 1050475 Hernani Gil
               Repository loading
     */
 /*
    private void conditionalService() {
        ConditionalServiceAsync conditionalSvc = GWT.create(ConditionalService.class);

        AsyncCallback<List<ConditionalDTO>> callback = new AsyncCallback<List<ConditionalDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error retrieving conditional! " + caught.getMessage());
            }

            @Override
            public void onSuccess(List<ConditionalDTO> conditionalDTOS) {
                MaterialToast.fireToast("List conditionals retrieved! ");
            }
        };
        conditionalSvc.getListConditional(callback);
    }*/
    private void refreshWorkbooks() {
        WorkbooksServiceAsync workbookSvc = GWT.create(WorkbooksService.class);

        AsyncCallback<ArrayList<WorkbookDTO>> callback = new AsyncCallback<ArrayList<WorkbookDTO>>() {
            public void onFailure(Throwable caught) {

            }

            public void onSuccess(ArrayList<WorkbookDTO> result) {
                for (WorkbookDTO w : result) {
                    if (wDTO.equals(w)) {
                        view.setContents(w);
                    }
                }

                //nunca deve chegar aqui
                //alterar pagina atual para a home em vez disto
                view.setContents(null);
            }
        };

        workbookSvc.getWorkbooks(callback);
    }

    private void timer() {
        Timer t = new Timer() {
            @Override
            public void run() {
                refreshWorkbooks();
            }
        };
        t.scheduleRepeating(1000);
    }

}
