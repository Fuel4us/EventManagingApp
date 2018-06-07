package pt.isep.nsheets.client.application.code_js;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class Code_JavaScriptModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(Code_JavaScriptPresenter.class, Code_JavaScriptPresenter.MyView.class, Code_JavaScriptView.class, Code_JavaScriptPresenter.MyProxy.class);
    }
}
