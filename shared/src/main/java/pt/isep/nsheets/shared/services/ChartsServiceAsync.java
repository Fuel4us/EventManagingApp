package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;

/**
 * The chart service Async interface
 * @author pedromonteiro
 */
public interface ChartsServiceAsync {
	void addChart(ChartDTO chartDTO/*, Spreadsheet s*/,AsyncCallback<ChartDTO> callback);
	void getCharts(AsyncCallback<ArrayList<ChartDTO>> callback);
        void getChartContent(ChartDTO dto/*, Spreadsheet s*/,AsyncCallback<String[][]> callback );
}
