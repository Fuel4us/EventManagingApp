package pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Application;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Domain.CellInfoDTO;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookRepository;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    final WorkbookRepository workbookRepository = PersistenceContext.repositories().workbooks();

    public SearchService(){

    }

    public List<CellImpl> getCellsFromSpreadSheets(List<SpreadsheetImpl> spreadsheets){
        List<CellImpl> cellList = new ArrayList<>();
        for (SpreadsheetImpl spreadSheet:
             spreadsheets) {
            while(spreadSheet.iterator().hasNext()){
                CellImpl cell = (CellImpl) spreadSheet.iterator().next();
                cellList.add(cell);
            }
        }
        return cellList;
    }

    public List<SpreadsheetImpl> getSpreadSheetsByWorkBookName(String name){
        return workbookRepository.getSpreadSheetByWorkbookName(name);
    }

    public List<CellInfoDTO> getCellInfoFromEntityCell(List<CellImpl> cellList){
        List<CellInfoDTO> cellInfoDTOList = new ArrayList<>();
        for (CellImpl cell:
             cellList) {
            CellInfoDTO cellInfoDto = new CellInfoDTO(cell.getAddress().getRow(), cell.getAddress().getColumn(),cell.getValue(),cell.getContent());
            cellInfoDTOList.add(cellInfoDto);
        }

        return cellInfoDTOList;
    }
}
