package pt.isep.nsheets.client.application.notes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import java.util.ArrayList;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
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
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.List;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;

import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.NotesService;
import pt.isep.nsheets.shared.services.NotesServiceAsync;

class NotesView extends ViewImpl implements NotesPresenter.MyView {

    interface Binder extends UiBinder<Widget, NotesView> {
    }

    //List<MaterialCard> lstCardNotes = new ArrayList<>();
    NoteDTO note;

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialEmptyState emptyState;

    @UiField
    MaterialCollection notesCollection;

    @UiField
    MaterialButton openModalBtn, saveBtn;

    @UiField
    MaterialModal modalAddNote;

    @UiField
    MaterialTextBox titleNote;

    @UiField
    MaterialTextArea textNote;

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
    public void openModalToAddNote() {

        this.modalAddNote.open();

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
    public void closeModalToAddNote() {

        this.modalAddNote.close();
    }

    private MaterialCard createCard(NoteDTO noteDTO) {
        note = noteDTO;

        //Buttons
        MaterialButton checkBtn, editBtn, removeBtn, createListNote, createNote;
        checkBtn = new MaterialButton("Edit", IconType.CHECK, ButtonType.FLOATING);
        editBtn = new MaterialButton("Edit", IconType.EDIT, ButtonType.FLOATING);
        createListNote = new MaterialButton("Create ListNotes", IconType.EDIT, ButtonType.FLOATING);
        createNote = new MaterialButton("Create Note", IconType.EDIT, ButtonType.FLOATING);
        removeBtn = new MaterialButton("Remove", IconType.REMOVE, ButtonType.FLOATING);

        //Matrial Card (Basically the note)
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialTextBox cardTitle = new MaterialTextBox();
        MaterialTextArea cardTextArea = new MaterialTextArea();
        MaterialTextBox cardHistory = new MaterialTextBox();
        MaterialCardAction cardAction = new MaterialCardAction();

        cardContent.add(cardTitle);
        cardContent.add(cardTextArea);
        cardContent.add(cardHistory);

        cardAction.add(checkBtn);
        cardAction.add(editBtn);
        cardAction.add(removeBtn);
        cardAction.add(createListNote);
        cardAction.add(createNote);

        card.add(cardContent);
        card.add(cardAction);

        cardTitle.setFontSize("1.4em");
        cardTitle.setText(note.getTitleNote());
        cardTitle.setReadOnly(true);

        cardTextArea.setText(note.getTextNote());
        cardTextArea.setReadOnly(true);

        cardHistory.setText(note.getDateNote().toString());
        cardHistory.setReadOnly(true);

        cardAction.setTextAlign(TextAlign.RIGHT);

        //Save button
        checkBtn.setWaves(WavesType.LIGHT);
        checkBtn.setBackgroundColor(Color.GREY);
        checkBtn.setTooltip("Check it to save the change");
        checkBtn.addStyleName("margin-right: 10px");
        checkBtn.setVisible(false);
        checkBtn.addClickHandler((event) -> {
//            Widget w = (Widget) event.getSource();
//            
//            for (MaterialCard mCard : lstCardNotes) {
//                for (Widget widget : mCard.getChildrenList()){
//                    if(widget.equals(w.getParent()))
//                        MaterialToast.fireToast("Encontrou widget igual");
//                    break;
//                }
//            }

            MaterialToast.fireToast("The check button was clicked!");
            cardTitle.setReadOnly(true);
            cardTextArea.setReadOnly(true);
            checkBtn.setVisible(false);
            cardHistory.setText(note.getDateNote().toString());

            //Save the changes in the DB
            NotesServiceAsync notesSvc = GWT.create(NotesService.class);

            // Set up the callback object.
            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(NoteDTO result) {
                    MaterialToast.fireToast("Note Saved");
                    note = result;
                }
            };

            NoteDTO nDTO = note.clone();
            nDTO.changeTitleNote(cardTitle.getText());
            nDTO.changeTextNote(cardTextArea.getText());
            notesSvc.saveNote(nDTO, nDTO.getID(), callback);
        });

        //Edit button
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

        //Create list notes button
        createListNote.setWaves(WavesType.LIGHT);
        createListNote.setBackgroundColor(Color.BLACK);
        createListNote.setTooltip("Create ListNote");
        createListNote.addStyleName("margin-right: 10px");
        createListNote.addClickHandler(e -> {
            MaterialToast.fireToast("The create ListNotes button was clicked!");
            //Change the note to ListNotes
            cardContent.clear();

            MaterialRow mContentRow = new MaterialRow();

            String lines[] = note.getTextNote().split("\\r?\\n");

            List<Boolean> activeCB = note.getActiveCheckBox();

            for (int i = 0; i < lines.length; i++) {
                MaterialRow mRow = new MaterialRow();

                MaterialCheckBox mCB = new MaterialCheckBox();
//                if (activeCB.get(i)) {
//                    mCB.setValue(Boolean.TRUE);
//                }
                
                int aux = i;
                
//                mCB.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
//                    @Override
//                    public void onValueChange(ValueChangeEvent<Boolean> event) {
//                        note.setCheckBoxValue(aux, event.getValue());
//                    }
//                });

                MaterialLabel mL = new MaterialLabel();
                mL.setText(lines[i]);

                mRow.add(mCB);
                mRow.add(mL);

                mContentRow.add(mRow);
            }

            //cardTextArea.setText(note.getTextNote());
            //cardTextArea.setReadOnly(true);
            cardContent.add(cardTitle);
            cardContent.add(mContentRow);
            cardContent.add(cardHistory);

            createNote.setVisible(true);
            createListNote.setVisible(false);
            //cardTitle.setReadOnly(false);
            //cardTextArea.setReadOnly(false);
            //checkBtn.setVisible(true);
        });

        //Create note button
        createNote.setVisible(false);
        createNote.setWaves(WavesType.LIGHT);
        createNote.setBackgroundColor(Color.BLACK);
        createNote.setTooltip("Create Note");
        createNote.addStyleName("margin-right: 10px");
        createNote.addClickHandler(e -> {
            cardContent.clear();

            cardTextArea.setText(note.getTextNote());
            cardTextArea.setReadOnly(true);

            cardContent.add(cardTitle);
            cardContent.add(cardTextArea);
            cardContent.add(cardHistory);

            createNote.setVisible(false);
            createListNote.setVisible(true);
        });

        //Remove Note button
        removeBtn.setWaves(WavesType.LIGHT);
        removeBtn.setBackgroundColor(Color.GREY);
        removeBtn.setTooltip("Remove");
        removeBtn.addStyleName("margin-right: 10px");
        removeBtn.addClickHandler(e -> {
            MaterialToast.fireToast("The remove button was clicked!");
            card.setVisible(false);

            //Remove the Note from the DB
            NotesServiceAsync notesSvc = GWT.create(NotesService.class);

            // Set up the callback object.
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Void result) {
                    MaterialToast.fireToast("Note Deleted");
                }
            };

            NoteDTO nDTO = note.clone();
            notesSvc.deleteNote(nDTO.getID(), callback);
        });

        //lstCardNotes.add(card);
        return card;
    }

}
