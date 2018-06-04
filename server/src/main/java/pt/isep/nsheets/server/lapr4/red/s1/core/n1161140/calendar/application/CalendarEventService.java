package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.persistence.CalendarEventRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.CalendarEventDTO;

/**
 * @author Gonçalo Silva
 */
public class CalendarEventService {

    public Iterable<CalendarEvent> getAllCalendarEvents() {
        final CalendarEventRepository calendarEventRepository = PersistenceContext.repositories().calendarEvents();

        return calendarEventRepository.findAll();
    }

    public void addCalendarEvent(CalendarEventDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        final CalendarEventRepository calendarEventRepository = PersistenceContext.repositories().calendarEvents();

        calendarEventRepository.save(CalendarEvent.fromDTO(dto));
    }

    public void updateCalendarEvent(CalendarEventDTO dto) {
        final CalendarEventRepository calendarEventRepository = PersistenceContext.repositories().calendarEvents();


    }

    public void deleteCalendarEvent(CalendarEventDTO dto) {
        final CalendarEventRepository calendarEventRepository = PersistenceContext.repositories().calendarEvents();


    }
}
