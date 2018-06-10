package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * @author Gonçalo Silva
 */
public interface CalendarEventServiceAsync {

    void getCalendarEvents(AsyncCallback<List<CalendarEventDTO>> async);

    void editCalendarEvent(CalendarEventDTO dto, AsyncCallback<Void> async);

    void createCalendarEvent(CalendarEventDTO dto, AsyncCallback<Void> async);

    void deleteCalendarEvent(CalendarEventDTO dto, AsyncCallback<Void> async);
}
