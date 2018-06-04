package pt.isep.nsheets.client.application.chat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.CollectionType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.ImageType;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.ArrayList;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

class ChatView extends ViewImpl implements ChatPresenter.MyView {

    interface Binder extends UiBinder<Widget, ChatView> {
    }

    @UiField
    MaterialButton sendButton;

    @UiField
    MaterialTextBox txtMessage;

    @UiField
    MaterialCollection messageCollection;

    //@UiField
    //MaterialCard messageCard;
    
    @Inject
    ChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setContents(ArrayList<MessagesDTO> contents) {
        //update the message container
        //messageCard.clear();
        messageCollection.clear();

        //final ScrollPanel scrollMessagesPanel = new ScrollPanel();
        //scrollMessagesPanel.setSize("1150px", "350px");
        
        for (MessagesDTO m : contents) {
            MaterialCollectionItem card = createCard(m);

            messageCollection.add(card);
        }

        //scrollMessagesPanel.add(messageCollection);
        //messageCard.add(scrollMessagesPanel);
    }

    private MaterialCollectionItem createCard(MessagesDTO m) {
        MaterialCollectionItem card = new MaterialCollectionItem();
        card.setType(CollectionType.AVATAR);

        MaterialImage avatar = new MaterialImage();
        avatar.setUrl("https://cdn.pixabay.com/photo/2016/11/18/23/38/child-1837375_960_720.png");
        avatar.setType(ImageType.CIRCLE);

        MaterialLabel userLabel = new MaterialLabel();
        userLabel.setText(m.getUser());
        userLabel.setFontSize("1.2em");

        MaterialLabel textLabel = new MaterialLabel();
        textLabel.setText(m.getText());

        MaterialLabel dateLabel = new MaterialLabel();
        dateLabel.setText(m.getDate().toString());
        dateLabel.setFontSize("0.6em");
        dateLabel.setFloat(Style.Float.RIGHT);

        card.add(avatar);
        card.add(userLabel);
        card.add(textLabel);
        card.add(dateLabel);

        return card;
    }

    @Override
    public void buttonClickHandler(ClickHandler ch) {
        sendButton.addClickHandler(ch);
    }

    @Override
    public String text() {
        String text = this.txtMessage.getValue();
        txtMessage.clear();

        return text;
    }

}
