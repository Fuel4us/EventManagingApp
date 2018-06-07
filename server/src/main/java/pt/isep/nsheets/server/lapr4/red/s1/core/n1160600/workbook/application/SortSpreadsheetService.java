package pt.isep.nsheets.server.lapr4.red.s1.core.n1160600.workbook.application;

import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.AddressDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

public class SortSpreadsheetService {

    public SpreadsheetDTO sortCells(String stringCell1, String stringCell2, SpreadsheetDTO spreadSheet, boolean ascendant) {
        stringCell2 = stringCell2.trim();
        stringCell1 = stringCell1.trim();
        Spreadsheet sheet = SpreadsheetImpl.fromDTO(spreadSheet);
//        if (stringCell1.length() < 2 || stringCell2.length() < 2) {
//            throw new IllegalArgumentException("cell references do not possess enough information");
//        }
        Address addr1 = new Address(stringCell1);
        Address addr2 = new Address(stringCell2);
        int column1 = addr1.getColumn();
        int column2 = addr2.getColumn();
        int row1 = addr1.getRow();
        int row2 = addr2.getRow();
        int startColumn = column1 <= column2 ? column1 : column2;
        int endColumn = column1 <= column2 ? column2 : column1;
        int startRow = row1 <= row2 ? row1 : row2;
        int endRow = row1 <= row2 ? row2 : row1;
        if (endRow >= spreadSheet.rows || endColumn >= spreadSheet.columns) {
            throw new IndexOutOfBoundsException("Sheet doesn't have those many cells ");
        }

        String auxValue;
//        AddressDTO address;
//        AddressDTO address2;
        for (int i = startColumn; i <= endColumn; i++) {
            for (int j = startRow; j <= endRow - 1; j++) {
                for (int k = j + 1; k <= endRow; k++) {
                    CellDTO dto1 = spreadSheet.getCell(j,i);
                    CellDTO dto2 = spreadSheet.getCell(k,i);
                            
                    if ((dto1.content.compareTo(dto2.content) > 0) == ascendant) {
                        auxValue = dto1.content;
                        dto1.content = dto2.content;
                        dto2.content = auxValue;
                    }
                }
            }
        }
//        String auxValue;
//        for (int i = startColumn; i <= endColumn; i++) {
//            for (int j = startRow; j <= endRow - 1; j++) {
//                for (int k = j + 1; k <= endRow; k++) {
//                    CellDTO dto1 = spreadSheet.getCell(j, i);
//                    CellDTO dto2 = spreadSheet.getCell(k, i);
//                    if ((sheet.getCell(i, j).getValue().compareTo(sheet.getCell(i, k).getValue()) > 0) == ascendant) {
//                        auxValue = dto1.content;
//                        dto1.content = dto2.content;
//                        dto2.content = auxValue;
//                        
//                    }
//                }
//            }
//        }
        return spreadSheet;
    }

}
