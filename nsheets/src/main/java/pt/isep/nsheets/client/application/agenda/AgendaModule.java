package pt.isep.nsheets.client.application.agenda;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(AgendaPresenter.class, AgendaPresenter.MyView.class, AgendaView.class, AgendaPresenter.MyProxy.class);
    }

}
