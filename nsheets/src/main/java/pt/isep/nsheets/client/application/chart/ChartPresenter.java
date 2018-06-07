package pt.isep.nsheets.client.application.chart;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.Settings;
import pt.isep.nsheets.client.application.workbook.WorkbookView;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartType;
import pt.isep.nsheets.shared.services.ChartsService;
import pt.isep.nsheets.shared.services.ChartsServiceAsync;

/**
 * Chart Presenter.
 * @author pedromonteiro
 */
public class ChartPresenter extends Presenter<ChartPresenter.MyView, ChartPresenter.MyProxy> {

    private MyView view;
    Spreadsheet s = Settings.getInstance().getWorkbook().getSpreadsheet(0);

    interface MyView extends View {

        void saveDataHandler(ClickHandler click);

        void saveChart(ClickHandler click);
        
        void click_edit(ClickHandler click);

        String getFistCell();

        String getLastCell();

        String chartName();

        boolean isConsiderFirstField();

        boolean isRow();

        boolean isEditMode();

        void drawChart(String chart_name, ChartDTO dto);
        
        void enterEditCard(boolean firstTime);

        ChartView fillChartInfo(String chart_name, Address firstCell, Address lastCell, boolean isConsideredFirst, boolean isRow);
        

    }

    @NameToken(NameTokens.chart)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ChartPresenter> {
    }

    @Inject
    ChartPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.saveDataHandler(event -> {

            if (view.isEditMode()) {
                ChartView.chartDTO = new ChartDTO(view.chartName(),
                        new Address(view.getFistCell()),
                        new Address(view.getLastCell()),
                        view.isRow(),
                        view.isConsiderFirstField(),
                        ChartType.BAR_CHART,
                        null,
                        null);

                this.view.drawChart(view.chartName(), ChartView.chartDTO);
            }

        });

        this.view.saveChart(event -> {
            ChartsServiceAsync chartSrv = GWT.create(ChartsService.class);
            AsyncCallback<ChartDTO> callback = new AsyncCallback<ChartDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error --> " + caught.getMessage());
                }

                @Override
                public void onSuccess(ChartDTO result) {
                    MaterialToast.fireToast(result.getGraph_name() + " added successfully!");
                }

            };
            chartSrv.addChart(ChartView.chartDTO, callback);
        });

    }

    private void refreshView() {

        MaterialToast.fireToast("Charts Updated!");

        ChartView.chartDTO = WorkbookView.selectedChart;

        if (ChartView.chartDTO != null) {
            this.view = view.fillChartInfo(ChartView.chartDTO.getGraph_name(), ChartView.chartDTO.getFirstAddress(), ChartView.chartDTO.getLastAddress(), ChartView.chartDTO.isConsiderFirstField(), ChartView.chartDTO.isRow());
        } else {
            this.view = view.fillChartInfo(null, null, null, true, true);
        }

    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Chart", "Widzar to create Charts", "", "", this);
        this.view.click_edit((event) -> {});
        refreshView();
    }

    private void prepareInformation() {
    }
}
