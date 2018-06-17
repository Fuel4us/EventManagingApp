/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public interface MessagesServiceAsync {

    void addMessage(MessagesDTO mDTO, AsyncCallback<MessagesDTO> callback);

    void getMessages(AsyncCallback<ArrayList<MessagesDTO>> callback);

    void getNotifications(String username, AsyncCallback<ArrayList<NotificationDTO>> callback);
}
