package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public interface AgendaServiceAsync {

    void getCallendarEvents(AsyncCallback<List<CalendarEventDTO>> async);

    void getAgendas(AsyncCallback<List<AgendaDTO>> async);

    void editAgenda(AgendaDTO dto, AsyncCallback<Void> async);

    void createAgenda(AgendaDTO dto, AsyncCallback<Void> async);

    void deleteCalendarEvent(AgendaDTO dto, AsyncCallback<Void> async);

}
