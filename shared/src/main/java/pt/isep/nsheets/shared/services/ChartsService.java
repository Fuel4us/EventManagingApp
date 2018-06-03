package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

/**
 * The Chart Service interface
 * @author pedromonteiro
 */
@RemoteServiceRelativePath("chartService")
public interface ChartsService extends RemoteService{
    
    ArrayList<ChartDTO> getCharts();
    
    ChartDTO addChart(ChartDTO chartDTO, ChartType type) throws DataException;
    
    
}
