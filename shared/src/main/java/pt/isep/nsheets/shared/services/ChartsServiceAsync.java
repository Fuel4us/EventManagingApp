package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 * The chart service Async interface
 * @author pedromonteiro
 */
public interface ChartsServiceAsync {
	void addChart(ChartDTO chartDTO, ChartType type, AsyncCallback<ChartDTO> callback);
	void getCharts(AsyncCallback<ArrayList<ChartDTO>> callback);
}
