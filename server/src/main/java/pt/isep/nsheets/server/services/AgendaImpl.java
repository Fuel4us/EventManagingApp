package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s2.application.CreateAgendaController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.AgendaDTO;
import pt.isep.nsheets.shared.services.AgendaService;
import pt.isep.nsheets.shared.services.CalendarEventDTO;
import pt.isep.nsheets.shared.services.DataException;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaImpl extends RemoteServiceServlet implements AgendaService {

    private PersistenceSettings getPersistenceSettings() {
        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public List<AgendaDTO> getAgendas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CalendarEventDTO> getCallendarEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createAgenda(AgendaDTO dto) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        CreateAgendaController controller = new CreateAgendaController();

        try {
            controller.createAgenda(dto);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(AgendaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editAgenda(AgendaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAgenda(AgendaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
