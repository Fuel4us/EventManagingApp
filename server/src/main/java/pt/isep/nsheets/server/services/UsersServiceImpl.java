package pt.isep.nsheets.server.services;

import com.google.gwt.dev.util.collect.HashSet;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.LoginUserController;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Set;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.application.ContactsService;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.application.ListUserController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;

public class UsersServiceImpl extends RemoteServiceServlet implements UsersService {

    private PersistenceSettings getPersistenceSettings() {

        Properties props = new Properties();

        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
        props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

        // Other JPA properties that one might want to override from the ones in
        // persistence.xml
        // props.put("javax.persistence.jdbc.url",
        // "jdbc:h2:../db/nsheets;MV_STORE=FALSE;MVCC=FALSE");
        // props.put("javax.persistence.jdbc.password", "");
        // props.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        // props.put("javax.persistence.jdbc.user", "");
        // props.put("javax.persistence.schema-generation.database.action", "create");
        // props.put("eclipselink.logging.level", "FINE");
        return new PersistenceSettings(props);
    }

    @Override
    public ArrayList<UserDTO> getUsers() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<UserDTO> users = new ArrayList<>();

        ListUserController ctrl = new ListUserController();

        Iterable<User> usrs = ctrl.listUsers();

        usrs.forEach(u -> users.add(u.toDTO()));

        return users;
    }

    @Override
    public UserDTO attemptLogin(String email, String password) {
        LoginUserController ctrl = new LoginUserController();
        UserDTO u = ctrl.attemptLogin(email, password);

        return u;
    }

    @Override
    public void addWorkbook(WorkbookDTO workbook, UserDTO user) {
        PersistenceContext.setSettings(getPersistenceSettings());
        ContactsService service = new ContactsService();
        User result = service.findUserByEmail(user.getEmail());
        result.addWorkbook(Workbook.fromDTO(workbook));
    }

    @Override
    public Iterable<WorkbookDTO> getWorkbook(UserDTO user) {
        PersistenceContext.setSettings(getPersistenceSettings());
        ContactsService service = new ContactsService();
        User result = service.findUserByEmail(user.getEmail());
        Iterable<Workbook> temp = result.getWorkbooks();
        Set<WorkbookDTO> aux = new HashSet<>();
        for (Workbook workbook : temp) {
            aux.add(workbook.toDTO());
        }
        return aux;
    }
}
