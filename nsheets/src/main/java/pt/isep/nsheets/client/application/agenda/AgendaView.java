package pt.isep.nsheets.client.application.agenda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.emptystate.MaterialEmptyState;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import pt.isep.nsheets.shared.services.AgendaDTO;
import pt.isep.nsheets.shared.services.CalendarEventDTO;
import pt.isep.nsheets.shared.services.CalendarEventService;
import pt.isep.nsheets.shared.services.CalendarEventServiceAsync;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaView extends ViewImpl implements AgendaPresenter.MyView {

    interface Binder extends UiBinder<Widget, AgendaView> {
    }

    @UiField
    MaterialComboBox comboAgendas;
    @UiField
    MaterialComboBox comboCreateCalendar;
    @UiField
    MaterialButton btnSelect;
    @UiField
    MaterialButton btnEdit;
    @UiField
    MaterialButton btnDelete;
    @UiField
    MaterialButton btnOpenCreateWindow;
    @UiField
    MaterialButton saveButton;
    @UiField
    MaterialButton cancelButton;
    @UiField
    MaterialTextBox nameAgenda;
    @UiField
    MaterialTextBox descriptionAgenda;
    @UiField
    MaterialModal modal;
    @UiField
    MaterialTitle updateTitle;

    @UiField
    MaterialEmptyState emptyState;

    MaterialCard card;

    @UiField
    MaterialPanel materialPlanEmptyState;

    /**
     * Form view constructor.
     *
     * @param uiBinder
     */
    @Inject
    AgendaView(AgendaView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    @UiHandler("btnEdit")
    void editBtn(ClickEvent e) {
    //With BUGS
        materialPlanEmptyState.clear();

        AgendaDTO agendaDTOSelect = (AgendaDTO) comboAgendas.getSingleValue();
        updateTitle.setTitle(agendaDTOSelect.getName());
        updateTitle.setDescription(agendaDTOSelect.getDescription());

        for (CalendarEventDTO calendarEventDTO : agendaDTOSelect.getListEvents()) {
            card = new MaterialCard();
            materialPlanEmptyState.add(card);

            MaterialCardContent content = new MaterialCardContent();
            card.add(content);

            MaterialCardTitle title = new MaterialCardTitle();
            title.setText(calendarEventDTO.getName());
            content.add(title);

            MaterialLabel descriptionLabel = new MaterialLabel();
            descriptionLabel.setText(calendarEventDTO.getDescription());
            content.add(descriptionLabel);

            DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
            DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm");

            MaterialLabel dateLabel = new MaterialLabel();
            dateLabel.setText(dateFormat.format(calendarEventDTO.getDate()));
            content.add(dateLabel);

            MaterialLabel timeLabel = new MaterialLabel();
            timeLabel.setText(timeFormat.format(calendarEventDTO.getTime()));
            content.add(timeLabel);

            MaterialLabel durationLabel = new MaterialLabel();
            durationLabel.setText(calendarEventDTO.getDuration().toString() + " minutes");
            content.add(durationLabel);

            MaterialButton deleteButton = deleteOption(true);
            content.add(deleteButton);
        }
    }

    @UiHandler("btnDelete")
    void deleteBtn(ClickEvent e) {
        //With BUGS
        updateTitle.setTitle("Agendas");
        updateTitle.setDescription("Description");

        materialPlanEmptyState.clear();
        comboAgendas.remove(comboAgendas.getSelectedIndex());

        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

//        comboAgendas.setEnabled(false);
    }

    @UiHandler("nameAgenda")
    void getName(KeyPressEvent e) {
        nameAgenda.validate();
    }

    @UiHandler("descriptionAgenda")
    void getDescription(KeyPressEvent e) {
        descriptionAgenda.validate();
    }

    @UiHandler("btnOpenCreateWindow")
    void openCreateWindow(ClickEvent e) {
        getCalendarsAvailables();
        modal.open();
    }

    @UiHandler("saveButton")
    void saveData(ClickEvent e) {
        closeModal();

        String name = nameAgenda.getText();
        String description = descriptionAgenda.getText();
        HashSet<CalendarEventDTO> list = new HashSet<>();

        for (Object selectedValue : comboCreateCalendar.getSelectedValues()) {
            list.add((CalendarEventDTO) selectedValue);
        }

        AgendaDTO agenda = new AgendaDTO(name, description, list);

//        AgendaServiceAsync service = GWT.create(AgendaService.class);
        MaterialToast.fireToast("Agenda created successfully!\n Name :" + name + ";\n Description :" + description + ";\n Número de Eventos Selecionados : " + list.size());
        comboAgendas.addItem(name, agenda);

//        service.createAgenda(calendarEvent, callback);
    }

    @UiHandler("btnSelect")
    void selectAgenda(ClickEvent e) {
        materialPlanEmptyState.clear();

        AgendaDTO agendaDTOSelect = (AgendaDTO) comboAgendas.getSingleValue();
        updateTitle.setTitle(agendaDTOSelect.getName());
        updateTitle.setDescription(agendaDTOSelect.getDescription());

        for (CalendarEventDTO calendarEventDTO : agendaDTOSelect.getListEvents()) {
            card = new MaterialCard();
            materialPlanEmptyState.add(card);

            MaterialCardContent content = new MaterialCardContent();
            card.add(content);

            MaterialCardTitle title = new MaterialCardTitle();
            title.setText(calendarEventDTO.getName());
            content.add(title);

            MaterialLabel descriptionLabel = new MaterialLabel();
            descriptionLabel.setText(calendarEventDTO.getDescription());
            content.add(descriptionLabel);

            DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
            DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm");

            MaterialLabel dateLabel = new MaterialLabel();
            dateLabel.setText(dateFormat.format(calendarEventDTO.getDate()));
            content.add(dateLabel);

            MaterialLabel timeLabel = new MaterialLabel();
            timeLabel.setText(timeFormat.format(calendarEventDTO.getTime()));
            content.add(timeLabel);

            MaterialLabel durationLabel = new MaterialLabel();
            durationLabel.setText(calendarEventDTO.getDuration().toString() + " minutes");
            content.add(durationLabel);

            MaterialButton deleteButton = deleteOption(false);
            content.add(deleteButton);
        }

        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    @UiHandler("cancelButton")
    void cancelCreateWindow(ClickEvent e) {
        modal.close();
    }

    private void getCalendarsAvailables() {
        comboCreateCalendar.clear();
        CalendarEventServiceAsync calendarEventServiceAsync = GWT.create(CalendarEventService.class);

        AsyncCallback<List<CalendarEventDTO>> asyncCallback = new AsyncCallback<List<CalendarEventDTO>>() {
            @Override
            public void onSuccess(List<CalendarEventDTO> result) {
                setComboCreateCalendar(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Database connection failed", "rounded");
            }

            private void setComboCreateCalendar(List<CalendarEventDTO> result) {
                for (CalendarEventDTO calendarEventDTO : result) {
                    if (calendarEventDTO.getDate().after(new Date())) {
                        comboCreateCalendar.addItem(calendarEventDTO.getName(), calendarEventDTO);
                    }
                }
            }
        };

        calendarEventServiceAsync.getCalendarEvents(asyncCallback);
    }

    private MaterialButton deleteOption(boolean b) {
        MaterialButton deleteButton = new MaterialButton();
        deleteButton.setIconType(IconType.DELETE);
        deleteButton.setType(ButtonType.FLAT);
        deleteButton.setText("Delete");
        deleteButton.addClickHandler(event -> materialPlanEmptyState.remove(this.card));
        deleteButton.setEnabled(b);
        return deleteButton;
    }

    public void closeModal() {
        this.modal.close();
    }
}
