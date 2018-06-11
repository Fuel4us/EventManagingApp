package pt.isep.nsheets.client.application.form;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author João Pereira_1150478@isep.ipp.pt
 */
public class FormModule extends AbstractPresenterModule {
    
    /**
     * Configure method.
     */
    @Override
    protected void configure() {
        bindPresenter(FormPresenter.class, FormPresenter.MyView.class, FormView.class, FormPresenter.MyProxy.class);
    }
}
