package pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Application;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import java.util.List;

public class SearchSpreadsheetController {
    private SearchService searchService;

    private List<CellDTO> cellList;
    private String searchResult;
    private WorkbookDTO workbook;

    public SearchSpreadsheetController(){
        searchService = new SearchService();
    }

    public void setWorkbook(WorkbookDTO workbook){
        this.workbook=workbook;
    }





    public void setCellList(){
        this.cellList=searchService.getCellsFromSpreadSheets(this.workbook);
    }

    public void setString(String expression){
        this.searchResult=searchService.getCellInfoString(cellList,expression);
    }

    public String getString(){
        return this.searchResult;
    }





}
