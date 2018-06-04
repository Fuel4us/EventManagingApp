package pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629;

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

    private String bgColorPos;
    private String fgColorPos;
    private String bgColorNeg;
    private String fgColorNeg;

    public Configuration() {
        bgColorPos = "#ffffff";
        fgColorPos = "#000000";
        bgColorNeg = "#ffffff";
        fgColorNeg = "#000000";
    }

    public Configuration(String[] values){
        try{
            bgColorPos=values[0];
            fgColorPos=values[1];
            bgColorNeg=values[2];
            fgColorNeg=values[3];
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }



    public String getBgColorPos() {
        return bgColorPos;
    }

    public void setBgColorPos(String bgColorPos) {
        this.bgColorPos = bgColorPos;
    }

    public String getFgColorPos() {
        return fgColorPos;
    }

    public void setFgColorPos(String fgColorPos) {
        this.fgColorPos = fgColorPos;
    }

    public String getBgColorNeg() {
        return bgColorNeg;
    }

    public void setBgColorNeg(String nesBgColor) {
        this.bgColorNeg = nesBgColor;
    }

    public String getFgColorNeg() {
        return fgColorNeg;
    }

    public void setFgColorNeg(String fgColorNeg) {
        this.fgColorNeg = fgColorNeg;
    }

    public ConfigurationDTO toDTO(){
        String[] values =new String[4];
        values[0]=bgColorPos;
        values[1]=fgColorPos;
        values[2]=bgColorNeg;
        values[3]=fgColorNeg;

        return new ConfigurationDTO(values);
    }
}
