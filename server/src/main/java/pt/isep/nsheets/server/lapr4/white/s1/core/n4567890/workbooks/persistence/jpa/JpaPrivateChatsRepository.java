/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;


import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.domain.PrivateChat;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160634.users.persistance.PrivateChatsRepository;

/**
 *
 * @author Pedro Marques Vieira
 */
public class JpaPrivateChatsRepository extends NSheetsJpaRepositoryBase<PrivateChat, Long> implements PrivateChatsRepository {
    
    JpaPrivateChatsRepository(PersistenceSettings settings) {
        super(settings);
    }
    
}
