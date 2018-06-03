package pt.isep.nsheets.client.application.extensions;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExtensionsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ExtensionsPresenter.class, ExtensionsPresenter.MyView.class, ExtensionsView.class, ExtensionsPresenter.MyProxy.class);
    }
}