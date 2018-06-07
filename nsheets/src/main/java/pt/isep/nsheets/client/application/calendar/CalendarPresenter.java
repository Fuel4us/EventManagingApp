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
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.CalendarEventDTO;
import pt.isep.nsheets.shared.services.CalendarEventService;
import pt.isep.nsheets.shared.services.CalendarEventServiceAsync;

import java.util.Date;
import java.util.List;

/**
 * @author Gonçalo Silva
 */
public class CalendarPresenter extends Presenter<CalendarPresenter.MyView, CalendarPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {
        void setContents(List<CalendarEventDTO> contents);

        void openModal();

        void closeModal();

        String title();

        String description();

        Date date();

        Date time();

        int duration();
    }

    @NameToken(NameTokens.calendar)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<CalendarPresenter> {

    }

    @Inject
    CalendarPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;
    }

    private void refreshView() {
        CalendarEventServiceAsync calendarEventServiceAsync = GWT.create(CalendarEventService.class);

        AsyncCallback<List<CalendarEventDTO>> asyncCallback = new AsyncCallback<List<CalendarEventDTO>>() {
            @Override
            public void onSuccess(List<CalendarEventDTO> result) {
                view.setContents(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Database connection failed", "rounded");
            }
        };

        calendarEventServiceAsync.getCalendarEvents(asyncCallback);
    }


    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Calendar", "Manage your calendars and events", "", "", this);

        refreshView();
    }
}