package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

/**
 * @author Gonçalo Silva
 */
@RemoteServiceRelativePath("calendarEventsService")
public interface CalendarEventService extends RemoteService {

    ArrayList<CalendarEventDTO> getCalendarEvents();

    CalendarEventDTO createCalendarEvent(CalendarEventDTO dto) throws DataException;

    CalendarEventDTO editCalendarEvent(CalendarEventDTO dto);

    CalendarEventDTO deleteCalendarEvent(CalendarEventDTO dto);
}
