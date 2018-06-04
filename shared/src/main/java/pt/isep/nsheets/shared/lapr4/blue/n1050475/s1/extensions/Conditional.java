package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions;

import pt.isep.nsheets.shared.core.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Conditional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    private Value conditionValue;
    private String conditionOperator;

    public Conditional(Value conditionValue, String conditionOperator){
        this.conditionValue = conditionValue;
        this.conditionOperator = conditionOperator;
    }

    public Conditional(){
        //ORM
    }

    public String getConditionOperator() {
        return conditionOperator;
    }

    public Value getConditionValue() {
        return conditionValue;
    }
}
