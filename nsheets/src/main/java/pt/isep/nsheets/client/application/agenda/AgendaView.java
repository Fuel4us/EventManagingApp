package pt.isep.nsheets.client.application.agenda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
import gwt.material.design.client.constants.DatePickerContainer;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;

import pt.isep.nsheets.shared.services.AgendaDTO;
import pt.isep.nsheets.shared.services.CalendarEventDTO;
import pt.isep.nsheets.shared.services.CalendarEventService;
import pt.isep.nsheets.shared.services.CalendarEventServiceAsync;

/**
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
    MaterialPanel oldMaterialPlanEmptyState;

    @UiField
    MaterialPanel newMaterialPlanEmptyState;

    @UiField
    MaterialCollapsibleHeader collapsHeader;
    @UiField
    MaterialCollapsibleBody collapsBody;
    @UiField
    MaterialDatePicker datePicker;
    @UiField
    MaterialSwitch themeSwitch;

    private AgendaDTO agendaDTOSelect;

    private final DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");

    private final DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm");

    private final int HOURS = 24;

    private final int DOUBLE_DIGIT = 10;

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

        newTheme();
    }

    private void newTheme() {
        datePicker();
        agendaCollapsible();
        newMaterialPlanEmptyState.setVisible(false);
    }

    private void datePicker() {
        datePicker.setPlaceholder("Date");
        datePicker.setDateMin(new Date());
        datePicker.setContainer(DatePickerContainer.BODY);
        datePicker.setDate(new Date());

        //sempre que se altera o valor do datePicker
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> event) {
                datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
                    @Override
                    public void onValueChange(ValueChangeEvent<Date> event) {
                        updateAgendaCollapsible();
                    }
                });
            }
        });

        //sempre que se fecha o datePicker (que é o mesmo que alterar)
        datePicker.addCloseHandler(new CloseHandler<MaterialDatePicker>() {
            @Override
            public void onClose(CloseEvent<MaterialDatePicker> event) {
                updateAgendaCollapsible();
            }
        });

        newMaterialPlanEmptyState.add(datePicker);
    }

    private void agendaCollapsible() {
        //preenchimento da tabela com as horas de um dia
        String name;

        for (int i = 0; i < HOURS; i++) {
            MaterialCollapsible collaps = new MaterialCollapsible();
            MaterialCollapsibleItem item = new MaterialCollapsibleItem();

            //para ficar "00, 01, 02, 03, ..."
            if (i < DOUBLE_DIGIT) {
                name = "0" + Integer.toString(i);

                item.add(new MaterialCollapsibleHeader(new MaterialLink(name)));

                //caso tenha alguma agenda selecionada
                if (agendaDTOSelect != null)

                    //envia o "nome" da hora (tipo 00, 13, 23)
                    item = addEvent(item, name);

            } else {
                name = Integer.toString(i);

                item.add(new MaterialCollapsibleHeader(new MaterialLink(name)));

                //caso tenha alguma agenda selecionada
                if (agendaDTOSelect != null)

                    //envia o "nome" da hora (tipo 00, 13, 23)
                    item = addEvent(item, name);
            }

            collaps.add(item);
            collapsBody.add(collaps);
        }
    }

    private MaterialCollapsibleItem addEvent(MaterialCollapsibleItem item, String name) {

        //saca todos os eventos
        for (CalendarEventDTO calendarEventDTO : agendaDTOSelect.getListEvents()) {

            //verifica se o evento é no dia especificado
            if (calendarEventDTO.getDate().equals(datePicker.getDate())) {

                //verifica se o evento ocorre à mesma altura que o "nome" dado da hora
                if ((timeFormat.format(calendarEventDTO.getTime()).split(":")[0]).equals(name)) {
                    MaterialCollapsibleBody body = new MaterialCollapsibleBody();

                    MaterialRow rowToAdd = new MaterialRow();

                    MaterialCollapsibleHeader eventName = new MaterialCollapsibleHeader(new MaterialLink(calendarEventDTO.getName()));
                    MaterialLabel eventDescription = new MaterialLabel(calendarEventDTO.getDescription());
                    MaterialLabel eventTime = new MaterialLabel(timeFormat.format(calendarEventDTO.getTime()));
                    MaterialLabel eventDuration = new MaterialLabel(Integer.toString(calendarEventDTO.getDuration()) + " minutes");

                    rowToAdd.add(eventName);
                    rowToAdd.add(eventDescription);
                    rowToAdd.add(eventTime);
                    rowToAdd.add(eventDuration);


                    body.add(rowToAdd);

                    //double click handler
                    body.addDoubleClickHandler(doubleClickEvent -> editFunction());

                    item.add(body);
                }
            }
        }
        return item;
    }

    private void updateAgendaCollapsible() {
        collapsHeader.setTitle(dateFormat.format(datePicker.getDate()));

        collapsBody.clear();

        agendaCollapsible();
    }

    @UiHandler("btnEdit")
    void editBtn(ClickEvent e) {
        editFunction();
    }

    private void editFunction() {
        //With BUGS
        oldMaterialPlanEmptyState.clear();
        //newMaterialPlanEmptyState.clear();

        //falta editar name e description
        agendaDTOSelect = (AgendaDTO) comboAgendas.getSingleValue();
        updateTitle.setTitle(agendaDTOSelect.getName());
        updateTitle.setDescription(agendaDTOSelect.getDescription());

        MaterialToast.fireToast("Edit WITH BUGS!!");
        createCards(true);
    }

    @UiHandler("btnDelete")
    void deleteBtn(ClickEvent e) {
        //With BUGS
        updateTitle.setTitle("Agendas");
        updateTitle.setDescription("Description");

        oldMaterialPlanEmptyState.clear();
        //newMaterialPlanEmptyState.clear();

        comboAgendas.remove(comboAgendas.getSelectedIndex());

        MaterialToast.fireToast("Delet With BUGS!!");
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
        oldMaterialPlanEmptyState.clear();
        //newMaterialPlanEmptyState.clear();

        agendaDTOSelect = (AgendaDTO) comboAgendas.getSingleValue();
        updateTitle.setTitle(agendaDTOSelect.getName());
        updateTitle.setDescription(agendaDTOSelect.getDescription());

        createCards(false);

        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }

    @UiHandler("cancelButton")
    void cancelCreateWindow(ClickEvent e) {
        modal.close();
    }

    @UiHandler("themeSwitch")
    void onValueChange(ValueChangeEvent<Boolean> e) {
        String output;
        if (e.getValue()) {
            oldMaterialPlanEmptyState.setVisible(false);
            newMaterialPlanEmptyState.setVisible(true);
            output = "New";
        } else {
            newMaterialPlanEmptyState.setVisible(false);
            oldMaterialPlanEmptyState.setVisible(true);
            output = "Old";
        }
        MaterialToast.fireToast(output + " theme!");
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

    private MaterialButton deleteOption(boolean b, MaterialCard card) {
        MaterialButton deleteButton = new MaterialButton();

        deleteButton.setIconType(IconType.DELETE);
        deleteButton.setType(ButtonType.FLAT);
        deleteButton.setText("Delete");
        deleteButton.addClickHandler((ClickEvent event) -> {
            oldMaterialPlanEmptyState.remove(card);
        });

        deleteButton.setEnabled(b);
        return deleteButton;
    }

    public void closeModal() {
        this.modal.close();
    }

    private void createCards(boolean bool) {
        for (CalendarEventDTO calendarEventDTO : agendaDTOSelect.getListEvents()) {
            card = new MaterialCard();
            oldMaterialPlanEmptyState.add(card);

            MaterialCardContent content = new MaterialCardContent();
            card.add(content);

            MaterialCardTitle title = new MaterialCardTitle();
            title.setText(calendarEventDTO.getName());
            content.add(title);

            MaterialLabel descriptionLabel = new MaterialLabel();
            descriptionLabel.setText(calendarEventDTO.getDescription());
            content.add(descriptionLabel);

            MaterialLabel dateLabel = new MaterialLabel();
            dateLabel.setText(dateFormat.format(calendarEventDTO.getDate()));
            content.add(dateLabel);

            MaterialLabel timeLabel = new MaterialLabel();
            timeLabel.setText(timeFormat.format(calendarEventDTO.getTime()));
            content.add(timeLabel);

            MaterialLabel durationLabel = new MaterialLabel();
            durationLabel.setText(calendarEventDTO.getDuration().toString() + " minutes");
            content.add(durationLabel);

            MaterialButton deleteButton = deleteOption(bool, card);
            content.add(deleteButton);
        }
    }
}
