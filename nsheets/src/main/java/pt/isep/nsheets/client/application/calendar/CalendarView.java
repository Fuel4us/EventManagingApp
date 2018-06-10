package pt.isep.nsheets.client.application.calendar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
    MaterialPanel materialPlanEmptyState;

    @UiField
    MaterialEmptyState emptyState;

    @UiField
    MaterialButton createButton;

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

        createButton.addClickHandler(event -> createModal());
    }


    public void createEvent() {
        closeModal();

        CalendarEventDTO calendarEvent = new CalendarEventDTO(title(), description(), date(), time(), duration());

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            public void onSuccess(Void aVoid) {
                MaterialToast.fireToast("Event created successfully!", "rounded");
                refreshView();
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("There was an error creating the event", "rounded");
            }
        };

        service.createCalendarEvent(calendarEvent, callback);
    }

    public void editEvent(CalendarEventDTO calendarEvent) {
        closeModal();

        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            public void onSuccess(Void aVoid) {
                MaterialToast.fireToast("Event edited successfully!", "rounded");
                refreshView();
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("There was an error editing the event", "rounded");
            }
        };

        service.editCalendarEvent(calendarEvent, callback);
    }

    public void deleteEvent(CalendarEventDTO calendarEvent) {
        CalendarEventServiceAsync service = GWT.create(CalendarEventService.class);

        AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            public void onSuccess(Void aVoid) {
                MaterialToast.fireToast("Event deleted successfully!", "rounded");
                refreshView();
            }

            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("There was an error deleting the event", "rounded");
            }
        };

        service.deleteCalendarEvent(calendarEvent, callback);
    }

    public void createModal() {
        modal = new MaterialModal();
        modal.setType(ModalType.FIXED_FOOTER);
        modal.setDismissible(false);
        materialPlanEmptyState.add(modal);

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

        openModal();
    }

    public void createEditModal(CalendarEventDTO calendarEvent) {
        modal = new MaterialModal();
        modal.setType(ModalType.FIXED_FOOTER);
        modal.setDismissible(false);
        materialPlanEmptyState.add(modal);

        MaterialModalContent content = new MaterialModalContent();
        modal.add(content);

        MaterialTitle title = new MaterialTitle();
        title.setTitle("Edit Event");
        content.add(title);

        calendarEventNameTextBox = new MaterialTextBox();
        calendarEventNameTextBox.setLabel("Name");
        calendarEventNameTextBox.setValue(calendarEvent.getName());
        content.add(calendarEventNameTextBox);

        calendarEventDescriptionTextArea = new MaterialTextArea();
        calendarEventDescriptionTextArea.setLabel("Description");
        calendarEventDescriptionTextArea.setValue(calendarEvent.getDescription());
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
        calendarEventDatePicker.setValue(calendarEvent.getDate());
        aColumn.add(calendarEventDatePicker);

        calendarEventTimePicker = new MaterialTimePicker();
        calendarEventTimePicker.setPlaceholder("Time");
        calendarEventTimePicker.setHour24(true);
        calendarEventTimePicker.setValue(calendarEvent.getTime());
        anotherColumn.add(calendarEventTimePicker);

        MaterialLabel durationLabel = new MaterialLabel();
        durationLabel.setText("Duration in minutes");
        content.add(durationLabel);

        calendarEventDuration = new MaterialRange();
        calendarEventDuration.setMin(1);
        calendarEventDuration.setMax(60);
        calendarEventDuration.setValue(15);
        calendarEventDuration.setValue(calendarEvent.getDuration());
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
        confirmCalendarEventButton.addClickHandler(event -> editEvent(calendarEvent));
        modalFooter.add(confirmCalendarEventButton);

        openModal();
    }

    public MaterialCard createCard(CalendarEventDTO calendarEvent) {
        card = new MaterialCard();
        materialPlanEmptyState.add(card);

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
        dateLabel.setText(dateFormat.format(calendarEvent.getDate()));
        content.add(dateLabel);

        MaterialLabel timeLabel = new MaterialLabel();
        timeLabel.setText(timeFormat.format(calendarEvent.getTime()));
        content.add(timeLabel);

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

        //Edit and delete not implemented
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);

        return card;
    }

    @Override
    public void setContents(List<CalendarEventDTO> contents) {
        MaterialRow row = null;
        int colCount = 1;

        if (!contents.isEmpty()) {
            materialPlanEmptyState.clear();
        }

        for (CalendarEventDTO calendarEventDTO : contents) {
            MaterialCard card = createCard(calendarEventDTO);

            if (colCount == 1) {
                row = new MaterialRow();
                materialPlanEmptyState.add(row);
                ++colCount;
                if (colCount >= 4) colCount = 1;
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("s4");
            row.add(col);

            col.add(card);
        }
    }

    private void refreshView() {
        CalendarEventServiceAsync calendarEventServiceAsync = GWT.create(CalendarEventService.class);

        AsyncCallback<List<CalendarEventDTO>> asyncCallback = new AsyncCallback<List<CalendarEventDTO>>() {
            @Override
            public void onSuccess(List<CalendarEventDTO> result) {
                setContents(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Database connection failed", "rounded");
            }
        };

        calendarEventServiceAsync.getCalendarEvents(asyncCallback);
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
    public Date time() {
        return this.calendarEventTimePicker.getValue();
    }

    @Override
    public int duration() {
        return this.calendarEventDuration.getValue();
    }
}