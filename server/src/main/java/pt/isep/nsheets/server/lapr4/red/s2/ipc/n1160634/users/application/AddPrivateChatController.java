package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.domain.PrivateChat;
import pt.isep.nsheets.shared.services.PrivateChatDTO;

/**
 *
 * @author Pedro Marques Vieira
 */
public class AddPrivateChatController implements Controller {

    public PrivateChat addPrivateChat(PrivateChatDTO pcDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        
    	return new PrivateChatService().addPrivateChat(pcDTO);
    }
}
