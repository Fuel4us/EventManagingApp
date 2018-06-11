package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.domain.Agenda;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.persistence.AgendaRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class JpaAgendaRepository extends NSheetsJpaRepositoryBase<Agenda, Long> implements AgendaRepository {

    JpaAgendaRepository(PersistenceSettings settings) {
        super(settings);
    }
}
