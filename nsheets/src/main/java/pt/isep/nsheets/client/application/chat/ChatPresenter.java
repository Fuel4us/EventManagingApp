package pt.isep.nsheets.client.application.chat;

import java.util.ArrayList;
import java.util.Date;

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
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.MessagesService;
import pt.isep.nsheets.shared.services.MessagesServiceAsync;
import pt.isep.nsheets.shared.services.UserDTO;

public class ChatPresenter extends Presenter<ChatPresenter.MyView, ChatPresenter.MyProxy> {

    private final int CHAT_INDEX_PUBLIC = 1;
    private final int CHAT_INDEX_PRIVATE_2 = 2;
    private final int CHAT_INDEX_PRIVATE_3 = 3;

    private MyView view;

    interface MyView extends View {

        void buttonClickHandlerPublicChat(ClickHandler ch);

        void buttonClickHandlerPrivateChat2(ClickHandler ch);

        void buttonClickHandlerPrivateChat3(ClickHandler ch);

        void setContents(ArrayList<MessagesDTO> contents, UserDTO userDto);

        String textPublicChat();

        String textPrivateChat2();

        String textPrivateChat3();

        void buttonClickHandlerUploadImage1(ClickHandler ch);

        void buttonClickHandlerUploadImage2(ClickHandler ch);

        void buttonClickHandlerUploadImage3(ClickHandler ch);
    }

    @NameToken(NameTokens.chat)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ChatPresenter> {
    }

    private CurrentUser user;

    @Inject
    ChatPresenter(EventBus eventBus, MyView view, MyProxy proxy, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        
        refreshMessages();

        this.user = currentUser;
        this.view = view;

        this.view.buttonClickHandlerPublicChat(e -> {
            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);

            // Set up the callback object.
            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(MessagesDTO result) {
                    refreshMessages();
                }

            };
            MessagesDTO mDTO = new MessagesDTO(view.textPublicChat(), new Date(), this.user.getUser().getNickname(), CHAT_INDEX_PUBLIC);
            messagesSvc.addMessage(mDTO, callback);
        });

        this.view.buttonClickHandlerPrivateChat2(e -> {
            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);

            // Set up the callback object.
            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(MessagesDTO result) {
                    refreshMessages();
                }

            };
            MessagesDTO mDTO = new MessagesDTO(view.textPrivateChat2(), new Date(), this.user.getUser().getNickname(), CHAT_INDEX_PRIVATE_2);
            messagesSvc.addMessage(mDTO, callback);
        });

        this.view.buttonClickHandlerPrivateChat3(e -> {
            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);

            // Set up the callback object.
            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(MessagesDTO result) {
                    refreshMessages();
                }

            };
            MessagesDTO mDTO = new MessagesDTO(view.textPrivateChat3(), new Date(), this.user.getUser().getNickname(), CHAT_INDEX_PRIVATE_3);
            messagesSvc.addMessage(mDTO, callback);
        });
        
//        //####################################IMAGE UPLOAD####################################
//
//        this.view.buttonClickHandlerUploadImage1(e -> {
//            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(MessagesDTO result) {
//                    refreshMessages();
//                }
//
//            };
//            MessagesDTO mDTO = new MessagesDTO(view.textPublicChat(), new Date(), this.user.getUser().getNickname(), CHAT_INDEX_PUBLIC);
//            messagesSvc.addMessage(mDTO, callback);
//        });
//        
//        this.view.buttonClickHandlerUploadImage2(e -> {
//            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(MessagesDTO result) {
//                    refreshMessages();
//                }
//
//            };
//            MessagesDTO mDTO = new MessagesDTO(view.textPrivateChat2(), new Date(), this.user.getUser().getNickname(), CHAT_INDEX_PRIVATE_2);
//            messagesSvc.addMessage(mDTO, callback);
//        });
//        
//        this.view.buttonClickHandlerUploadImage3(e -> {
//            MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);
//
//            // Set up the callback object.
//            AsyncCallback<MessagesDTO> callback = new AsyncCallback<MessagesDTO>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(MessagesDTO result) {
//                    refreshMessages();
//                }
//
//            };
//            MessagesDTO mDTO = new MessagesDTO(view.textPrivateChat3(), new Date(), this.user.getUser().getNickname(), CHAT_INDEX_PRIVATE_3);
//            messagesSvc.addMessage(mDTO, callback);
//        });

    }

    private void refreshMessages() {
        //update the message containers

        MessagesServiceAsync messagesSvc = GWT.create(MessagesService.class);

        // Set up the callback object.
        AsyncCallback<ArrayList<MessagesDTO>> callback = new AsyncCallback<ArrayList<MessagesDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("Error! " + caught.getMessage());
            }

            @Override
            public void onSuccess(ArrayList<MessagesDTO> result) {
                view.setContents(result, user.getUser());
            }
        };

        messagesSvc.getMessages(callback);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Chat", "Online Chat", "", "", this);

        this.timer();
    }

    private void timer() {
        // Create a new timer
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
