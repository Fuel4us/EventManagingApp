/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1140317.services;

import java.io.Serializable;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.AddressDTO;

@SuppressWarnings("serial")
public class CellCommentDTO implements Serializable {
    public AddressDTO address;
    public String txtComment;
    
    
    
     public CellCommentDTO(AddressDTO address, String[] values){
        this.address = address;
        try{
            txtComment= values[0];
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    
    public CellCommentDTO(){
        
    }
    
        public String[] getValues(){
        String[] values = new String[1];
        values[0] = txtComment;

        return values;
    }
    
}
