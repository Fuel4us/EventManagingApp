package pt.isep.nsheets.client.application.agenda;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaPresenter extends Presenter<AgendaPresenter.MyView, AgendaPresenter.MyProxy> {

    interface MyView extends View {

    }

    @NameToken(NameTokens.agenda)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<AgendaPresenter> {
    }

    /**
     *
     * @param eventBus
     * @param view
     * @param proxy
     */
    @Inject
    public AgendaPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        SetPageTitleEvent.fire("Agenda", "Agenda Stuff", "", "", this);
    }

}
