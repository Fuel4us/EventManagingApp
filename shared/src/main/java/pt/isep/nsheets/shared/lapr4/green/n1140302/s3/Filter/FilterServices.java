package pt.isep.nsheets.shared.lapr4.green.n1140302.s3.Filter;

import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.application.Settings;
import pt.isep.nsheets.shared.core.*;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

import java.util.SortedSet;

public class FilterServices {

    public FilterServices(){

    }

    public int getRowToRemove(String address1, String address2, int index, int value,WorkbookDTO workbookDto)  {
        Address ad1 = new Address(address1);
        Address ad2 = new Address(address2);

        Workbook workbook = Workbook.fromDTO(workbookDto);

        SortedSet<Cell> rangeCells = workbook.getSpreadsheet(0).getCells(ad1,ad2);


        for(Cell c : rangeCells){
            CellImpl cell = (CellImpl)workbook.getSpreadsheet(0).getCell(new Address(c.toString()));
            if(!seeIfTrue(index,cell,value)){
                return cell.getAddress().getRow();
            }
        }
        return -1;
    }

    public boolean seeIfTrue(int index,CellImpl cell,int value) {
        if(Character.isDigit(cell.getContent().charAt(0))) {
            int aux = Integer.parseInt(cell.getContent());
            switch (index) {
                case 0:
                    return aux == value;
                case 1:
                    return aux > value;
                case 2:
                    return aux < value;
                case 3:
                    return aux >= value;
                case 4:
                    return aux <= value;
                case 5:
                    return aux != value;
            }
        }
        return true;
    }


}
