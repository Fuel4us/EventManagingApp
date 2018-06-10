package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Formula;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.AddressDTO;

import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class CellDTOAux implements Serializable {

    private AddressDTO address;
    private Value value;
    private String content;
    private Formula formula;
    private Set<CellDTOAux> precedents;
    private Set<CellDTOAux> dependents;

    public CellDTOAux(AddressDTO address, Value value, String content, Formula formula, Set<CellDTOAux> precedents, Set<CellDTOAux> dependents) {
        this.address = address;
        this.value = value;
        this.content = content;
        this.formula = formula;
        this.precedents = precedents;
        this.dependents = dependents;
    }

}
