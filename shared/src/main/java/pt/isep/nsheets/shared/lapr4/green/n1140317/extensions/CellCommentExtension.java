/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1140317.extensions;

import java.util.ArrayList;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.ext.CellExtension;
import pt.isep.nsheets.shared.ext.Extension;
import pt.isep.nsheets.shared.lapr4.green.n1140317.core.CellComment;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public class CellCommentExtension extends Extension {
    
    public static ArrayList<CellComment> lstCellComment = new ArrayList<CellComment>();
    
    public CellCommentExtension(String name) {
        super(name);
    }
    
    public static CellComment getCellComment(Address address) {
        for(CellComment c : lstCellComment){
            if(c.getAddress().equals(address)){
                return c;
            }
        }
        return null;
    }
    
     public static boolean removeCellComment(CellComment cellComment) {
        return lstCellComment.remove(cellComment);
    }

   
}
