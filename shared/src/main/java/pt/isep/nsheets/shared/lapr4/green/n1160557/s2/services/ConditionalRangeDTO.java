package pt.isep.nsheets.shared.lapr4.green.n1160557.s2.services;


import java.io.Serializable;
import java.util.List;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.CellDTO;

@SuppressWarnings("serial")
public class ConditionalRangeDTO implements Serializable {
    public CellRangeDTO cellList;
    public Configuration configuration;
    public String operator;
    public Value value;

    public ConditionalRangeDTO(CellRangeDTO list, Configuration configuration, String operator, Value value){
        this.cellList = list;
        this.configuration = configuration;
        this.operator = operator;
        this.value = value;
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public ConditionalRangeDTO() {
        this.cellList = new CellRangeDTO();
    }
    
    public void addCell(CellDTO cond) {
        this.cellList.addCell(cond);
    }
    
    public List<CellDTO> getCells() {
        return this.cellList.getCells();
    }
}