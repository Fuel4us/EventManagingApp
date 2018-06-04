package pt.isep.nsheets.client.application.chat;

import com.google.gwt.core.client.GWT;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import com.gwtplatform.mvp.client.annotations.NameToken;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import java.util.Date;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.security.CurrentUser;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.MessagesService;
import pt.isep.nsheets.shared.services.MessagesServiceAsync;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class ChatPresenter extends Presenter<ChatPresenter.MyView, ChatPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void setContents(ArrayList<MessagesDTO> contents,String currentNickName);

        void buttonClickHandler(ClickHandler ch);

        String text();
    }

    @NameToken(NameTokens.chat)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ChatPresenter> {
    }

    private CurrentUser user;

    @Inject
    ChatPresenter(EventBus eventBus, MyView view, MyProxy proxy, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        this.user = currentUser;
        this.view = view;

        this.view.buttonClickHandler(e -> {
            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);

            // Set up the callback object.
            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(MessagesDTO result) {
                    MaterialToast.fireToast("New Message Created", "rounded");

                    refreshMessages();
                }

            };
            MessagesDTO mDTO = new MessagesDTO(view.text(), new Date(), this.user.getUser().getNickname());
            messagesSvc.addMessage(mDTO, callback);
        });
    }

    private void refreshMessages() {
        //update the message containers

        MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<MessagesDTO>> callback = new AsyncCallback<ArrayList<MessagesDTO>>() {
            public void onFailure(Throwable caught) {
                // TODO: Do something with errors.
            }

            public void onSuccess(ArrayList<MessagesDTO> result) {
                view.setContents(result,user.getUser().getNickname());
            }
        };

        messagesSvc.getMessages(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Chat", "Public Online Chat", "", "", this);

        this.timer();
    }

    private void timer() {
        // Create a new timer that calls Window.alert().
        Timer t = new Timer() {
            @Override
            public void run() {
                refreshMessages();
            }
        };

        // Schedule the timer to run once in 1 second.
        t.scheduleRepeating(1000);
    }
}
