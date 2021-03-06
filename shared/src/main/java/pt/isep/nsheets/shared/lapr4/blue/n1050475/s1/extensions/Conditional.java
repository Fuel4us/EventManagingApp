package pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.ext.extensions.lapr4.red.s1.core.n1160629.Configuration;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.services.ConditionalDTO;

import javax.persistence.*;
import java.io.Serializable;
import pt.isep.nsheets.shared.core.CellImpl;

@Entity
public class Conditional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @OneToOne (targetEntity = CellImpl.class)
    private Cell cell;
    @OneToOne
    private Configuration configuration;
    private String condOperator;
    private Value condValue;

    public Conditional(){

    }

    public Conditional(Cell cell, Configuration configuration, String condOperator, Value condValue){
        this.cell = cell;
        this.configuration = configuration;
        this.condOperator = condOperator;
        this.condValue = condValue;
    }
    public Cell getCell(){ return cell;}

    public Configuration getConfiguration() {
        return configuration;
    }

    public Value getCondValue() {
        return condValue;
    }

    public String getCondOperator() {
        return this.condOperator;
    }

    public ConditionalDTO toDTO(){
        return new ConditionalDTO(this.cell.toDTO(), this.configuration, this.condOperator,this.condValue);
    }
    public static Conditional fromDTO(ConditionalDTO dto){
        return new Conditional(CellImpl.fromDTO(dto.cell), dto.configuration, dto.condOperator, dto.condValue);
    }
    
    public Long getId() {
        return this.pk;
    }
}
