package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.red.s3.lang.n1160634.macro.persistance.MacroRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.lapr4.red.s3.lang.n1160634.macro.domain.Macro;


/**
 *
 * @author Pedro Marques Vieira
 */
public class JpaMacroRepository extends NSheetsJpaRepositoryBase<Macro, Long> implements MacroRepository{
    
        JpaMacroRepository(PersistenceSettings settings){
        super(settings);
    }
}
