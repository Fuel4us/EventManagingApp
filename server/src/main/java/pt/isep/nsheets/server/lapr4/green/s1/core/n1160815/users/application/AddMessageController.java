package pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.domain.Message;
import pt.isep.nsheets.shared.services.MessagesDTO;

public class AddMessageController implements Controller {

    public Message addMessage(MessagesDTO mDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        
    	return new ChatService().addMessage(mDTO);
    }
}
