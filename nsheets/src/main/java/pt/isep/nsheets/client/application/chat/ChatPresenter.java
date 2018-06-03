package pt.isep.nsheets.client.application.chat;

import com.google.gwt.core.client.GWT;
import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickHandler;
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
import java.util.Date;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.MessagesService;
import pt.isep.nsheets.shared.services.MessagesServiceAsync;

public class ChatPresenter extends Presenter<ChatPresenter.MyView, ChatPresenter.MyProxy> {

    private MyView view;

    interface MyView extends View {

        void buttonClickHandler(ClickHandler ch);
        
        String text();
    }

    @NameToken(NameTokens.chat)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ChatPresenter> {
    }

    @Inject
    ChatPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

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
                    
                    Window.alert(result.toString());
                    //refreshView();
                }

            };
            
            MessagesDTO mDTO = new MessagesDTO(view.text(), new Date(), "User12343");
            messagesSvc.addMessage(mDTO, callback);
        });
    }

    private void refreshView() {
        //update the message containers
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Chat", "Public Online Chat", "", "", this);

        refreshView();
    }
}
