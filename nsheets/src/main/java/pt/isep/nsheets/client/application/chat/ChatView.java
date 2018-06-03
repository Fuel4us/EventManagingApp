package pt.isep.nsheets.client.application.chat;


import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

class ChatView extends ViewImpl implements ChatPresenter.MyView {
    
    interface Binder extends UiBinder<Widget, ChatView> {
    }

    @UiField
    MaterialButton sendButton;

    @UiField
    MaterialTextBox txtMessage;
    
    @Inject
    ChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void buttonClickHandler(ClickHandler ch) {
        sendButton.addClickHandler(ch);
    }

    @Override
    public String text() {
        String text = this.txtMessage.getValue();
        //txtMessage.clear();
        
        return text;
    }
    
}
