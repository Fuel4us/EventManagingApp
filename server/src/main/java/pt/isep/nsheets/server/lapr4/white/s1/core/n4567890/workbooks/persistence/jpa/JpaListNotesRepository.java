/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.domain.ListNotes;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.persistence.ListNotesRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 *
 * @author Tiago Correia
 */
public class JpaListNotesRepository extends NSheetsJpaRepositoryBase<ListNotes, Long> implements ListNotesRepository{
    
    JpaListNotesRepository(PersistenceSettings settings) {
        super(settings);
    }
}
