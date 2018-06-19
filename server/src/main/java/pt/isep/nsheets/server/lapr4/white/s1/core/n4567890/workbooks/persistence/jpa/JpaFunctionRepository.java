/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.server.lapr4.red.s3.lang.n1160630.Js.FunctionRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.js_complex.Function;

/**
 *
 * @author pedromonteiro
 */
public class JpaFunctionRepository extends NSheetsJpaRepositoryBase<Function, String> implements FunctionRepository{
    
    JpaFunctionRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public void delete(Function entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    
    
}
