package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

/**
 * @author Gonçalo Silva
 */
public interface CalendarEventServiceAsync {

    void getCalendarEvents(AsyncCallback<ArrayList<CalendarEventDTO>> async);

    void editCalendarEvent(CalendarEventDTO dto, AsyncCallback<CalendarEventDTO> async);

    void createCalendarEvent(CalendarEventDTO dto, AsyncCallback<CalendarEventDTO> async);

    void deleteCalendarEvent(CalendarEventDTO dto, AsyncCallback<CalendarEventDTO> async);
}
