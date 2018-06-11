package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.n1050475.s2.application.CellStyleController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleService;
import pt.isep.nsheets.shared.services.DataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CellStyleServiceImpl extends RemoteServiceServlet implements CellStyleService {

    private PersistenceSettings getPersistenceSettings(){
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
    public ArrayList<CellStyleDTO> getListCellStyle() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<CellStyleDTO> lstCellStyleDTO = new ArrayList<CellStyleDTO>();

        CellStyleController ctrl = new CellStyleController();

        Iterable<CellStyle> lstCellStyle = ctrl.loadCellStyleFromDatabase();
        for(CellStyle cellStyle : lstCellStyle){
            lstCellStyleDTO.add(cellStyle.toDTO());
        }
        return lstCellStyleDTO;
    }


    @Override
    public CellStyleDTO saveCellStyle(CellStyleDTO cellStyleDTO) throws DataException {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        CellStyleController ctrl = new CellStyleController();

        CellStyle cellStyle = null;

        try {
            cellStyle = ctrl.addCellStyle(cellStyleDTO);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            throw new DataException((Throwable) ex);
        }

        return cellStyle.toDTO();
    }
}
