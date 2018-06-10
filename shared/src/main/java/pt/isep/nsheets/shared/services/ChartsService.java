package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

/**
 * The Chart Service interface
 * @author pedromonteiro
 */
@RemoteServiceRelativePath("chartsService")
public interface ChartsService extends RemoteService{
    
    ArrayList<ChartDTO> getCharts();
    ChartDTO addChart(ChartDTO chartDTO) throws DataException;
    ChartDTO getChartContent(ChartDTO dto, SpreadsheetDTO s);
    
    
}
