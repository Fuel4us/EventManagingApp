/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Optional;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.persistence.ChartRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

/**
 *
 * @author pedromonteiro
 */
public class JpaChartRepository extends NSheetsJpaRepositoryBase<Chart, Long> implements ChartRepository{

    JpaChartRepository(PersistenceSettings settings) {
        super(settings);
    }
    
}
