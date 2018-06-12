package pt.isep.nsheets.server.lapr4.blue.n1150372.s2.application;

import com.google.gwt.dev.util.collect.HashSet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.persistence.AgendaRepository;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.domain.Agenda;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application.CalendarEventService;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.AgendaDTO;
import pt.isep.nsheets.shared.services.CalendarEventDTO;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaService {

    public Iterable<Agenda> getAllAgendas() {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        return agendaRepository.findAll();
    }

    public Iterator<CalendarEventDTO> getAllCalendarsAvailable(Iterable<CalendarEventDTO> itListCalendars) {
        Set<CalendarEventDTO> listAvailablesCalendars = new HashSet<>();
        CalendarEventDTO ce;
        Iterator<CalendarEventDTO> itListCalendar = itListCalendars.iterator();
        while (itListCalendar.hasNext()) {
            ce = itListCalendar.next();
            if (ce.getDate().before(new Date())) {
                listAvailablesCalendars.add(ce);
            }
        }
        return listAvailablesCalendars.iterator();
    }

    public void addAgenda(AgendaDTO agendaDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        agendaRepository.save(Agenda.fromDTO(agendaDTO));
    }

    public void updateAgenda(Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.update(dto);
    }

    public void deleteAgenda(Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.remove(dto);
    }

    public void addCalendarsToAgenda(HashSet<CalendarEvent> listCalendars, Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.remove(dto);
    }

    public void addCalendarToAgenda(CalendarEvent calendar, Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.remove(dto);
    }

    public void removeCalendarToAgenda(CalendarEvent calendar, Agenda agenda) {
        final AgendaRepository agendaRepository = PersistenceContext.repositories().agenda();

        //agendaRepository.remove(dto);
    }

}
