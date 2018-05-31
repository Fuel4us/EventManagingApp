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

//    private MyView view;

    interface MyView extends View {

//        void setContents(ArrayList<NoteDTO> contents);
//
//        void addClickHandler(ClickHandler ch);
    }

    @NameToken(NameTokens.notes)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<NotesPresenter> {
    }

    @Inject
    NotesPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

//        this.view = view;
//
//        this.view.addClickHandler(event -> {
//
//            NotesServiceAsync notesSvc = GWT.create(NotesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                public void onSuccess(NoteDTO result) {
//                    MaterialToast.fireToast("New Note Created...", "rounded");
//
//                    refreshView();
//                }
//            };
//
//            NoteDTO notesDto = new NoteDTO("TitleNote 123",
//                    "New NoteText 123 Text");
//            notesSvc.addNote(notesDto, callback);
//        });
    }

//    private void refreshView() {
//        NotesServiceAsync notesSvc = GWT.create(NotesService.class);
//
//        // Set up the callback object.
//        AsyncCallback<ArrayList<NoteDTO>> callback = new AsyncCallback<ArrayList<NoteDTO>>() {
//            public void onFailure(Throwable caught) {
//                // TODO: Do something with errors.
//            }
//
//            public void onSuccess(ArrayList<NoteDTO> result) {
//                view.setContents(result);
//            }
//        };
//
//        notesSvc.getNotes(callback);
//    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Notes", "Make your notes", "", "", this);

//        refreshView();
    }

}
