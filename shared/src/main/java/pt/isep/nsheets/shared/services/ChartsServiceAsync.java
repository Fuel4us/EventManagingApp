package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

/**
 * The chart service Async interface
 * @author pedromonteiro
 */
public interface ChartsServiceAsync {
	void addChart(ChartDTO chartDTO, SpreadsheetDTO s,AsyncCallback<ChartDTO> callback);
	void getCharts(AsyncCallback<ArrayList<ChartDTO>> callback);
        void getChartContent(ChartDTO dto, SpreadsheetDTO s,AsyncCallback<ChartDTO> callback );
}
