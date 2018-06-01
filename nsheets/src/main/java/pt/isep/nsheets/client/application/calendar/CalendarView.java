package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.emptystate.MaterialEmptyState;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.DatePickerContainer;
import gwt.material.design.client.constants.ModalType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.services.CalendarEventDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;

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

    @Inject
    CalendarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        createCalendarEventButton.addClickHandler(event -> openModal());
    }

    void openModal() {
        createModal();

        modal.open();
    }

    void createEvent() {
        CalendarEventDTO calendarEvent = new CalendarEventDTO(calendarEventNameTextBox.getValue(), calendarEventDescriptionTextArea.getValue(), calendarEventDatePicker.getValue(), calendarEventTimePicker.getValue(), calendarEventDuration.getValue());

        modal.close();

        MaterialToast.fireToast("Event created successfully", "rounded");

        emptyState.setVisible(false);
        createCard(calendarEvent);
    }

    void closeModal() {
        modal.close();
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
        MaterialCard card = new MaterialCard();
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

        MaterialLabel dateLabel = new MaterialLabel();
        dateLabel.setText(dateFormat.format(calendarEvent.getDate()));
        content.add(dateLabel);

        DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm");

        MaterialLabel timeLabel = new MaterialLabel();
        timeLabel.setText(timeFormat.format(calendarEvent.getTime()));
        content.add(timeLabel);

        MaterialLabel durationLabel = new MaterialLabel();
        durationLabel.setText(calendarEvent.getDuration().toString() + " minutes");
        content.add(durationLabel);
    }

    @Override
    public void setContents(ArrayList<CalendarEventDTO> contents) {

    }
}