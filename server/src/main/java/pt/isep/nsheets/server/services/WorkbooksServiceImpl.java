package pt.isep.nsheets.server.services;

import java.util.ArrayList;
import java.util.Properties;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application.DeleteWorkbookController;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1140572.workbooks.application.RenameWorkbookController;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.AddWorkbookDescriptionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application.ListWorkbookDescriptionController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.DataException;

public class WorkbooksServiceImpl extends RemoteServiceServlet implements WorkbooksService {

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
    public ArrayList<WorkbookDTO> getWorkbooks() {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<WorkbookDTO> workbooks = new ArrayList<>();

        ListWorkbookDescriptionController ctrl = new ListWorkbookDescriptionController();

        Iterable<Workbook> wbs = ctrl.listWorkbookDescriptions();

        wbs.forEach(wb -> workbooks.add(wb.toDTO()));

        return workbooks;
    }

    @Override
    public WorkbookDTO addWorkbookDescription(WorkbookDTO wbDTO)
            throws DataException {
        // Setup the persistence settings
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddWorkbookDescriptionController ctrl = new AddWorkbookDescriptionController();

        Workbook workbook = null;

        try {
            workbook = ctrl.addWorkbook(wbDTO);
        } catch (DataConcurrencyException | FormulaCompilationException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

        return workbook.toDTO();
    }

    @Override
    public WorkbookDTO findByName(String name) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        AddWorkbookDescriptionController ctrl = new AddWorkbookDescriptionController();

        Workbook workbook = null;

        try {
            workbook = ctrl.findByName(name);
        } catch (DataConcurrencyException | DataIntegrityViolationException e) {
            throw new DataException((Throwable) e);
        }

        return workbook.toDTO();
    }

    @Override
    public void renameWorkbook(String name, WorkbookDTO wdto){
        PersistenceContext.setSettings(this.getPersistenceSettings());
        RenameWorkbookController ctrl = new RenameWorkbookController();
        ctrl.renameWorkbook(name, wdto);
    }

    @Override
    public void deleteWorkbook(WorkbookDTO wdto) {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        DeleteWorkbookController ctrl = new DeleteWorkbookController();
        ctrl.deleteWorkbook(wdto);
    }

}
