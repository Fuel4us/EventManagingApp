package pt.isep.nsheets.client.application.notes;

import java.util.ArrayList;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

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
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import pt.isep.nsheets.shared.services.NoteDTO;

class NotesView extends ViewImpl implements NotesPresenter.MyView {

    interface Binder extends UiBinder<Widget, NotesView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialEmptyState emptyState;

    @UiField
    MaterialCollection notesCollection;

    @UiField
    MaterialButton openModalBtn, saveBtn;

    @UiField
    MaterialModal modal;

    @UiField
    MaterialTextBox titleNote;

    @UiField
    MaterialTextArea textNote;

    MaterialButton checkBtn, editBtn, removeBtn;

    @Inject
    NotesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addClickHandlerOpenModal(ClickHandler ch) {

        openModalBtn.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerSaveNote(ClickHandler ch) {

        saveBtn.addClickHandler(ch);
    }

//    @Override
//    public void buttonClickHandlerCheckEditNote(ClickHandler ch) {
//
//        checkBtn.addClickHandler(ch);
//
//    }
//
//    @Override
//    public void buttonClickHandlerEditNote(ClickHandler ch) {
//
//        editBtn.addClickHandler(ch);
//    }
//
//    @Override
//    public void buttonClickHandlerRemoveNote(ClickHandler ch) {
//
//        removeBtn.addClickHandler(ch);
//    }

    @Override
    public void openModal() {

        this.modal.open();

    }

    @Override
    public void setContents(ArrayList<NoteDTO> contents) {

        notesCollection.clear();

        if (!contents.isEmpty()) {
            emptyState.setVisible(false);
        }
        int colCount = 1;

        MaterialRow row = null;

        for (NoteDTO note : contents) {
            MaterialCard card = createCard(note);

            if (colCount == 1) {
                row = new MaterialRow();
                notesCollection.add(row);
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
        cardContent.setTextColor(Color.WHITE);  //FIX-ME: não altera a cor?

        MaterialTextBox cardTitle = new MaterialTextBox();
        cardTitle.setFontSize("1.4em");
        cardTitle.setText(note.getTitleNote());
        cardTitle.setReadOnly(true);

        MaterialTextArea cardTextArea = new MaterialTextArea();
        cardTextArea.setText(note.getTextNote());
        cardTextArea.setReadOnly(true);

        MaterialTextBox cardHistory = new MaterialTextBox();
        cardHistory.setText(note.getDateNote().toString());
        cardHistory.setReadOnly(true);

        MaterialCardAction cardAction = new MaterialCardAction();
        cardAction.setTextAlign(TextAlign.RIGHT);

        checkBtn = new MaterialButton("Edit", IconType.CHECK, ButtonType.FLOATING);
        checkBtn.setWaves(WavesType.LIGHT);
        checkBtn.setBackgroundColor(Color.GREY);
        checkBtn.setTooltip("Check it to save the change");
        checkBtn.addStyleName("margin-right: 10px");
        checkBtn.setVisible(false);

        checkBtn.addClickHandler(e -> {
            MaterialToast.fireToast("The check button was clicked!");
            cardTitle.setReadOnly(true);
            cardTextArea.setReadOnly(true);
            checkBtn.setVisible(false);
            cardHistory.setText(note.getDateNote().toString());
        });

        editBtn = new MaterialButton("Edit", IconType.EDIT, ButtonType.FLOATING);
        editBtn.setWaves(WavesType.LIGHT);
        editBtn.setBackgroundColor(Color.GREY);
        editBtn.setTooltip("Edit");
        editBtn.addStyleName("margin-right: 10px");

        editBtn.addClickHandler(e -> {
            MaterialToast.fireToast("The edit button was clicked!");
            cardTitle.setReadOnly(false);
            cardTextArea.setReadOnly(false);
            checkBtn.setVisible(true);
        });

        removeBtn = new MaterialButton("Remove", IconType.REMOVE, ButtonType.FLOATING);
        removeBtn.setWaves(WavesType.LIGHT);
        removeBtn.setBackgroundColor(Color.GREY);
        removeBtn.setTooltip("Remove");
        removeBtn.addStyleName("margin-right: 10px");

        removeBtn.addClickHandler(e -> {
            MaterialToast.fireToast("The remove button was clicked!");
            card.setVisible(false);
        });

        cardContent.add(cardTitle);
        cardContent.add(cardTextArea);
        cardContent.add(cardHistory);

        cardAction.add(checkBtn);
        cardAction.add(editBtn);
        cardAction.add(removeBtn);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

}
