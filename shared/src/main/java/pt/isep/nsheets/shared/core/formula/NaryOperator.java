/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;

/**
 *
 * @author Pedro Marques Vieira
 */
public interface NaryOperator extends Operator{
    
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException;
}
