/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.util.ExpressionVisitor;

/**
 *
 * @author Leandro
 */
public class GlobalVariable extends Literal implements Expression{
    
    String gvName;
    
    /**
     *
     * @param gvValue
     */
    public GlobalVariable(Value gvValue, String gvName) {
        super(gvValue);
        this.gvName = gvName;
    }

    public String getGvName() {
        return gvName;
    }

    public void setGvName(String gvName) {
        this.gvName = gvName;
    }
}
