package pt.isep.nsheets.client.application.chat;

import com.google.gwt.core.client.GWT;
import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.Date;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.MessagesService;
import pt.isep.nsheets.shared.services.MessagesServiceAsync;

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
