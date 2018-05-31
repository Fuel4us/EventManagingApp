package pt.isep.nsheets.client.application.calendar;

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

public class CalendarPresenter extends Presenter<CalendarPresenter.MyView, CalendarPresenter.MyProxy> {

    interface MyView extends View {
    }

    @NameToken(NameTokens.calendar)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<CalendarPresenter> {
    }

    @Inject
    CalendarPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Calendar", "Manage your calendars and events", "", "", this);
    }

}