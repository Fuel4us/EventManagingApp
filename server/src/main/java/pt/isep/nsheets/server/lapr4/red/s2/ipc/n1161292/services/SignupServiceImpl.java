package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161292.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1161292.users.application.SignupController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.services.SignupService;


/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
public class SignupServiceImpl extends RemoteServiceServlet implements SignupService {
    
    private PersistenceSettings getPersistenceSettings() {
        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        return new PersistenceSettings(props);
    }

    @Override
    public UserDTO signupUser(UserDTO dto) {
        PersistenceContext.setSettings(this.getPersistenceSettings());
        SignupController ctrl = new SignupController();
        
        try {
            return ctrl.signupUser(dto).toDTO();
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(SignupServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
