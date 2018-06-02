package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain;

import eapli.framework.domain.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CalendarEvent implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long pk;

    String name;
    String description;
    Date date;
    Integer duration;

    public CalendarEvent(String name, String description, Date date, Integer duration) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.duration = duration;
    }

    public CalendarEvent() {
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof CalendarEvent)) {
            return false;
        }

        final CalendarEvent that = (CalendarEvent) other;
        if (this == that) {
            return true;
        }
        if (!this.name.equals(that.name)) {
            return false;
        }
        if (!this.description.equals(that.description)) {
            return false;
        }
        if (!this.date.equals(that.date)) {
            return false;
        }
        if (!this.duration.equals(that.duration)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }
}
