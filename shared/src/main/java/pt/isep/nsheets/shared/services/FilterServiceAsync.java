package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public interface FilterServiceAsync {
    void seeIfTrue(int index, String address1, String address2, String value, WorkbookDTO workbookDTO, AsyncCallback<Integer> async);
}
