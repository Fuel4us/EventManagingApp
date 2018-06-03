package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConfigurationDTO implements Serializable{
    private String bgColorPos;
    private String fgColorPos;
    private String bgColorNeg;
    private String fgColorNeg;

    public ConfigurationDTO(String[] values){
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
        String[] values = new String[4];
        values[0]=bgColorPos;
        values[1]=fgColorPos;
        values[2]=bgColorNeg;
        values[3]=fgColorNeg;
        return new Configuration(values);
    }

    public String getBgColorPos() {
        return bgColorPos;
    }

    public String getFgColorPos() {
        return fgColorPos;
    }

    public String getBgColorNeg() {
        return bgColorNeg;
    }

    public String getFgColorNeg() {
        return fgColorNeg;
    }
}
