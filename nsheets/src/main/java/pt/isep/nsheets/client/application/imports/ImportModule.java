package pt.isep.nsheets.client.application.imports;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ImportModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(ImportPresenter.class, ImportPresenter.MyView.class, ImportView.class, ImportPresenter.MyProxy.class);
    }
}