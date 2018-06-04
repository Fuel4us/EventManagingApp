package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConditionalDTO implements Serializable{
    private Value conditionValue;
    private String conditionOperator;

    public ConditionalDTO(Value conditionValue, String conditionOperator){
        this.conditionValue = conditionValue;
        this.conditionOperator = conditionOperator;
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public ConditionalDTO() {
    }

    public Conditional fromDTO(){
        return new Conditional(conditionValue, conditionOperator);
    }

    public Value getConditionValue() {
        return this.conditionValue;
    }

    public String getConditionOperator() {
        return this.conditionOperator;
    }
}