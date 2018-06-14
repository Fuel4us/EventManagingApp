package pt.isep.nsheets.client.application.contacts;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
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
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.shared.services.ContactDTO;
import pt.isep.nsheets.shared.services.ContactsService;
import pt.isep.nsheets.shared.services.ContactsServiceAsync;

public class ContactsPresenter extends Presenter<ContactsPresenter.MyView, ContactsPresenter.MyProxy> {

    private MyView view;

    private String currentUserEmail;

    interface MyView extends View {

        void addClickHandlerOpenModal(ClickHandler ch);

        void buttonClickHandlerSaveContact(ClickHandler ch);

        void buttonClickHandlerAcceptInvite(ClickHandler ch);

        void buttonClickHandlerDenyInvite(ClickHandler ch);

        void buttonClickHandlerBlockInvite(ClickHandler ch);

        void buttonClickHandlerUnblockInvite(ClickHandler ch);

        void openModalToAddContact();

        void setContacts(ArrayList<ContactDTO> contents);

        void setInvites(ArrayList<ContactDTO> contents);

        String titleContact();

        String selectedContact();

        String selectedInvite();

        void closeModalToAddContact();
    }

    @NameToken(NameTokens.contacts)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ContactsPresenter> {
    }

    @Inject
    ContactsPresenter(EventBus eventBus, MyView view, MyProxy proxy, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        currentUserEmail = currentUser.getUser().getEmail();

        this.view = view;

        this.view.addClickHandlerOpenModal(event -> {

            this.view.openModalToAddContact();
        });

        this.view.buttonClickHandlerSaveContact(event -> {
            ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

            // Set up the callback object.
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Void result) {
                    MaterialToast.fireToast("Invite Sent!");

                    refreshViewContacts();
                    refreshViewInvites();
                }
            };

            contactsSvc.sendInvitation(this.view.titleContact(), currentUserEmail, callback);

            this.view.closeModalToAddContact();
        });

        this.view.buttonClickHandlerAcceptInvite(event -> {
            ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

            // Set up the callback object.
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Void result) {
                    MaterialToast.fireToast("Invite accepted!");

                    refreshViewContacts();
                    refreshViewInvites();
                }
            };

            contactsSvc.acceptInvitation(currentUserEmail, this.view.selectedInvite(), callback);

        });

        this.view.buttonClickHandlerDenyInvite(event -> {
            ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

            // Set up the callback object.
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Void result) {
                    MaterialToast.fireToast("Invite denied!");

                    refreshViewContacts();
                    refreshViewInvites();
                }
            };

            contactsSvc.denyInvitation(currentUserEmail, this.view.selectedInvite(), callback);
        });

        this.view.buttonClickHandlerBlockInvite(event -> {
            ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

            // Set up the callback object.
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Void result) {
                    MaterialToast.fireToast("Invites from user blocked!");

                    refreshViewContacts();
                    refreshViewInvites();
                }
            };

            contactsSvc.blockUser(currentUserEmail, this.view.selectedInvite(), callback);
        });

        this.view.buttonClickHandlerUnblockInvite(event -> {
            ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

            // Set up the callback object.
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Void result) {
                    MaterialToast.fireToast("Invites from user unblocked!");

                    refreshViewContacts();
                    refreshViewInvites();
                }
            };

            contactsSvc.unblockUser(currentUserEmail, this.view.selectedInvite(), callback);
        });

    }

    private void refreshViewContacts() {
        ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<ContactDTO>> callback = new AsyncCallback<ArrayList<ContactDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<ContactDTO> result) {
                view.setContacts(result);

            }
        };

        //receção
        contactsSvc.allAvailableContacts(currentUserEmail, callback);
    }

    private void refreshViewInvites() {
        ContactsServiceAsync contactsSvc = GWT.create(ContactsService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<ContactDTO>> callback = new AsyncCallback<ArrayList<ContactDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<ContactDTO> result) {
                view.setInvites(result);
            }
        };

        //receção
        contactsSvc.allInvitations(currentUserEmail, callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Contacts", "Make your Contacts", "", "", this);

        timer();
    }

    private void timer() {
        // Create a new timer
        Timer t = new Timer() {
            @Override
            public void run() {
                refreshViewContacts();
                refreshViewInvites();
            }
        };

        // Schedule the timer to run once in 1 second.
        t.scheduleRepeating(1000);
    }
}
