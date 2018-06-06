package pt.isep.nsheets.client.application.macro;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MacroModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(MacroPresenter.class, MacroPresenter.MyView.class, MacroView.class, MacroPresenter.MyProxy.class);
    }
}
