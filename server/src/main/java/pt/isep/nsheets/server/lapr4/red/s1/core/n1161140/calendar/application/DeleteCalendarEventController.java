package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application;

import pt.isep.nsheets.shared.services.CalendarEventDTO;

/**
 * @author Gonçalo Silva
 */
public class DeleteCalendarEventController {

    public void deleteCalendarEvent(CalendarEventDTO dto) {
        new CalendarEventService().deleteCalendarEvent(dto);
    }
}
