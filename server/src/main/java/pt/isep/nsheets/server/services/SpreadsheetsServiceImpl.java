package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.application.AddSpreadsheetController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.application.ListSpreadsheetController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.SpreadsheetsService;
import java.util.ArrayList;
import java.util.Properties;

public class SpreadsheetsServiceImpl extends RemoteServiceServlet implements SpreadsheetsService {
    
    private PersistenceSettings getPersistenceSettings() {
        
        Properties props = new Properties();
        
        props.put("persistence.repositoryFactory",
                "pt.isep.nsheets.server.lapr4.green.s1.core.n1160832.spreadsheets.persistence.jpa.JpaRepositoryFactory");
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
    public SpreadsheetDTO addSpreadsheet(SpreadsheetDTO spreadsheetDTO) throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddSpreadsheetController ctrl = new AddSpreadsheetController();

        Spreadsheet spreadsheet = null;

        try {
            spreadsheet = ctrl.addSpreadsheet(spreadsheetDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        } catch (FormulaCompilationException e) {
            e.printStackTrace();
        }

        return spreadsheet.toDTO();
    }

    @Override
    public Iterable<SpreadsheetDTO> getSpreadsheets() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());
        
        ArrayList<SpreadsheetDTO> spreadsheets = new ArrayList<>();
        
        ListSpreadsheetController ctrl = new ListSpreadsheetController();
        
        Iterable<Spreadsheet> spreadsheetAux = ctrl.listSpreadsheets();

        spreadsheetAux.forEach(s -> spreadsheets.add(s.toDTO()));
        
        return spreadsheets;
    }
}
