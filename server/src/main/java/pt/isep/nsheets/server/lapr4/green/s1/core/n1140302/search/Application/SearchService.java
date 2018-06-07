package pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Application;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Domain.CellInfoDTO;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.AddressDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();

    public SearchService(){

    }

    public List<CellDTO> getCellsFromSpreadSheets(WorkbookDTO workbook){
        List<CellDTO> list = new ArrayList<>();

        for (SpreadsheetDTO s:
             workbook.spreadsheets) {
            for (AddressDTO adress:
                 s.cells.keySet()) {
                list.add(s.cells.get(adress));
            }
        }

        return list;
    }



    public String getCellInfoString(List<CellDTO> cellList, String expression){
        String str = "";

        for (CellDTO cell:
             cellList) {
            if(cell.content.toLowerCase().contains(expression.toLowerCase())|| cell.value.toString().toLowerCase().contains(expression.toLowerCase())){
                str+= "Cell Address : "+getLetterFromRow(cell.address.column)+(cell.address.row+1)+", Content: "+cell.content+"\n";
            }
        }
        return str;
    }

    public String getLetterFromRow(int column){
        if(column==0){
            return "A";
        }else if(column==1){
            return "B";
        }else if(column==2){
            return "C";
        }else if(column==3){
            return "D";
        }else if(column==4){
            return "E";
        }else if(column==1){
            return "F";
        }else {
            return "G";
        }
    }
}
