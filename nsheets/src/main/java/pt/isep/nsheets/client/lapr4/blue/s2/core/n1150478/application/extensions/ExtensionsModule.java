package pt.isep.nsheets.client.lapr4.blue.s2.core.n1150478.application.extensions;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ExtensionsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ExtensionsPresenter.class, ExtensionsPresenter.MyView.class, ExtensionsView.class, ExtensionsPresenter.MyProxy.class);
    }
}