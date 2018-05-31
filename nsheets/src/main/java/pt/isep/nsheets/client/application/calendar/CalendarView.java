package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

class CalendarView extends ViewImpl implements CalendarPresenter.MyView {
    interface Binder extends UiBinder<Widget, CalendarView> {
    }

    @UiField
    MaterialButton CreateCalendarEventButton;
    @UiField
    MaterialButton ConfirmCalendarEventButton;

    @UiField
    MaterialDatePicker CalendarEventDatePicker;
    @UiField
    MaterialTimePicker CalendarEventTimePicker;

    @Inject
    CalendarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("CreateCalendarEventButton")
    void onCreateCalendarEventPress(ClickEvent e) {
    }

    @UiHandler("ConfirmCalendarEventButton")
    void onCalendarEventConfirmation(ClickEvent e) {
        MaterialToast.fireToast("New Event Created!");
    }
}