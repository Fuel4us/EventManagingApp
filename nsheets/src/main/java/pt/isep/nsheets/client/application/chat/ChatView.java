package pt.isep.nsheets.client.application.chat;

import com.google.gwt.core.client.GWT;
import java.util.ArrayList;
import java.util.List;
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
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.emptystate.MaterialEmptyState;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.ImageType;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

class ChatView extends ViewImpl implements ChatPresenter.MyView {

    private final int CHAT_INDEX_PUBLIC = 1;
    private final int CHAT_INDEX_PRIVATE_2 = 2;
    private final int CHAT_INDEX_PRIVATE_3 = 3;
    private boolean FLAG = true, FLAG1 = true, FLAG2 = true, FLAG3 = true, FLAG_S2 = true,
            FLAG_S3 = true, HAS_ACCESS_2 = true, HAS_ACCESS_3 = true, SHOW_ONLY_ONCE_2 = true, SHOW_ONLY_ONCE_3 = true;
    private List<String> selectedEmailUsers2 = new ArrayList<>(), selectedEmailUsers3 = new ArrayList<>();
    
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
    MaterialEmptyState emptyState1, emptyState2, emptyState3;
    
    @UiField
    MaterialButton searchBtn2, searchBtn3, sendButton1, sendButton2, sendButton3;

    @UiField
    MaterialCard messageCard1, messageCard2, messageCard3;
    
    @UiField
    MaterialTextBox txtMessage1, txtMessage2, txtMessage3;
    
    
    @UiHandler("searchBtn2")
    public void onTagMultiGetValue2(ClickEvent e) {
        if(FLAG_S2){
            if(comboBox2.getSelectedValues().isEmpty()){
                MaterialToast.fireToast("Users not selected!");
            }
            else{
                comboBox2.setEnabled(false);
                for (String value : ((List<String>)comboBox2.getSelectedValues())) {
                    selectedEmailUsers2.add(value);
                }
                FLAG_S2 = false;
                HAS_ACCESS_2 = false;
                searchBtn2.setVisible(false);
                MaterialToast.fireToast("Users selected in private chat 1 saved!");
            }
        }
    }

    @UiHandler("searchBtn3")
    public void onTagMultiGetValue3(ClickEvent e) {
        if(FLAG_S3){
            if(comboBox3.getSelectedValues().isEmpty()){
                MaterialToast.fireToast("Users not selected!");
            }
            else{
                comboBox3.setEnabled(false);
                for (String value : ((List<String>) comboBox3.getSelectedValues())) {
                    selectedEmailUsers3.add(value);
                }
                FLAG_S3 = false;
                HAS_ACCESS_3 = false;
                searchBtn3.setVisible(false);
                MaterialToast.fireToast("Users selected in private chat 2 saved!");
            }
        }
    }
    
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
        
        messageCard1.clear();
        messageCard2.clear();
        messageCard3.clear();
        
        //add items to the comboboxes
//        if (FLAG) {
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
//            FLAG = false;
//        }
        

        //FIX-ME hardcoded to add the "users"
        if(FLAG){
            
            comboBox2.addItem("1160557@isep.ipp.pt", "1160557@isep.ipp.pt");
            comboBox2.addItem("1160634@isep.ipp.pt", "1160634@isep.ipp.pt");
            comboBox2.addItem("1161140@isep.ipp.pt", "1161140@isep.ipp.pt");
            comboBox2.addItem("1160630@isep.ipp.pt", "1160630@isep.ipp.pt");
            comboBox2.addItem("1160600@isep.ipp.pt", "1160600@isep.ipp.pt");
            comboBox2.addItem("1160629@isep.ipp.pt", "1160629@isep.ipp.pt");
            
            comboBox3.addItem("1160557@isep.ipp.pt", "1160557@isep.ipp.pt");
            comboBox3.addItem("1160634@isep.ipp.pt", "1160634@isep.ipp.pt");
            comboBox3.addItem("1161140@isep.ipp.pt", "1161140@isep.ipp.pt");
            comboBox3.addItem("1160630@isep.ipp.pt", "1160630@isep.ipp.pt");
            comboBox3.addItem("1160600@isep.ipp.pt", "1160600@isep.ipp.pt");
            comboBox3.addItem("1160629@isep.ipp.pt", "1160629@isep.ipp.pt");
            
            FLAG = false;
        }
        
        
        
        boolean isOnPrivateList2 = false, isOnPrivateList3 = false;
        
