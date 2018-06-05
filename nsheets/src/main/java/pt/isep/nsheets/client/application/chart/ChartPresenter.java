package pt.isep.nsheets.client.application.chart;

import com.google.gwt.core.client.GWT;
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
import javafx.scene.paint.Material;
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
 *
 * @author pedromonteiro
 */
public class ChartPresenter extends Presenter<ChartPresenter.MyView, ChartPresenter.MyProxy> {

    private MyView view;
    ChartDTO dto;
    Spreadsheet s = Settings.getInstance().getWorkbook().getSpreadsheet(0);

    interface MyView extends View {

        void saveDataHandler(ClickHandler click);

        void saveChart(ClickHandler click);

        String getFistCell();

        String getLastCell();

        String chartName();

        boolean isConsiderFirstField();

        boolean isRow();

        boolean isEditMode();

        void drawChart(String chart_name, ChartDTO dto);

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

        refreshView();

        ChartsServiceAsync chartSrv = GWT.create(ChartsService.class);
        AsyncCallback<ChartDTO> callback = new AsyncCallback<ChartDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error --> " + caught.getMessage());
            }

            @Override
            public void onSuccess(ChartDTO result) {
                MaterialToast.fireToast(result.getGraph_name()+"added successfully!");
            }

        };
        this.view.saveDataHandler(event -> {

            dto = new ChartDTO(view.chartName(),
                    new Address(view.getFistCell()),
                    new Address(view.getLastCell()),
                    view.isRow(),
                    view.isConsiderFirstField(),
                    ChartType.BAR_CHART,
                    null,
                    null);

            if (view.isEditMode()) {
                if (dto.getFirstAddress().compareTo(dto.getLastAddress()) >= 0) {
                    MaterialToast.fireToast("The first cell is should be shorter than the last");
                } else {
                    this.view.drawChart(view.chartName(), dto);
                }
            }

        });

        this.view.saveChart(event -> {
            chartSrv.addChart(dto, s.toDTO(), callback);
        });

    }

    private void refreshView() {

        dto = WorkbookView.selectedChart;

        if (dto != null) {
            this.view = view.fillChartInfo(dto.getGraph_name(), dto.getFirstAddress(), dto.getLastAddress(), dto.isConsiderFirstField(), dto.isRow());
        } else {
            dto = new ChartDTO();
            this.view = view.fillChartInfo(null, null, null, true, true);
        }

    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Chart", "Widzar to create Charts", "", "", this);
        refreshView();
    }

    private void prepareInformation() {
    }
}
