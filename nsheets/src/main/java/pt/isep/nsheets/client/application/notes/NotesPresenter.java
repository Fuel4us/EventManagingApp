package pt.isep.nsheets.client.application.notes;

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
import pt.isep.nsheets.shared.services.NotesServiceAsync;
import pt.isep.nsheets.shared.services.NotesService;
import pt.isep.nsheets.shared.services.NoteDTO;

public class NotesPresenter extends Presenter<NotesPresenter.MyView, NotesPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void addClickHandlerOpenModal(ClickHandler ch);

        void buttonClickHandlerSaveNote(ClickHandler ch);
        
//        void buttonClickHandlerCheckEditNote(ClickHandler ch);
        
//        void buttonClickHandlerEditNote(ClickHandler ch);
        
//        void buttonClickHandlerRemoveNote(ClickHandler ch);
        
        void openModalToAddNote();

        void setContents(ArrayList<NoteDTO> contents);

        String titleNote();

        String textNote();

        void closeModalToAddNote();
    }

    @NameToken(NameTokens.notes)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<NotesPresenter> {
    }

    @Inject
    NotesPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.view = view;

        this.view.addClickHandlerOpenModal(event -> {

            this.view.openModalToAddNote();
        });

        this.view.buttonClickHandlerSaveNote(event -> {
            NotesServiceAsync notesSvc = GWT.create(NotesService.class);

            // Set up the callback object.
            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(NoteDTO result) {
                    MaterialToast.fireToast("New Note Created");

                    refreshView();
                }
            };

            NoteDTO notesDto = new NoteDTO(this.view.titleNote(), this.view.textNote());
            notesSvc.addNote(notesDto, callback);

            this.view.closeModalToAddNote();
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
        NotesServiceAsync notesSvc = GWT.create(NotesService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<NoteDTO>> callback = new AsyncCallback<ArrayList<NoteDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<NoteDTO> result) {
                view.setContents(result);
            }
        };

        notesSvc.getNotes(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Notes", "Make your notes", "", "", this);

        refreshView();
    }

}
