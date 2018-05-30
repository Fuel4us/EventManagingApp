package pt.isep.nsheets.client.application.export;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExportModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ExportPresenter.class, ExportPresenter.MyView.class, ExportView.class, ExportPresenter.MyProxy.class);
    }
}