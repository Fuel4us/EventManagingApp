package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.application;

import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;

/**
 * @author Gonçalo Silva
 */
public class ViewCalendarEventsController {

    public Iterable<CalendarEvent> viewCalendarEvents() {
        return new CalendarEventService().getAllCalendarEvents();
    }
}
