/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.n1160815.formula.lang;

import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Literal;

/**
 *
 * @author Leandro
 */
public class GlobalVariable extends Literal{
    
    private Expression expression;
    
    public GlobalVariable(Value value) {
        super(value);
    }
    
    public void setContent(Expression expression) {
        this.expression = expression;
    }
    
}