        if(!selectedEmailUsers2.isEmpty()){
            for(String email : selectedEmailUsers2){
                if(email.equals(userDto.getEmail()))
                    isOnPrivateList2 = true;
            }
        }
        
        if(!selectedEmailUsers3.isEmpty()){
            for(String email : selectedEmailUsers3){
                if(email.equals(userDto.getEmail()))
                    isOnPrivateList3 = true;
            }
        }
        
        for (MessagesDTO m : contents) {

            if (m.getChatIndex() == CHAT_INDEX_PUBLIC) {
                if(FLAG1){
                    emptyState1.setVisible(false);
                    FLAG1 = false;
                }
                createBubble(m, userDto.getNickname(), CHAT_INDEX_PUBLIC);
            }

            if ( (m.getChatIndex() == CHAT_INDEX_PRIVATE_2) && (isOnPrivateList2 || HAS_ACCESS_2) ) {
//            if (m.getChatIndex() == CHAT_INDEX_PRIVATE_2){
                
                if(FLAG2){
                    emptyState2.setVisible(false);
                    FLAG2 = false;
                }

                createBubble(m, userDto.getNickname(), CHAT_INDEX_PRIVATE_2);

            }
            else if((m.getChatIndex() == CHAT_INDEX_PRIVATE_2) && (!isOnPrivateList2 || HAS_ACCESS_2)){
                if(SHOW_ONLY_ONCE_2){
                    MaterialToast.fireToast("You don't have access to this chat");
                    SHOW_ONLY_ONCE_2 = false;
                }
            }
                

            if ( (m.getChatIndex() == CHAT_INDEX_PRIVATE_3) && (isOnPrivateList3 || HAS_ACCESS_3) ) {
//            if (m.getChatIndex() == CHAT_INDEX_PRIVATE_3) {
                if(FLAG3){
                    emptyState3.setVisible(false);
                    FLAG3 = false;
                }
                
                createBubble(m, userDto.getNickname(), CHAT_INDEX_PRIVATE_3);
            }
            else if((m.getChatIndex() == CHAT_INDEX_PRIVATE_3) && (!isOnPrivateList3 || HAS_ACCESS_3)){
                if(SHOW_ONLY_ONCE_3){
                    MaterialToast.fireToast("You don't have access to this chat");
                    SHOW_ONLY_ONCE_3 = false;
                }
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
    
    private void createBubble(MessagesDTO m, String currentNickName, int index_chat) {
        
        MaterialImage avatar = new MaterialImage();
        avatar.setUrl("https://cdn1.iconfinder.com/data/icons/fs-icons-ubuntu-by-franksouza-/512/goa-account-msn.png");
        avatar.setType(ImageType.CIRCLE);
        avatar.setMarginTop(8);
        avatar.setWidth("40px");
        avatar.setHeight("40px");
        avatar.setShadow(1);
        
        String messageuser = m.getUser();

        MaterialRow row = new MaterialRow();
        row.setMarginBottom(0);
        
        MaterialBubble bubble = new MaterialBubble(Color.WHITE, Color.GREY);
        
        MaterialLabel userLabel = new MaterialLabel();
        userLabel.setText(messageuser);

        MaterialLabel textLabel = new MaterialLabel();
        textLabel.setText(m.getText());
        textLabel.setFontSize("1.4em");

        MaterialLabel dateLabel = new MaterialLabel();
        dateLabel.setText(m.getDate().toString());
        dateLabel.setFontSize("0.6em");
        dateLabel.setFloat(Style.Float.RIGHT);

        if (messageuser.equals(currentNickName)) {
            avatar.setFloat(Style.Float.LEFT);
            avatar.setMarginLeft(12);
            bubble.setTextColor(Color.GREY_DARKEN_2);
            bubble.setBackgroundColor(Color.WHITE);
            bubble.setPosition(Position.LEFT);
            bubble.setFloat(Style.Float.LEFT);
        }
        else{
            avatar.setFloat(Style.Float.RIGHT);
            avatar.setMarginRight(12);
            bubble.setPosition(Position.RIGHT);
            bubble.setFloat(Style.Float.RIGHT);
        }

        
        bubble.add(userLabel);
        bubble.add(textLabel);
        bubble.add(dateLabel);
        
        row.add(avatar);
        row.add(bubble);
        
        if(index_chat == CHAT_INDEX_PUBLIC){
            messageCard1.add(row);
        }
        
        if(index_chat == CHAT_INDEX_PRIVATE_2){
            messageCard2.add(row);
        }
        
        if(index_chat == CHAT_INDEX_PRIVATE_3){
            messageCard3.add(row);
        }
        
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
