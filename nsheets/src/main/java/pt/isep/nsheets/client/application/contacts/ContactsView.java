package pt.isep.nsheets.client.application.contacts;

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
import pt.isep.nsheets.shared.services.ContactDTO;

class ContactsView extends ViewImpl implements ContactsPresenter.MyView {

    interface Binder extends UiBinder<Widget, ContactsView> {
    }

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialEmptyState emptyState;

    @UiField
    MaterialCollection contactsCollection, invitesCollection;

    @UiField
    MaterialButton openModalBtn, saveBtn;

    @UiField
    MaterialModal modalAddContact;

    @UiField
    MaterialTextBox titleContact;

    MaterialButton selectBtn, editBtn, removeBtn;

    MaterialButton selectInvite;

    @UiField
    MaterialButton acceptInvite, denyInvite, blockInvites, unblockInvites;

    String selectedContact, selectedInvite;

    @Inject
    ContactsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addClickHandlerOpenModal(ClickHandler ch) {

        openModalBtn.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerSaveContact(ClickHandler ch) {

        saveBtn.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerAcceptInvite(ClickHandler ch) {

        acceptInvite.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerDenyInvite(ClickHandler ch) {

        denyInvite.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerBlockInvite(ClickHandler ch) {

        blockInvites.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerUnblockInvite(ClickHandler ch) {

        unblockInvites.addClickHandler(ch);
    }

    @Override
    public void openModalToAddContact() {

        this.modalAddContact.open();

    }

    @Override
    public void setContacts(ArrayList<ContactDTO> contents) {

        contactsCollection.clear();
        //invitesCollection.clear();

        if (!contents.isEmpty()) {
            emptyState.setVisible(false);
        }

        int colCount = 1;

        MaterialRow row = null;

        for (ContactDTO contact : contents) {
            MaterialCard card = createContactCard(contact);

            if (colCount == 1) {
                row = new MaterialRow();
                contactsCollection.add(row);
                //      invitesCollection.add(row);
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
    public void setInvites(ArrayList<ContactDTO> contents) {

        //contactsCollection.clear();
        invitesCollection.clear();

        if (!contents.isEmpty()) {
            emptyState.setVisible(false);
        }

        int colCount = 1;

        MaterialRow row = null;

        for (ContactDTO contact : contents) {
            MaterialCard card = createInviteCard(contact);

            if (colCount == 1) {
                row = new MaterialRow();
                //contactsCollection.add(row);
                invitesCollection.add(row);
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
    public String titleContact() {

        return this.titleContact.getValue();
    }

    @Override
    public String selectedContact() {

        return this.selectedContact;
    }

    @Override
    public String selectedInvite() {

        return this.selectedInvite;
    }

    @Override
    public void closeModalToAddContact() {

        this.modalAddContact.close();
    }

    private MaterialCard createContactCard(ContactDTO contact) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialTextBox cardTitle = new MaterialTextBox();
        cardTitle.setFontSize("1.4em");
        cardTitle.setText(contact.getContact());
        cardTitle.setReadOnly(true);

//        MaterialTextArea cardTextArea = new MaterialTextArea();
//        cardTextArea.setText(contact.getContactOwner());
//        cardTextArea.setReadOnly(true);
//        MaterialTextBox cardHistory = new MaterialTextBox();
//        cardHistory.setText(note.getDateContact().toString());
//        cardHistory.setReadOnly(true);
        MaterialCardAction cardAction = new MaterialCardAction();
        cardAction.setTextAlign(TextAlign.RIGHT);

        selectBtn = new MaterialButton("Select Contact", IconType.MOUSE, ButtonType.FLOATING);
        selectBtn.setWaves(WavesType.LIGHT);
        selectBtn.setBackgroundColor(Color.GREY);
        selectBtn.setTooltip("Select Contact");
        selectBtn.addStyleName("margin-right: 10px");
        selectBtn.setVisible(true);

        selectBtn.addClickHandler(e -> {
            MaterialToast.fireToast("Contact " + contact.getContact() + " selected!");
            selectedContact = contact.getContact();
//            cardHistory.setText(note.getDateNote().toString());
        });

//        editBtn = new MaterialButton("Edit", IconType.EDIT, ButtonType.FLOATING);
//        editBtn.setWaves(WavesType.LIGHT);
//        editBtn.setBackgroundColor(Color.GREY);
//        editBtn.setTooltip("Edit");
//        editBtn.addStyleName("margin-right: 10px");
//
//        editBtn.addClickHandler(e -> {
//            MaterialToast.fireToast("The edit button was clicked!");
//            cardTitle.setReadOnly(false);
//            cardTextArea.setReadOnly(false);
//            selectBtn.setVisible(true);
//        });
        removeBtn = new MaterialButton("Remove", IconType.REMOVE, ButtonType.FLOATING);
        removeBtn.setWaves(WavesType.LIGHT);
        removeBtn.setBackgroundColor(Color.GREY);
        removeBtn.setTooltip("Remove");
        removeBtn.addStyleName("margin-right: 10px");

        removeBtn.addClickHandler(e -> {
            MaterialToast.fireToast("Contact Removed!");
            card.setVisible(false);
        });

        cardContent.add(cardTitle);
//        cardContent.add(cardTextArea);
//        cardContent.add(cardHistory);

        cardAction.add(selectBtn);
        //cardAction.add(editBtn);
        cardAction.add(removeBtn);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

    private MaterialCard createInviteCard(ContactDTO contact) {
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.BLUE_DARKEN_1);

        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialTextBox cardTitle = new MaterialTextBox();
        cardTitle.setFontSize("1.4em");
        cardTitle.setText(contact.getContact());
        cardTitle.setReadOnly(true);

        MaterialTextArea cardTextArea = new MaterialTextArea();
        cardTextArea.setText(contact.getContactOwner());
        cardTextArea.setReadOnly(true);

//        MaterialTextBox cardHistory = new MaterialTextBox();
//        cardHistory.setText(note.getDateContact().toString());
//        cardHistory.setReadOnly(true);
        MaterialCardAction cardAction = new MaterialCardAction();
        cardAction.setTextAlign(TextAlign.RIGHT);

        selectInvite = new MaterialButton("Select Invite", IconType.MOUSE, ButtonType.RAISED);
        selectInvite.setWaves(WavesType.LIGHT);
        selectInvite.setBackgroundColor(Color.GREY);
        selectInvite.setTooltip("Select Invite");
        selectInvite.addStyleName("margin-right: 10px");
        selectInvite.setVisible(true);

        selectInvite.addClickHandler(e -> {
            selectedInvite = contact.getContact();
            MaterialToast.fireToast("Invite " + contact.getContact() + " selected!");
            this.selectedInvite = contact.getContact();
//            cardHistory.setText(note.getDateNote().toString());
        });

        acceptInvite = new MaterialButton("Accept Invite", IconType.CHECK, ButtonType.RAISED);
        acceptInvite.setWaves(WavesType.DEFAULT);
        acceptInvite.setBackgroundColor(Color.GREY);
        acceptInvite.setTooltip("Accept Invite");
        acceptInvite.addStyleName("margin-right: 10px");
        acceptInvite.setVisible(false);

        acceptInvite.addClickHandler(e -> {
            card.setVisible(false);
        });
        denyInvite = new MaterialButton("Deny Invite", IconType.REMOVE, ButtonType.RAISED);
        denyInvite.setWaves(WavesType.LIGHT);
        denyInvite.setBackgroundColor(Color.GREY);
        denyInvite.setTooltip("Deny Invite");
        denyInvite.addStyleName("margin-right: 10px");
        denyInvite.setVisible(false);

//        three.addClickHandler(e -> {
//            //
//            MaterialToast.fireToast("Contact " + contact.getContact() + " denied!");
////            cardHistory.setText(note.getDateNote().toString());
//        });
        blockInvites = new MaterialButton("Block Invites from User", IconType.BLOCK, ButtonType.RAISED);
        blockInvites.setWaves(WavesType.LIGHT);
        blockInvites.setBackgroundColor(Color.GREY);
        blockInvites.setTooltip("Block Invites from User");
        blockInvites.addStyleName("margin-right: 10px");
        blockInvites.setVisible(false);

//        four.addClickHandler(e -> {
//            //
//            MaterialToast.fireToast("User " + contact.getContact() + " blocked!");
////            cardHistory.setText(note.getDateNote().toString());
//        });
        unblockInvites = new MaterialButton("Unblock Invites from User", IconType.UNDO, ButtonType.RAISED);
        unblockInvites.setWaves(WavesType.LIGHT);
        unblockInvites.setBackgroundColor(Color.GREY);
        unblockInvites.setTooltip("Unlock Invites from User");
        unblockInvites.addStyleName("margin-right: 10px");
        unblockInvites.setVisible(false);

//        five.addClickHandler(e -> {
//            //
//            MaterialToast.fireToast("User " + contact.getContact() + " unblocked!");
////            cardHistory.setText(note.getDateNote().toString());
//        });
        cardContent.add(cardTitle);
        //cardContent.add(cardTextArea);
//        cardContent.add(cardHistory);

        cardAction.add(selectInvite);
        cardAction.add(acceptInvite);
        cardAction.add(denyInvite);
        cardAction.add(blockInvites);
        cardAction.add(unblockInvites);
        //cardAction.add(editBtn);
        //cardAction.add(removeBtn);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

}
