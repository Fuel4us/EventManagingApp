package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.services.CalendarEventDTO;

/**
 * @author Gonçalo Silva
 */
public class CreateCalendarEventController {

    public void createCalendarEvent(CalendarEventDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        new CalendarEventService().addCalendarEvent(dto);
    }
}
