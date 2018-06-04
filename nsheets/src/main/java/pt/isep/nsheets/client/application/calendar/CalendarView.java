package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
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

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

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

        createCalendarEventButton.addClickHandler(event -> createModal());
    }


    public void createEvent() {
        closeModal();

        CalendarEventDTO calendarEvent = new CalendarEventDTO(calendarEventNameTextBox.getValue(), calendarEventDescriptionTextArea.getValue(), calendarEventDatePicker.getValue(), calendarEventDuration.getValue());

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<CalendarEventDTO> callback = new AsyncCallback<CalendarEventDTO>() {
            public void onSuccess(CalendarEventDTO calendarEventDTO) {
                MaterialToast.fireToast("Event created successfully!", "rounded");
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }
        };

        service.createCalendarEvent(calendarEvent, callback);

        emptyState.setVisible(false);
        createCard(calendarEvent);
    }

    public void editEvent() {
        CalendarEventDTO calendarEvent = new CalendarEventDTO(calendarEventNameTextBox.getValue(), calendarEventDescriptionTextArea.getValue(), calendarEventDatePicker.getValue(), calendarEventDuration.getValue());

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<CalendarEventDTO> callback = new AsyncCallback<CalendarEventDTO>() {
            public void onSuccess(CalendarEventDTO aVoid) {
                MaterialToast.fireToast("Event edited successfully!", "rounded");
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }
        };

        service.editCalendarEvent(calendarEvent, callback);
    }

    public void deleteEvent(CalendarEventDTO calendarEvent) {
        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<CalendarEventDTO> callback = new AsyncCallback<CalendarEventDTO>() {
            public void onSuccess(CalendarEventDTO aVoid) {
                MaterialToast.fireToast("Event deleted successfully!", "rounded");
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error!", "rounded");
            }
        };

        service.deleteCalendarEvent(calendarEvent, callback);
    }

    public void createModal() {
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
        confirmCalendarEventButton.setText("Edit");
        confirmCalendarEventButton.setType(ButtonType.FLAT);
        confirmCalendarEventButton.addClickHandler(event -> createEvent());
        modalFooter.add(confirmCalendarEventButton);

        openModal();
    }

    public void createEditModal(CalendarEventDTO calendarEventDTO) {
        modal = new MaterialModal();
        modal.setType(ModalType.FIXED_FOOTER);
        modal.setDismissible(false);
        htmlPanel.add(modal);

        MaterialModalContent content = new MaterialModalContent();
        modal.add(content);

        MaterialTitle title = new MaterialTitle();
        title.setTitle("Edit Event");
        content.add(title);

        calendarEventNameTextBox = new MaterialTextBox();
        calendarEventNameTextBox.setLabel("Name");
        calendarEventNameTextBox.setValue(calendarEventDTO.getName());
        content.add(calendarEventNameTextBox);

        calendarEventDescriptionTextArea = new MaterialTextArea();
        calendarEventDescriptionTextArea.setLabel("Description");
        calendarEventDescriptionTextArea.setValue(calendarEventDTO.getDescription());
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
        calendarEventDatePicker.setValue(calendarEventDTO.getDate());
        aColumn.add(calendarEventDatePicker);

        calendarEventTimePicker = new MaterialTimePicker();
        calendarEventTimePicker.setPlaceholder("Time");
        calendarEventTimePicker.setHour24(true);
        calendarEventTimePicker.setValue(calendarEventDTO.getDate());
        anotherColumn.add(calendarEventTimePicker);

        MaterialLabel durationLabel = new MaterialLabel();
        durationLabel.setText("Duration in minutes");
        durationLabel.setValue(calendarEventDTO.getDuration().toString());
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
        confirmCalendarEventButton.addClickHandler(event -> editEvent());
        modalFooter.add(confirmCalendarEventButton);

        openModal();
    }

    public MaterialCard createCard(CalendarEventDTO calendarEvent) {
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
        editButton.addClickHandler(event -> createEditModal(calendarEvent));
        content.add(editButton);

        MaterialButton deleteButton = new MaterialButton();
        deleteButton.setIconType(IconType.DELETE);
        deleteButton.setType(ButtonType.FLAT);
        deleteButton.setText("Delete");
        deleteButton.addClickHandler(event -> deleteEvent(calendarEvent));
        content.add(deleteButton);

        return card;
    }

    @Override
    public void setContents(List<CalendarEventDTO> contents) {
        MaterialRow row = null;
        int colCount = 1;

        emptyState.setVisible(false);

        for (CalendarEventDTO calendarEventDTO : contents) {
            MaterialCard card = createCard(calendarEventDTO);

            if (colCount == 1) {
                row = new MaterialRow();
                htmlPanel.add(row);
                ++colCount;
                if (colCount >= 4) colCount = 1;
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("s4");
            row.add(col);

            col.add(card);
        }
    }

    @Override
    public void openModal() {
        this.modal.open();
    }

    @Override
    public void closeModal() {
        this.modal.close();
    }

    @Override
    public void addClickHandler(ClickHandler ch) {

    }

    @Override
    public void buttonClickHandler(ClickHandler ch) {

    }

    @Override
    public String title() {
        return this.calendarEventNameTextBox.getValue();
    }

    @Override
    public String description() {
        return this.calendarEventDescriptionTextArea.getValue();
    }

    @Override
    public Date date() {
        return this.calendarEventDatePicker.getValue();
    }

    @Override
    public int duration() {
        return this.calendarEventDuration.getValue();
    }

}