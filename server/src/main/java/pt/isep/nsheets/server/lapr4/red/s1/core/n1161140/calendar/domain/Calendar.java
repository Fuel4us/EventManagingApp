package pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain;

import eapli.framework.domain.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Calendar implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long pk;

    List<CalendarEvent> calendarEvents;

    public Calendar(List<CalendarEvent> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    public Calendar() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public boolean is(Long id) {
        return false;
    }

    @Override
    public Long id() {
        return null;
    }
}
