package pt.isep.nsheets.client.application.code;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class CodeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(CodePresenter.class, CodePresenter.MyView.class, CodeView.class, CodePresenter.MyProxy.class);
    }
}
