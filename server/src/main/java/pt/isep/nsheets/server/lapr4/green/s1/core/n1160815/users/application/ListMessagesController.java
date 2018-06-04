/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.domain.Message;

/**
 *
 * @author Leandro
 */
public class ListMessagesController implements Controller{
    
    public Iterable<Message> listMessages() {
        return new ChatService().allMessages();
    }
}
