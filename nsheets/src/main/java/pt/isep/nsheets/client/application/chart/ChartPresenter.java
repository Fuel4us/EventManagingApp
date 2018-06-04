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
import pt.isep.nsheets.client.application.workbook.WorkbookView;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartsService;
import pt.isep.nsheets.shared.services.ChartsServiceAsync;

/**
 *
 * @author pedromonteiro
 */
public class ChartPresenter extends Presenter<ChartPresenter.MyView, ChartPresenter.MyProxy> {

    private MyView view;
    ChartDTO dto;

    interface MyView extends View {

        void saveDataHandler(ClickHandler click);

        void saveChart(ClickHandler click);

        String getFistCell();

        String getLastCell();

        String chartName();

        boolean isConsiderFirstField();

        boolean isRow();

        void drawChart(String chart_name, ChartDTO dto,String firstAddress, String lastAddress, boolean permute, boolean considerFirstLine);
        
        ChartView fillChartInfo(String chart_name, Address firstCell, Address lastCell, boolean isConsideredFirst, boolean isRow );

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
                    Window.alert(result.toString());
                }

            };
            
        
        this.view.saveDataHandler(event -> {
            this.view.drawChart(view.chartName(), dto, view.getFistCell(), view.getLastCell(), view.isConsiderFirstField(), view.isRow());
        });

        this.view.saveChart(event -> {

            
//            chartSrv.addChart(dto, callback);
            

        });
        
        

    }

    private void refreshView() {
        
        dto = WorkbookView.selectedChart;
        
        if(dto != null){
            this.view = view.fillChartInfo(dto.getGraph_name(), dto.getFirstAddress(), dto.getLastAddress(), dto.isConsiderFirstField(), dto.isRow());
        }else{
            this.view = view.fillChartInfo(null, null, null, true, true);
            
        }
        
//       MaterialToast.fireToast("Graph: "+dto.getGraph_name());
        
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
