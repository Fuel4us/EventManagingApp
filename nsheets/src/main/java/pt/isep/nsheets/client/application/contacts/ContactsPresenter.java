package pt.isep.nsheets.client.application.contacts;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;

import gwt.material.design.client.ui.MaterialToast;

import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.ContactsService;
import pt.isep.nsheets.shared.services.ContactsServiceAsync;

public class ContactsPresenter extends Presenter<ContactsPresenter.MyView, ContactsPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void addClickHandlerOpenModal(ClickHandler ch);

        void buttonClickHandlerSaveContact(ClickHandler ch);
        
//        void buttonClickHandlerCheckEditNote(ClickHandler ch);
        
//        void buttonClickHandlerEditNote(ClickHandler ch);
        
//        void buttonClickHandlerRemoveNote(ClickHandler ch);
        
        void openModalToAddContact();

        void setContents(ArrayList<ContactDTO> contents);

        String contactName();

        String contactEmail();

        void closeModalToAddContact();
    }

    @NameToken(NameTokens.contacts)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ContactsPresenter> {
    }

    @Inject
    ContactsPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandlerOpenModal(event -> {

            this.view.openModalToAddContact();
        });

        this.view.buttonClickHandlerSaveContact(event -> {
            ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

            // Set up the callback object.
            AsyncCallback<ContactDTO> callback = new AsyncCallback<ContactDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(ContactDTO result) {
                    MaterialToast.fireToast("Contact Created");

                    refreshView();
                }
            };

            ContactDTO contactDto = new ContactDTO(this.view.contactName(), this.view.contactEmail());
            contactsSvc.addContact(contactDto, callback);

            this.view.closeModalToAddContact();
        });
        
//        this.view.buttonClickHandlerCheckEditNote(event -> {
//            NotesServiceAsync notesSvc = GWT.create(NotesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(NoteDTO result) {
//                    MaterialToast.fireToast("Note Edited - Check");
//
//                    refreshView();
//                }
//            };
//
//            NoteDTO notesDto = new NoteDTO(this.view.titleNote(), this.view.textNote());
//            notesSvc.addNote(notesDto, callback);
//
//        });
//        
//        this.view.buttonClickHandlerEditNote(event -> {
//            NotesServiceAsync notesSvc = GWT.create(NotesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(NoteDTO result) {
//                    MaterialToast.fireToast("Note Edited");
//
//                    refreshView();
//                }
//            };
//
////            NoteDTO notesDto = new NoteDTO(this.view.titleNote(), this.view.textNote());
////            notesSvc.addNote(notesDto, callback);
//
//        });
//        
//        this.view.buttonClickHandlerRemoveNote(event -> {
//            NotesServiceAsync notesSvc = GWT.create(NotesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(NoteDTO result) {
//                    MaterialToast.fireToast("Note Removed");
//
//                    refreshView();
//                }
//            };
//
//            NoteDTO notesDto = new NoteDTO(this.view.titleNote(), this.view.textNote());
//            notesSvc.addNote(notesDto, callback);
//
//        });

    }

    private void refreshView() {
        ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<ContactDTO>> callback = new AsyncCallback<ArrayList<ContactDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<ContactDTO> result) {
                view.setContents(result);
            }
        };

        contactsSvc.getContacts(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Contacts", "Manage your contacts", "", "", this);

        refreshView();
    }

}
