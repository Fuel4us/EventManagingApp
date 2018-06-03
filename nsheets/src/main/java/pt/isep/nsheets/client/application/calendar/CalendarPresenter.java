package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
import pt.isep.nsheets.shared.services.*;

import java.util.ArrayList;

public class CalendarPresenter extends Presenter<CalendarPresenter.MyView, CalendarPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {
        void setContents(ArrayList<CalendarEventDTO> contents);
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

        refreshView();
    }

    private void refreshView() {
        CalendarEventServiceAsync workbooksSvc = GWT.create(CalendarEventService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<CalendarEventDTO>> callback = new AsyncCallback<ArrayList<CalendarEventDTO>>() {
            public void onFailure(Throwable caught) {
                // TODO: Do something with errors.
            }

            public void onSuccess(ArrayList<CalendarEventDTO> result) {
                view.setContents(result);
            }
        };

        workbooksSvc.getWorkbooks(callback);
    }

}