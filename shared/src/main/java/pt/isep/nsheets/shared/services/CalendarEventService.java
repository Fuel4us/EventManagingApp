package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

@RemoteServiceRelativePath("calendarEventsService")
public interface CalendarEventService extends RemoteService {

    ArrayList<CalendarEventDTO> getWorkbooks();
}
