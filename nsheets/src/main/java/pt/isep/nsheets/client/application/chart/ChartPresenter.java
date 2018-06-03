package pt.isep.nsheets.client.application.chart;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
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
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
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

    interface MyView extends View {

        void saveDataHandler(ClickHandler click);

        void saveChart(ClickHandler click);

        String getFistCell();

        String getLastCell();

        String chartName();

        boolean isConsiderFirstField();

        boolean isRow();

        void drawChart(String chart_name, String[][] matrix, boolean permute, boolean considerFirstLine);

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
            
            ChartDTO dto = createDTOTest();

            this.view.drawChart(dto.getGraph_name(), dto.getContent(), dto.isIsRow(), dto.isConsiderFirstField());

        });

        this.view.saveChart(event -> {

            ChartDTO dto = createDTOTest();
            
            ChartsServiceAsync chartSrv = GWT.create(ChartsService.class);
            AsyncCallback<ChartDTO> callback = new AsyncCallback<ChartDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error --> " + caught.getMessage());
                }

                @Override
                public void onSuccess(ChartDTO result) {
                    Window.alert(result.toString());
                }

            };
            
            chartSrv.addChart(dto, ChartType.BAR_CHART, callback);

        });

    }

    private void refreshView() {
    }

    private ChartDTO createDTOTest() {
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

//        Workbook wb = new Workbook(matrix);
//        Spreadsheet ss = wb.getSpreadsheet(0);

        ChartDTO dto = new ChartDTO(
                view.chartName(),
                new Address(view.getLastCell()),
                new Address(view.getLastCell()),
                matrix,
                view.isRow(),
                view.isConsiderFirstField());

        return dto;
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
