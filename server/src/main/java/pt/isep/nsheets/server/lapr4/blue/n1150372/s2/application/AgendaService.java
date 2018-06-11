package pt.isep.nsheets.server.lapr4.blue.n1150372.s2.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.persistence.AgendaRepository;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.domain.Agenda;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaService {
    
    public Iterable<Agenda> getAllAgendas() {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        return agendaRepository.findAll();
    }

    public void addCalendarEvent(Agenda agenda) throws DataConcurrencyException, DataIntegrityViolationException {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        agendaRepository.save(agenda);
    }

    public void updateCalendarEvent(Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.update(dto);
    }

    public void deleteCalendarEvent(Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.remove(dto);
    }
    
}
