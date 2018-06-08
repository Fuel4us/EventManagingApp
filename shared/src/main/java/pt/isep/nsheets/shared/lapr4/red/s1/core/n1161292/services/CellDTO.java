package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

import pt.isep.nsheets.shared.core.Value;

import java.io.Serializable;
import java.util.SortedSet;

/**
 *
 * @author Tiago João Santos Rios, 1161292@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class CellDTO implements Serializable {
    
    public AddressDTO address;
    public String content;
    public Value value;
    public SortedSet<CellDTO> precedents;
    public SortedSet<CellDTO> dependents;
    
    protected CellDTO() {}
    
    public CellDTO(AddressDTO address, String content,Value value,
            SortedSet<CellDTO> precedents, SortedSet<CellDTO> dependents){
        this.value=value;
        this.address = address;
        this.content = content;
        this.precedents = precedents;
        this.dependents = dependents;
    }
}
