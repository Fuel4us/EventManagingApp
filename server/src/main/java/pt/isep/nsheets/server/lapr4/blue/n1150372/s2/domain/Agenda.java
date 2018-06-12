package pt.isep.nsheets.server.lapr4.blue.n1150372.s2.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161140.calendar.domain.CalendarEvent;
import pt.isep.nsheets.shared.services.AgendaDTO;
import pt.isep.nsheets.shared.services.CalendarEventDTO;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class Agenda {

    @Id
    @GeneratedValue
    private Long pk;

    private String name;

    private String description;

//    private User user;
    @ManyToOne
    private Set<CalendarEvent> listEvents;

    public Agenda(String name, String descrição) {
        this.name = name;
        this.description = descrição;
//        this.user = user;
        this.listEvents = new HashSet<>();
    }

    public Agenda() {
        this.listEvents = new HashSet<>();
    }

    private Agenda(String name, String description, HashSet<CalendarEvent> listEvents) {
        this.name = name;
        this.description = description;
//        this.user = user;
        this.listEvents = listEvents;
    }

    public Long id() {
        return pk;
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
        return true;
    }

    public AgendaDTO toDTO() {
        HashSet<CalendarEventDTO> listEventsDTO = getListEventsToDTO();
        return new AgendaDTO(this.name, this.description, listEventsDTO);
    }

    public static Agenda fromDTO(AgendaDTO dto) {
        HashSet<CalendarEvent> listEvents = getListEventsFromDTO(dto.getListEvents());
        return new Agenda(dto.getName(), dto.getDescription(), listEvents);
    }

    private HashSet<CalendarEventDTO> getListEventsToDTO() {
        HashSet<CalendarEventDTO> listEventsDTO = new HashSet<>();

        listEvents.forEach((calendarEvent) -> {
            listEventsDTO.add(calendarEvent.toDTO());
        });
        return listEventsDTO;
    }

    private static HashSet<CalendarEvent> getListEventsFromDTO(Set<CalendarEventDTO> ceDTO) {
        HashSet<CalendarEvent> listEvents = new HashSet<>();
        CalendarEvent ce;
        for (CalendarEventDTO calendarEventDTO : ceDTO) {
            ce = CalendarEvent.fromDTO(calendarEventDTO);
            listEvents.add(ce);
        }
        return listEvents;
    }

}
