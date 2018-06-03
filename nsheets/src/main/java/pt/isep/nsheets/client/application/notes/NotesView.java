package pt.isep.nsheets.client.application.notes;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.emptystate.MaterialEmptyState;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.NotesService;
import pt.isep.nsheets.shared.services.NotesServiceAsync;

class NotesView extends ViewImpl implements NotesPresenter.MyView {

    interface Binder extends UiBinder<Widget, NotesView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialEmptyState emptyState;
    
    @UiField
    MaterialButton openModalBtn, saveBtn, closeModalBtn;

    @UiField
    MaterialModal modal;

    @UiField
    MaterialTextBox titleNote;

    @UiField
    MaterialTextArea textNote;
    
    @Inject
    NotesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addClickHandlerModalOpen(ClickHandler ch) {
        
        openModalBtn.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerSaveNote(ClickHandler ch) {

        saveBtn.addClickHandler(ch);
    }

    @Override
    public void openModal() {
        
        this.modal.open();
        
        emptyState.setVisible(false);
    }

    @Override
    public void setContents(ArrayList<NoteDTO> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (NoteDTO note : contents) {
            MaterialCard card = createCard(note);

            if (colCount == 1) {
                row = new MaterialRow();
                htmlPanel.add(row);
                ++colCount;
                if (colCount >= 4) {
                    colCount = 1;
                }
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("l4");
            row.add(col);

            col.add(card);
        }

    }

    @Override
    public String titleNote() {

        return this.titleNote.getValue();
    }

    @Override
    public String textNote() {

        return this.textNote.getValue();
    }

    @Override
    public void closeModal() {

        this.modal.close();
    }

    private MaterialCard createCard(NoteDTO note) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText(note.getTitleNote());

        MaterialLabel label = new MaterialLabel();
        label.setText(note.getTextNote());

        MaterialCardAction cardAction = new MaterialCardAction();
        cardAction.setTextAlign(TextAlign.RIGHT);

        MaterialButton editBtn = new MaterialButton("Edit", IconType.EDIT, ButtonType.FLOATING);
        editBtn.setWaves(WavesType.LIGHT);
        editBtn.setBackgroundColor(Color.GREY);
        editBtn.setTooltip("Edit");
//        editButton.addStyleName("margin-right: 10px");

        MaterialButton removeBtn = new MaterialButton("Remove", IconType.REMOVE, ButtonType.FLOATING);
        removeBtn.setWaves(WavesType.LIGHT);
        removeBtn.setBackgroundColor(Color.GREY);
        removeBtn.setTooltip("Remove");
//        removeButton.addStyleName("margin-right: 10px");

        cardContent.add(cardTitle);
        cardContent.add(label);

        cardAction.add(editBtn);
        cardAction.add(removeBtn);

        card.add(cardContent);
        card.add(cardAction);

        card.addClickHandler(e -> {
            NotesServiceAsync notesSvc = GWT.create(NotesService.class);

            // Set up the callback object.
            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(NoteDTO result) {
                    MaterialToast.fireToast("Note saved!");
                }
            };

            //notesSvc.findByName(name);
        });

        return card;
    }

}
