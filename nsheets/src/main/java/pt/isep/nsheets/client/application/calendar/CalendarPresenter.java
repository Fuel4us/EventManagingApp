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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Gonçalo Silva
 */
public class CalendarPresenter extends Presenter<CalendarPresenter.MyView, CalendarPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {
        void setContents(List<CalendarEventDTO> contents);

//        void createEventClickHandler(ClickHandler ch);
//
//        void editEventClickHandler(ClickHandler ch);
//
//        void deleteEventClickHandler(ClickHandler ch);
//
//        void createButtonClickHandler(ClickHandler ch);
//
//        void editButtonClickHandler(ClickHandler ch);
//
//        void cancelButtonClickHandler(ClickHandler ch);

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

//        this.view.createEventClickHandler(e -> {
//            CalendarEventServiceAsync workbooksSvc = GWT.create(CalendarEventService.class);
//
//            AsyncCallback<CalendarEventDTO> callback = new AsyncCallback<CalendarEventDTO>() {
//                @Override
//                public void onSuccess(CalendarEventDTO result) {
//                    MaterialToast.fireToast("Event created successfully", "rounded");
//
//                    refreshView();
//                }
//
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//            };
//
//            CalendarEventDTO dto = new CalendarEventDTO(this.view.title(), this.view.description(), this.view.date(), this.view.time(), this.view.duration());
//            workbooksSvc.createCalendarEvent(dto, callback);
//
//            this.view.closeModal();
//        });
//
//        this.view.editEventClickHandler(e -> {
//            CalendarEventServiceAsync workbooksSvc = GWT.create(CalendarEventService.class);
//
//            AsyncCallback<CalendarEventDTO> callback = new AsyncCallback<CalendarEventDTO>() {
//                @Override
//                public void onSuccess(CalendarEventDTO result) {
//                    MaterialToast.fireToast("Event edited successfully", "rounded");
//
//                    refreshView();
//                }
//
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//            };
//
//            CalendarEventDTO dto = new CalendarEventDTO(this.view.title(), this.view.description(), this.view.date(), this.view.time(), this.view.duration());
//            workbooksSvc.editCalendarEvent(dto, callback);
//
//            this.view.closeModal();
//        });
//
//        this.view.deleteEventClickHandler(e -> {
//            CalendarEventServiceAsync workbooksSvc = GWT.create(CalendarEventService.class);
//
//            AsyncCallback<CalendarEventDTO> callback = new AsyncCallback<CalendarEventDTO>() {
//                @Override
//                public void onSuccess(CalendarEventDTO result) {
//                    MaterialToast.fireToast("Event edited successfully", "rounded");
//
//                    refreshView();
//                }
//
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//            };
//
//            CalendarEventDTO dto = new CalendarEventDTO(this.view.title(), this.view.description(), this.view.date(), this.view.time(), this.view.duration());
//            workbooksSvc.deleteCalendarEvent(dto, callback);
//
//            this.view.closeModal();
//        });
//
//        this.view.createButtonClickHandler(e -> {
//            GWT.create(CalendarEventService.class);
//
//            new AsyncCallback<CalendarEventDTO>() {
//                @Override
//                public void onSuccess(CalendarEventDTO result) {
//                    refreshView();
//                }
//
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//            };
//
//            this.view.openModal();
//        });
//
//        this.view.editButtonClickHandler(e -> {
//            GWT.create(CalendarEventService.class);
//
//            new AsyncCallback<CalendarEventDTO>() {
//                @Override
//                public void onSuccess(CalendarEventDTO result) {
//                    refreshView();
//                }
//
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//            };
//
//            this.view.openModal();
//        });
//
//        this.view.cancelButtonClickHandler(e -> {
//            GWT.create(CalendarEventService.class);
//
//            new AsyncCallback<CalendarEventDTO>() {
//                @Override
//                public void onSuccess(CalendarEventDTO result) {
//                    refreshView();
//                }
//
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//            };
//
//            this.view.closeModal();
//        });
    }

    private void refreshView() {
        CalendarEventServiceAsync calendarEventServiceAsync = GWT.create(CalendarEventService.class);

        AsyncCallback<ArrayList<CalendarEventDTO>> asyncCallback = new AsyncCallback<ArrayList<CalendarEventDTO>>() {
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }

            public void onSuccess(ArrayList<CalendarEventDTO> result) {
                view.setContents(result);
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