package pt.isep.nsheets.shared.lapr4.green.n1140302.s3.Filter;

import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

public class FilterController {

    private FilterServices filterService;

    public FilterController(){
        this.filterService = new FilterServices();
    }

    public int getRowToDelete(String address1, String address2,int index,int value,WorkbookDTO workbookDto){
        return this.filterService.getRowToRemove(address1,address2,index,value,workbookDto);
    }
}
