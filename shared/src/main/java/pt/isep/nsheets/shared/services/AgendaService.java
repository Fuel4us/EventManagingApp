package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
@RemoteServiceRelativePath("agendaService")
public interface AgendaService {
    
    List<AgendaDTO> getAgendas();
    
    List<CalendarEventDTO> getCallendarEvents();

    void createAgenda(AgendaDTO dto) throws DataException;

    void editAgenda(AgendaDTO dto);

    void deleteAgenda(AgendaDTO dto);
    
}
