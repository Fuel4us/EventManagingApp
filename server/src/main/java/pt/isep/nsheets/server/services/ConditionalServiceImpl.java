package pt.isep.nsheets.server.services;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.server.lapr4.blue.n1050475.s1.application.ConditionalCellFormattingController;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalDTO;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalService;
import pt.isep.nsheets.shared.services.DataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConditionalServiceImpl  extends RemoteServiceServlet implements ConditionalService {

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
    public ArrayList<ConditionalDTO> getListConditional() {
        PersistenceContext.setSettings(this.getPersistenceSettings());

        ArrayList<ConditionalDTO> lstConditionalDTO = new ArrayList<ConditionalDTO>();

        ConditionalCellFormattingController ctrl = new ConditionalCellFormattingController();

        List<Conditional> lstConditional = ctrl.loadConditionalFromDatabase();
        for(Conditional conditional : lstConditional){
            lstConditionalDTO.add(conditional.toDTO());
        }
        return lstConditionalDTO;
    }


    @Override
    public ConditionalDTO saveConditional(ConditionalDTO conditionalDTO) throws DataException {
        ConditionalCellFormattingController ctrl = new ConditionalCellFormattingController();
        return ctrl.addConditional((CellImpl) CellImpl.fromDTO(conditionalDTO.getCell()), conditionalDTO.getConfiguration(), conditionalDTO.getCondOperator(), conditionalDTO.getCondValue()).toDTO();
    }
}
