package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class AgendaDTO implements Serializable {

    private String name;

    private String description;
//
//    private User user;

    private Set<CalendarEventDTO> listEvents;

    public AgendaDTO(String name, String description, HashSet<CalendarEventDTO> listEvents) {
        this.name = name;
        this.description = description;
//        this.user = user;
        this.listEvents = listEvents;
    }

    public AgendaDTO(String name, String descrição) {
        this.name = name;
        this.description = descrição;
//        this.user = user;
        this.listEvents = new HashSet<>();
    }

    public AgendaDTO() {
        this.listEvents = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//    public User getUser() {
//        return user;
//    }
    public Set<CalendarEventDTO> getListEvents() {
        return listEvents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String descrição) {
        this.description = descrição;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }
    public void setListEvents(Set<CalendarEventDTO> listEvents) {
        this.listEvents = listEvents;
    }

    public boolean addEvents(CalendarEventDTO event) {
        return listEvents.add(event);
    }

    public boolean removeEvents(CalendarEventDTO event) {
        return listEvents.remove(event);
    }

    public boolean addEvent(CalendarEventDTO calendarDTOSelect) {
        for (CalendarEventDTO event : listEvents) {
            if (calendarDTOSelect.equals(event)) {
                return false;
            }
        }
        return listEvents.add(calendarDTOSelect);
    }

    public boolean removeEvent(CalendarEventDTO calendarDTOSelect) {
        for (CalendarEventDTO event : listEvents) {
            if (calendarDTOSelect.equals(event)) {
                return listEvents.remove(event);
            }
        }
        return false;
    }

}
