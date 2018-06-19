package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.shared.lapr4.green.n1140302.s3.Filter.FilterController;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.FilterService;

public class FilterServiceImpl extends RemoteServiceServlet implements FilterService {
    @Override
    public int seeIfTrue(int index, String address1, String address2, String value, WorkbookDTO workbookDto) {
        FilterController filterController = new FilterController();
        int valueInt = Integer.parseInt(value);
        return filterController.getRowToDelete(address1,address2,index,valueInt,workbookDto);
    }
}
