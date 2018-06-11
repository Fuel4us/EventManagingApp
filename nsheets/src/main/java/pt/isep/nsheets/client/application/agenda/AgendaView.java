package pt.isep.nsheets.client.application.agenda;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialTextBox;
import javax.inject.Inject;

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
    MaterialComboBox comboCreate;
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
    MaterialWindow editWindow;

    /**
     * Form view constructor.
     *
     * @param uiBinder
     */
    @Inject
    AgendaView(AgendaView.Binder uiBinder) {

        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnEdit")
    void openWindow(ClickEvent e) {
        editWindow.open();
    }

    @UiHandler("btnOpenCreateWindow")
    void openCreateWindow(ClickEvent e) {
        modal.open();
    }

    @UiHandler("cancelButton")
    void cancelCreateWindow(ClickEvent e) {
        modal.close();
    }

}
