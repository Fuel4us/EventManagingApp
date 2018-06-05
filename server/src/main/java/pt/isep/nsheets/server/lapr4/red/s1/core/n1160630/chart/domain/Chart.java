/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.services.ChartDTO;

/**
 * The Chart Abstract Class.
 *
 * @author pedromonteiro
 */
@Entity
@Table (name="CHART")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISC")
public abstract class Chart implements Serializable, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public abstract ChartDTO toDTO();

    public abstract Address associatedCell();

    public abstract void generateChartValues(Spreadsheet spreadsheet);
    
    @Override
    public boolean sameAs(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chart other = (Chart) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
    
    

    @Override
    public boolean is(Long id) {
        return (this.id.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.id;
    }

    

}
