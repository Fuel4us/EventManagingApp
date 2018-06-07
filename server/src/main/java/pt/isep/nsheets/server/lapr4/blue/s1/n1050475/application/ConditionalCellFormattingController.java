package pt.isep.nsheets.server.lapr4.blue.s1.n1050475.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.s1.n1050475.persistence.ConditionalRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.ConditionalFormattingExtension;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionalCellFormattingController {


    public ConditionalCellFormattingController(){
    }

    public Conditional addConditional(Cell cell, Configuration configuration, String condOperator, Value condValue) {
        Conditional conditional = new Conditional(cell, configuration, condOperator, condValue);
        final ConditionalRepository conditionalRepository = PersistenceContext.repositories().conditional();
        Conditional ret = null;
        try {
            ret = conditionalRepository.save(conditional);
            ConditionalFormattingExtension.addConditional(ret);
        } catch (DataConcurrencyException | DataIntegrityViolationException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public ArrayList<Conditional> loadConditionalFromDatabase() {
        ArrayList<Conditional> lstConditional = new ArrayList<Conditional>();
        final ConditionalRepository conditionalRepository = PersistenceContext.repositories().conditional();

        Iterator<Conditional> conditionalIterator = conditionalRepository.findAll().iterator();
        if(conditionalIterator.hasNext()){
            Conditional c = conditionalIterator.next();
            ConditionalFormattingExtension.addConditional(c);

            lstConditional.add(c);
        }
        return lstConditional;
    }

}
