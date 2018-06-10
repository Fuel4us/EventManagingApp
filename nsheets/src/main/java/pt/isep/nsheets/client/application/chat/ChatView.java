package pt.isep.nsheets.client.application.chat;

import com.google.gwt.core.client.GWT;
import java.util.ArrayList;
import javax.inject.Inject;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;

import gwt.material.design.client.constants.CollectionType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.ImageType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTabItem;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.List;

import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

class ChatView extends ViewImpl implements ChatPresenter.MyView {

    private final int CHAT_INDEX_PUBLIC = 1;
    private final int CHAT_INDEX_PRIVATE_2 = 2;
    private final int CHAT_INDEX_PRIVATE_3 = 3;
    private boolean flag = true;

    interface Binder extends UiBinder<Widget, ChatView> {
    }

//    @UiField
//    MaterialTab dynamicTabs;
//    @UiField
//    MaterialRow dynamicTabsRow;
//    @UiField
//    MaterialButton addTab;
    @UiField
    MaterialComboBox comboBox2, comboBox3;

    @UiField
    MaterialButton sendButton1, sendButton2, sendButton3;

    @UiField
    MaterialCollection messagesCollection1, messagesCollection2, messagesCollection3;

    @UiField
    MaterialTextBox txtMessage1, txtMessage2, txtMessage3;

//    private int index = 0;
    @Inject
    ChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

//        buildDynamicTab();
    }

//    @UiHandler("addTab")
//    void addTab(ClickEvent e) {
//        index++;
//        dynamicTabs.add(newTabItem(index));
//        dynamicTabs.setTabIndex(index - 1);
//    }
    @Override
    public void setContents(ArrayList<MessagesDTO> contents, UserDTO userDto) {

//        dynamicTabs.reload();
        
        messagesCollection1.clear();
        messagesCollection2.clear();
        messagesCollection3.clear();
        
        //add items to the comboboxes
        //only enter at the first time
//        if (flag) {
//            UsersServiceAsync usersSvc = GWT.create(UsersService.class);
//            // Set up the callback object.
//            AsyncCallback<ArrayList<UserDTO>> callback = new AsyncCallback<ArrayList<UserDTO>>() {
//                @Override
//                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Error! " + caught.getMessage());
//                }
//
//                @Override
//                public void onSuccess(ArrayList<UserDTO> result) {
//                    comboBox2.addItems(result);
//                    comboBox3.addItems(result);
//                    if(result.isEmpty())
//                        MaterialToast.fireToast("vazia");
//                }
//
//            };
//
//            usersSvc.getUsers(callback);
//            
//            flag = false;
//        }
        
        //FIX-ME só pra testar
        //see the selected itens
//        comboBox2.addItem(userDto.getEmail(), userDto);
//        List<UserDTO> listSelectedUsers = comboBox2.getSelectedValues();
        // combobox.setEnabled(false);
        
        for (MessagesDTO m : contents) {
            MaterialCollectionItem card = createCard(m, userDto.getNickname());

            if (m.getChatIndex() == CHAT_INDEX_PUBLIC) {
                messagesCollection1.add(card);
            }

            if (m.getChatIndex() == CHAT_INDEX_PRIVATE_2) {
                messagesCollection2.add(card);
            }

            if (m.getChatIndex() == CHAT_INDEX_PRIVATE_3) {
                messagesCollection3.add(card);
            }

        }

    }

//    private void buildDynamicTab() {
//        dynamicTabs.addSelectionHandler(selectionEvent -> MaterialToast.fireToast("Selected " + selectionEvent.getSelectedItem()));
//        for (int i = 1; i <= 2; i++) {
//            dynamicTabs.add(newTabItem(i));
//            index = i;
//        }
//    }
//    private MaterialTabItem newTabItem(int index) {
//        MaterialTabItem item = new MaterialTabItem();
//        item.setWaves(WavesType.DEFAULT);
//        MaterialLink link = new MaterialLink("Tab " + index);
//        link.setTextColor(Color.WHITE);
//        link.setHref("#dynamicTab" + index);
//        item.add(link);
//        MaterialLabel content = new MaterialLabel("Content " + index);
//        content.setId("dynamicTab" + index);
//        dynamicTabsRow.add(content);
//        return item;
//    }
    private MaterialCollectionItem createCard(MessagesDTO m, String currentNickName) {
        MaterialCollectionItem card = new MaterialCollectionItem();
        card.setType(CollectionType.AVATAR);

        MaterialImage avatar = new MaterialImage();

        avatar.setUrl("https://cdn1.iconfinder.com/data/icons/fs-icons-ubuntu-by-franksouza-/512/goa-account-msn.png");
        avatar.setType(ImageType.CIRCLE);

        String messageuser = m.getUser();

        MaterialLabel userLabel = new MaterialLabel();
        userLabel.setText(messageuser);
        userLabel.setFontSize("1.2em");

        MaterialLabel textLabel = new MaterialLabel();
        textLabel.setText(m.getText());

        MaterialLabel dateLabel = new MaterialLabel();
        dateLabel.setText(m.getDate().toString());
        dateLabel.setFontSize("0.6em");
        dateLabel.setFloat(Style.Float.RIGHT);

        if (messageuser.equals(currentNickName)) {
            card.setBackgroundColor(Color.GREY);
        }

        card.add(avatar);
        card.add(userLabel);
        card.add(textLabel);
        card.add(dateLabel);

        return card;
    }

    @Override
    public void buttonClickHandlerPublicChat(ClickHandler ch) {
        sendButton1.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerPrivateChat2(ClickHandler ch) {
        sendButton2.addClickHandler(ch);
    }

    @Override
    public void buttonClickHandlerPrivateChat3(ClickHandler ch) {
        sendButton3.addClickHandler(ch);
    }

    @Override
    public String textPublicChat() {
        String text = this.txtMessage1.getValue();
        txtMessage1.clear();

        return text;
    }

    @Override
    public String textPrivateChat2() {
        String text = this.txtMessage2.getValue();
        txtMessage2.clear();

        return text;
    }

    @Override
    public String textPrivateChat3() {
        String text = this.txtMessage3.getValue();
        txtMessage3.clear();

        return text;
    }
}
