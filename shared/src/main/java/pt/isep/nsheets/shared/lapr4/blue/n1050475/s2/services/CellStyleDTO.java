package pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services;

import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.AddressDTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CellStyleDTO implements Serializable {
    public AddressDTO address;
    public int backgroungColor;
    public int fontColor;
    public int textALIGN;
    public int fontSize;

    public CellStyleDTO(AddressDTO address, int[] values){
        this.address = address;
        try{
            backgroungColor=values[0];
            fontColor=values[1];
            textALIGN=values[2];
            fontSize=values[3];
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public CellStyleDTO() {
    }

    public int[] getValues(){
        int[] values = new int[4];
        values[0] = backgroungColor;
        values[1] = fontColor;
        values[2] = textALIGN;
        values[3] = fontSize;
        return values;
    }
}