package pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629;

import gwt.material.design.client.constants.Color;
import pt.isep.nsheets.shared.services.ConfigurationDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    private int bgColorPos;
    private int fgColorPos;
    private int bgColorNeg;
    private int fgColorNeg;

    public Configuration() {
        bgColorPos = Color.WHITE.ordinal();
        fgColorPos = Color.BLACK.ordinal();
        bgColorNeg = Color.WHITE.ordinal();
        fgColorNeg = Color.BLACK.ordinal();
    }

    public Configuration(int[] values){
        try{
            bgColorPos=values[0];
            fgColorPos=values[1];
            bgColorNeg=values[2];
            fgColorNeg=values[3];
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }



    public int getBgColorPos() {
        return bgColorPos;
    }

    public void setBgColorPos(int bgColorPos) {
        this.bgColorPos = bgColorPos;
    }

    public int getFgColorPos() {
        return fgColorPos;
    }

    public void setFgColorPos(int fgColorPos) {
        this.fgColorPos = fgColorPos;
    }

    public int getBgColorNeg() {
        return bgColorNeg;
    }

    public void setBgColorNeg(int nesBgColor) {
        this.bgColorNeg = nesBgColor;
    }

    public int getFgColorNeg() {
        return fgColorNeg;
    }

    public void setFgColorNeg(int fgColorNeg) {
        this.fgColorNeg = fgColorNeg;
    }

    public ConfigurationDTO toDTO(){
        int[] values =new int[4];
        values[0]=bgColorPos;
        values[1]=fgColorPos;
        values[2]=bgColorNeg;
        values[3]=fgColorNeg;

        return new ConfigurationDTO(values);
    }
}
