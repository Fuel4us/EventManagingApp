package pt.isep.nsheets.shared.lapr4.green.n1160557.s2.services;

import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ConditionalRangeDTO implements Serializable{
    public List<ConditionalDTO> conditionalList;

    public ConditionalRangeDTO(List<ConditionalDTO> list){
        this.conditionalList = list;
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public ConditionalRangeDTO() {
        conditionalList = new ArrayList<>();
    }
    
    public void addConditional(ConditionalDTO cond) {
        this.conditionalList.add(cond);
    }
    
    public List<ConditionalDTO> getConditionals() {
        return this.conditionalList;
    }
}