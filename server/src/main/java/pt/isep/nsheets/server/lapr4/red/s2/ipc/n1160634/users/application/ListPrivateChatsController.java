package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.domain.PrivateChat;

/**
 *
 * @author Pedro Marques Vieira
 */
public class ListPrivateChatsController implements Controller{
    
    public Iterable<PrivateChat> listPrivateChats() {
        return new PrivateChatService().allPrivateChats();
    }
}
