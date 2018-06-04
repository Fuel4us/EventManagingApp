package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application;

import pt.isep.nsheets.shared.services.CalendarEventDTO;

/**
 * @author Gonçalo Silva
 */
public class EditCalendarEventController {

    public void editCalendarEvent(CalendarEventDTO dto) {
        new CalendarEventService().updateCalendarEvent(dto);
    }
}
