/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1160557.s2.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;

/**
 *
 * @author Hilario Coelho
 */
public class CellRangeDTO implements Serializable {
    public List<CellDTO> list;
    
    public CellRangeDTO(List<CellDTO> list) {
        this.list = list;
    }
    
    public CellRangeDTO() {
        this.list = new ArrayList<>();
    }
    
    public void addCell(CellDTO cell) {
        this.list.add(cell);
    }
    
    public List<CellDTO> getCells() {
        return this.list;
    }
}
