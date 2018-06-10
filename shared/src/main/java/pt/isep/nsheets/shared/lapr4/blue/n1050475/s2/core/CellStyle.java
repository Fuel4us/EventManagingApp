package pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CellStyle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @OneToOne
    Address address;
    private int backgroungColor;
    private int fontColor;
    private int textALIGN; //-1 - left, 0-center, 1 - right
    private int fontSize;

    public CellStyle(){

    }

    public CellStyle(Address address) {
        this.address = address;
        this.backgroungColor = Color.WHITE.ordinal();
        this.fontColor = Color.BLACK.ordinal();
        this.textALIGN = 0;
        this.fontSize = 12;
    }

    public CellStyle(Address address, int[] values){
        this.address = address;
        try{
            this.backgroungColor=values[0];
            this.fontColor=values[1];
            this.textALIGN=values[2];
            this.fontSize=values[3];
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public CellStyle(Address address, int v1, int v2, int v3, int v4){
        this.address = address;
        try{
            this.backgroungColor=v1;
            this.fontColor=v2;
            this.textALIGN = v3;
            this.fontSize = v4;
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }


    public int getBackgroungColor() {
        return backgroungColor;
    }

    public void setBackgroungColor(int backgroungColor) {
        this.backgroungColor = backgroungColor;
    }

    public int getFontColor() {
        return fontColor;
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }

    public int getTextALIGN(){ return textALIGN;};

    public int getFontSize(){
        return fontSize;
    }

    public void setTextALIGN(int textALIGN){
        this.textALIGN = textALIGN;
    }

    public void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }

    public Address getAddress(){
        return this.address;
    }


    public CellStyleDTO toDTO(){
        int[] values =new int[2];
        values[0]=backgroungColor;
        values[1]=fontColor;
        values[2]=textALIGN;
        values[3]=fontSize;

        return new CellStyleDTO(this.address.toDTO(), values);
    }

    public static CellStyle fromDTO(CellStyleDTO dto){
        int[] values =new int[2];
        values[0]=dto.backgroungColor;
        values[1]=dto.fontColor;
        values[2]=dto.textALIGN;
        values[3]=dto.fontSize;
        return new CellStyle(Address.fromDTO(dto.address), values);
    }
}