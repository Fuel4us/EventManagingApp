/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.BarChart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain.Chart;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.persistence.ChartRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The Chart Service.
 *
 * @author pedromonteiro
 */
public class ChartService {

    /**
     * Find all the charts in the persistence
     *
     * @return all charts
     */
    public Iterable<Chart> allCharts() {
        final ChartRepository chartRepo = PersistenceContext.repositories().charts();
        return chartRepo.findAll();
    }

    /**
     * Adds a Chart to the persistence
     *
     * @param dto Chart DTO
     * @return the added Chart
     * @throws DataConcurrencyException
     * @throws DataIntegrityViolationException
     */
    public Chart addUChart(ChartDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {

        final ChartRepository chartRepo = PersistenceContext.repositories().charts();

        switch (dto.getType()) {

            case BAR_CHART:
                BarChart chart = new BarChart(dto);
                if (addChart(chartRepo, chart)) {
                    chartRepo.save(chart);
                    return chart;
                }
                break;
        }

        return null;

    }

    private boolean addChart(ChartRepository repo, Chart chart) {

        for (Chart c : repo.findAll()) {
            if (c.equals(chart)) {
                return false;
            }
        }

        return true;
    }

}
