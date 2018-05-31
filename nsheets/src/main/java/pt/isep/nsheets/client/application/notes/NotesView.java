package pt.isep.nsheets.client.application.notes;

import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.ButtonType;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
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
import gwt.material.design.client.ui.MaterialRow;

import pt.isep.nsheets.shared.services.NoteDTO;

class NotesView extends ViewImpl implements NotesPresenter.MyView {

    interface Binder extends UiBinder<Widget, NotesView> {
    }

//    @UiField
//    HTMLPanel htmlPanel;
//
//    @UiField
//    MaterialButton newNoteButton;

    @Inject
    NotesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

//    private MaterialCard createCard(NoteDTO note) {
//        MaterialCard card = new MaterialCard();
//        card.setBackgroundColor(Color.BLUE_DARKEN_1);
//
//        MaterialCardContent cardContent = new MaterialCardContent();
//        cardContent.setTextColor(Color.WHITE);
//
//        MaterialCardTitle cardTitle = new MaterialCardTitle();
//        cardTitle.setText(note.getTitleNote());
//        cardTitle.setIconType(IconType.INSERT_DRIVE_FILE);
//        cardTitle.setIconPosition(IconPosition.RIGHT);
//
//        MaterialLabel label = new MaterialLabel();
//        label.setText(note.getTextNote());
//        
//        MaterialCardAction cardAction = new MaterialCardAction();
//        cardAction.setTextAlign(TextAlign.RIGHT);
//        
//        MaterialButton editButton = new MaterialButton(ButtonType.FLOATING);
//        editButton.setWaves(WavesType.LIGHT);
//        editButton.setIconType(IconType.EDIT);
//        editButton.setBackgroundColor(Color.GREY);
//        editButton.setTooltip("Edit");
//        editButton.addStyleName("margin-right: 10px");
//        
//        MaterialButton removeButton = new MaterialButton(ButtonType.FLOATING);
//        removeButton.setWaves(WavesType.LIGHT);
//        removeButton.setIconType(IconType.REMOVE);
//        removeButton.setBackgroundColor(Color.GREY);
//        removeButton.setTooltip("Remove");
//        removeButton.addStyleName("margin-right: 10px");
//        
//        cardContent.add(cardTitle);
//        cardContent.add(label);
//        
//        cardAction.add(editButton);
//        cardAction.add(removeButton);
//        
//        card.add(cardContent);
//        card.add(cardAction);
//
//        return card;
//    }
//
//    @Override
//    public void setContents(ArrayList<NoteDTO> contents) {
//        int colCount = 1;
//
//        MaterialRow row = null;
//
//        htmlPanel.clear();
//
//        for (NoteDTO note : contents) {
//            MaterialCard card = createCard(note);
//
//            if (colCount == 1) {
//                row = new MaterialRow();
//                htmlPanel.add(row);
//                ++colCount;
//                if (colCount >= 4) {
//                    colCount = 1;
//                }
//            }
//
//            MaterialColumn col = new MaterialColumn();
//            col.setGrid("l4");
//            row.add(col);
//
//            col.add(card);
//        }
//
//    }
//
//    @Override
//    public void addClickHandler(ClickHandler ch) {
//        // TODO Auto-generated method stub
//
//        newNoteButton.addClickHandler(ch);
//    }

}
