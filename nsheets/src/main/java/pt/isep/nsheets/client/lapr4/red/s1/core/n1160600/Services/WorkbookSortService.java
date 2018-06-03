/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.red.s1.core.n1160600.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

/**
 *
 * @author joao reis
 */
public class WorkbookSortService {

    public static void sortCells(String stringCell1, String stringCell2, Spreadsheet spreadSheet, boolean ascendant) throws IllegalValueTypeException, FormulaCompilationException {
        stringCell2 = stringCell2.trim();
        stringCell1 = stringCell1.trim();

        if (stringCell1.length() < 2 || stringCell2.length() < 2) {
            throw new IllegalArgumentException("cell references do not possess enough information");
        }
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
        String auxValue;
        for (int i = startColumn; i < endColumn; i++) {
            Cell[] aux = spreadSheet.getColumn(i);
            for (int j = startRow; j < endRow; j++) {
                for (int k = j - 1; k >= startRow; k++) {
                    System.out.println(aux[i].getContent());
                    if ((aux[j].getValue().compareTo(aux[k].getValue()) > 0) == ascendant) {
                        System.out.println("");
                        auxValue = aux[j].getContent();
                        aux[j].setContent(aux[k].getContent());
                        aux[k].setContent(auxValue);
                    }
                }
            }
        }
    }
}
