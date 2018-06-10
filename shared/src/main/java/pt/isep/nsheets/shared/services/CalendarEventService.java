package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * @author Gonçalo Silva
 */
@RemoteServiceRelativePath("calendarEventsService")
public interface CalendarEventService extends RemoteService {

    List<CalendarEventDTO> getCalendarEvents();

    void createCalendarEvent(CalendarEventDTO dto) throws DataException;

    void editCalendarEvent(CalendarEventDTO dto);

    void deleteCalendarEvent(CalendarEventDTO dto);
}
