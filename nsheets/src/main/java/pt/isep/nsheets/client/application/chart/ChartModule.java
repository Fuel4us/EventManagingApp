package pt.isep.nsheets.client.application.chart;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ChartModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ChartPresenter.class, ChartPresenter.MyView.class, ChartView.class, ChartPresenter.MyProxy.class);
    }
}