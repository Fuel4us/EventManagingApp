package pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.domain.Message;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160815.users.persistence.MessagesRepository;

public class ChatService {

    public Message addMessage(MessagesDTO mDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        final MessagesRepository messageRepository = PersistenceContext.repositories().messages();

        Message m = Message.fromDTO(mDTO);
        messageRepository.save(m);

        return m;
    }

    public Iterable<Message> allMessages() {
        final MessagesRepository messageRepository = PersistenceContext.repositories().messages();
        return messageRepository.findAll();
    }
}
