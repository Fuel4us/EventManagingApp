package pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Application;

import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;

import java.util.List;

public class SearchSpreadsheetController {
    private SearchService searchService;
    private List<SpreadsheetImpl> spreadsheetList;
    private List<CellImpl> cellList;
    private String searchResult;

    public SearchSpreadsheetController(){
        searchService = new SearchService();
    }

    public void setSpreadsheetList(String name){
        this.spreadsheetList=searchService.getSpreadSheetsByWorkBookName(name);
    }

    public void setCellList(){
        this.cellList=searchService.getCellsFromSpreadSheets(this.spreadsheetList);
    }

    public void setString(String expression){
        this.searchResult=searchService.getCellInfoString(cellList,expression);
    }

    public String getString(){
        return this.searchResult;
    }





}
