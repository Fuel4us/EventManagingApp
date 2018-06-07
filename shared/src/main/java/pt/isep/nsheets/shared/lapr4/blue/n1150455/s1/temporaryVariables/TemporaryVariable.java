/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.n1150455.s1.temporaryVariables;

import java.util.Objects;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Literal;

/**
 *
 * @author João Pires 1150455@isep.ipp.pt>
 */
public class TemporaryVariable extends Literal {

    private Value name;

    public TemporaryVariable(Value value) {
        super(value);
    }

    public TemporaryVariable(Value value, Value name) throws IllegalValueTypeException {
        super(value);
        this.name = name;
    }

    public Value getName() {
        return name;
    }

    public void setContent(Value value) {
        super.setValue(value);
    }

    @Override
    public Value getValue() {
        return super.getValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TemporaryVariable other = (TemporaryVariable) obj;
        return Objects.equals(this.name, other.name);
    }

}
