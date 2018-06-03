package pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services;

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
    public SortedSet<CellDTO> precedents;
    public SortedSet<CellDTO> dependents;
    
    protected CellDTO() {}
    
    public CellDTO(AddressDTO address, String content, 
            SortedSet<CellDTO> precedents, SortedSet<CellDTO> dependents){
        this.address = address;
        this.content = content;
        this.precedents = precedents;
        this.dependents = dependents;
    }
}
