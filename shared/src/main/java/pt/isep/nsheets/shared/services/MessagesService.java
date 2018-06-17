/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
@RemoteServiceRelativePath("messagesService")
public interface MessagesService extends RemoteService{
    
    MessagesDTO addMessage(MessagesDTO mDTO) throws DataException;
    
    ArrayList<MessagesDTO> getMessages();
    
    ArrayList<NotificationDTO> getNotifications(String username);
}
