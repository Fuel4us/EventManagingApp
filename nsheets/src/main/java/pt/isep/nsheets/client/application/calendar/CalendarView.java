package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.emptystate.MaterialEmptyState;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.DatePickerContainer;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.ModalType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.CalendarEventDTO;
import pt.isep.nsheets.shared.services.CalendarEventService;
import pt.isep.nsheets.shared.services.CalendarEventServiceAsync;
import pt.isep.nsheets.shared.services.DataException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gonçalo Silva
 */
class CalendarView extends ViewImpl implements CalendarPresenter.MyView {

    interface Binder extends UiBinder<Widget, CalendarView> {

    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialEmptyState emptyState;

    @UiField
    MaterialButton createCalendarEventButton;

    MaterialModal modal;

    MaterialTextBox calendarEventNameTextBox;

    MaterialTextArea calendarEventDescriptionTextArea;

    MaterialDatePicker calendarEventDatePicker;

    MaterialTimePicker calendarEventTimePicker;

    MaterialRange calendarEventDuration;

    MaterialCard card;

    @Inject
    CalendarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        createCalendarEventButton.addClickHandler(event -> openModal());

        createCard(new CalendarEventDTO("Teste", "Isto é um teste", new Date(), 30));
    }

    void openModal() {
        createModal();

        modal.open();
    }

    void createEvent() {
        CalendarEventDTO calendarEvent = new CalendarEventDTO(calendarEventNameTextBox.getValue(), calendarEventDescriptionTextArea.getValue(), new Date(calendarEventDatePicker.getValue().getDay(), calendarEventDatePicker.getValue().getMonth(), calendarEventDatePicker.getValue().getYear(), calendarEventTimePicker.getValue().getHours(), calendarEventTimePicker.getValue().getMinutes()), calendarEventDuration.getValue());

        modal.close();

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                MaterialToast.fireToast("Event created successfully!", "rounded");
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }
        };

        try {
            service.createCalendarEvent(calendarEvent, callback);
        } catch (DataException e) {
            e.printStackTrace();
        }

        emptyState.setVisible(false);
        createCard(calendarEvent);
    }

    void closeModal() {
        modal.close();
    }

    void editEvent() {
        openModal();

        CalendarEventDTO calendarEvent = new CalendarEventDTO(calendarEventNameTextBox.getValue(), calendarEventDescriptionTextArea.getValue(), new Date(calendarEventDatePicker.getValue().getDay(), calendarEventDatePicker.getValue().getMonth(), calendarEventDatePicker.getValue().getYear(), calendarEventTimePicker.getValue().getHours(), calendarEventTimePicker.getValue().getMinutes()), calendarEventDuration.getValue());

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                MaterialToast.fireToast("Event edited successfully!", "rounded");
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }
        };

        service.editCalendarEvent(calendarEvent, callback);
    }

    void deleteEvent(CalendarEventDTO calendarEvent) {

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                MaterialToast.fireToast("Event deleted successfully!", "rounded");
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }
        };

        service.editCalendarEvent(calendarEvent, callback);
    }

    private void createModal() {
        modal = new MaterialModal();
        modal.setType(ModalType.FIXED_FOOTER);
        modal.setDismissible(false);
        htmlPanel.add(modal);

        MaterialModalContent content = new MaterialModalContent();
        modal.add(content);

        MaterialTitle title = new MaterialTitle();
        title.setTitle("New Event");
        content.add(title);

        calendarEventNameTextBox = new MaterialTextBox();
        calendarEventNameTextBox.setLabel("Name");
        content.add(calendarEventNameTextBox);

        calendarEventDescriptionTextArea = new MaterialTextArea();
        calendarEventDescriptionTextArea.setLabel("Description");
        content.add(calendarEventDescriptionTextArea);

        MaterialRow row = new MaterialRow();
        content.add(row);

        MaterialColumn aColumn = new MaterialColumn();
        aColumn.setGrid("s6");
        row.add(aColumn);

        MaterialColumn anotherColumn = new MaterialColumn();
        anotherColumn.setGrid("s4");
        row.add(anotherColumn);

        calendarEventDatePicker = new MaterialDatePicker();
        calendarEventDatePicker.setPlaceholder("Date");
        calendarEventDatePicker.setDateMin(new Date());
        calendarEventDatePicker.setContainer(DatePickerContainer.BODY);
        aColumn.add(calendarEventDatePicker);

        calendarEventTimePicker = new MaterialTimePicker();
        calendarEventTimePicker.setPlaceholder("Time");
        calendarEventTimePicker.setHour24(true);
        anotherColumn.add(calendarEventTimePicker);

        MaterialLabel durationLabel = new MaterialLabel();
        durationLabel.setText("Duration in minutes");
        content.add(durationLabel);

        calendarEventDuration = new MaterialRange();
        calendarEventDuration.setMin(1);
        calendarEventDuration.setMax(60);
        calendarEventDuration.setValue(15);
        content.add(calendarEventDuration);

        MaterialModalFooter modalFooter = new MaterialModalFooter();
        modal.add(modalFooter);

        MaterialButton cancelCalendarEventButton = new MaterialButton();
        cancelCalendarEventButton.setText("Close");
        cancelCalendarEventButton.setType(ButtonType.FLAT);
        cancelCalendarEventButton.addClickHandler(event -> closeModal());
        modalFooter.add(cancelCalendarEventButton);

        MaterialButton confirmCalendarEventButton = new MaterialButton();
        confirmCalendarEventButton.setText("Create");
        confirmCalendarEventButton.setType(ButtonType.FLAT);
        confirmCalendarEventButton.addClickHandler(event -> createEvent());
        modalFooter.add(confirmCalendarEventButton);
    }

    private void createCard(CalendarEventDTO calendarEvent) {
        card = new MaterialCard();
        htmlPanel.add(card);

        MaterialCardContent content = new MaterialCardContent();
        card.add(content);

        MaterialCardTitle title = new MaterialCardTitle();
        title.setText(calendarEvent.getName());
        content.add(title);

        MaterialLabel descriptionLabel = new MaterialLabel();
        descriptionLabel.setText(calendarEvent.getDescription());
        content.add(descriptionLabel);

        DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
        DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm");

        MaterialLabel dateLabel = new MaterialLabel();
        dateLabel.setText(dateFormat.format(calendarEvent.getDate()) + " at " + timeFormat.format(calendarEvent.getDate()));
        content.add(dateLabel);

        MaterialLabel durationLabel = new MaterialLabel();
        durationLabel.setText(calendarEvent.getDuration().toString() + " minutes");
        content.add(durationLabel);

        MaterialButton editButton = new MaterialButton();
        editButton.setIconType(IconType.EDIT);
        editButton.setType(ButtonType.FLAT);
        editButton.setText("Edit");
        editButton.addClickHandler(event -> editEvent());
        content.add(editButton);

        MaterialButton deleteButton = new MaterialButton();
        deleteButton.setIconType(IconType.DELETE);
        deleteButton.setType(ButtonType.FLAT);
        deleteButton.setText("Delete");
        deleteButton.addClickHandler(event -> deleteEvent(new CalendarEventDTO() /*ATENÇÃO*/));
        content.add(deleteButton);
    }

    @Override
    public void setContents(ArrayList<CalendarEventDTO> contents) {

    }
}