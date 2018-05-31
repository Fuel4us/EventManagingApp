package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

class CalendarView extends ViewImpl implements CalendarPresenter.MyView {
    interface Binder extends UiBinder<Widget, CalendarView> {
    }

    @Inject
    CalendarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    MaterialButton createCalendarEventButton;

    @UiField
    MaterialButton confirmCalendarEventButton;

    @UiField
    MaterialButton cancelCalendarEventButton;

    @UiField
    MaterialModal newEventModal;

    @UiHandler("createCalendarEventButton")
    void onCalendarEventCreation(ClickEvent e) {
        newEventModal.open();
    }

    @UiHandler("confirmCalendarEventButton")
    void onCalendarEventConfirmation(ClickEvent e) {
        newEventModal.close();

        MaterialToast.fireToast("Event created successfully", "rounded");

        /*CalendarEvent calendarEvent = new CalendarEvent();
        if (calendarEvent != null) {
            MaterialToast.fireToast("Event created successfully", "rounded");
        } else {
            MaterialToast.fireToast("An error occurred... Please try again", "rounded");
        }*/
    }


    @UiHandler("cancelCalendarEventButton")
    void onCalendarEventCancelation(ClickEvent e) {
        newEventModal.close();
    }
}