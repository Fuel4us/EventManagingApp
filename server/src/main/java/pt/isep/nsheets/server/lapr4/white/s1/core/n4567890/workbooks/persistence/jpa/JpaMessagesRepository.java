/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;


import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Message;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.MessagesRepository;

/**
 *
 * @author Leandro
 */
public class JpaMessagesRepository extends NSheetsJpaRepositoryBase<Message, Long> implements MessagesRepository {
    
    JpaMessagesRepository(PersistenceSettings settings) {
        super(settings);
    }
    
}
