package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConfigurationDTO implements Serializable{
    private int bgColorPos;
    private int fgColorPos;
    private int bgColorNeg;
    private int fgColorNeg;

    public ConfigurationDTO(int[] values){
        try{
            bgColorPos=values[0];
            fgColorPos=values[1];
            bgColorNeg=values[2];
            fgColorNeg=values[3];
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public ConfigurationDTO() {
    }

    public Configuration fromDTO(){
        int[] values = new int[4];
        values[0]=bgColorPos;
        values[1]=fgColorPos;
        values[2]=bgColorNeg;
        values[3]=fgColorNeg;
        return new Configuration(values);
    }

    public int getBgColorPos() {
        return bgColorPos;
    }

    public int getFgColorPos() {
        return fgColorPos;
    }

    public int getBgColorNeg() {
        return bgColorNeg;
    }

    public int getFgColorNeg() {
        return fgColorNeg;
    }
}
