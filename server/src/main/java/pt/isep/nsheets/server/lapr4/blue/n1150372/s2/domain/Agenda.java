package pt.isep.nsheets.server.lapr4.blue.n1150372.s2.domain;

import com.google.gwt.dev.util.collect.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class Agenda {

    @Id
    @GeneratedValue
    private Long pk;

    private String name;

    private String descrição;

    private User user;

    @ManyToOne
    private Set<CalendarEvent> listEvents = new HashSet<>();

    public Agenda(String name, String descrição, User user) {
        this.name = name;
        this.descrição = descrição;
        this.user = user;
    }

    public Agenda() {
    }

    public String getName() {
        return name;
    }

    public String getDescrição() {
        return descrição;
    }

    public Set<CalendarEvent> getListEvents() {
        return listEvents;
    }

    public Long getPk() {
        return pk;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setListEvents(Set<CalendarEvent> listEvents) {
        this.listEvents = listEvents;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Agenda{" + "name=" + name + ", descri\u00e7\u00e3o=" + descrição + ", user=" + user + ", listEvents=" + listEvents + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.pk);
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
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
        final Agenda other = (Agenda) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return Objects.equals(this.user, other.user);
    }

}
