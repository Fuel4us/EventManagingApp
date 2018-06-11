package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.domain.PrivateChat;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.persistance.PrivateChatsRepository;
import pt.isep.nsheets.shared.services.PrivateChatDTO;

/**
 *
 * @author Pedro Marques Vieira
 */
public class PrivateChatService {

    public PrivateChat addPrivateChat(PrivateChatDTO pcDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        final PrivateChatsRepository privateChatRepository = PersistenceContext.repositories().privateChats();

        PrivateChat pc = PrivateChat.fromDTO(pcDTO);
        privateChatRepository.save(pc);

        return pc;
    }

    public Iterable<PrivateChat> allPrivateChats() {
        final PrivateChatsRepository privateChatRepository = PersistenceContext.repositories().privateChats();
        return privateChatRepository.findAll();
    }
}
