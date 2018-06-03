package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gonçalo Silva
 */
public class CalendarEventDTO implements Serializable {

    String name;
    String description;
    Date date;
    Integer duration;

    public CalendarEventDTO(String name, String description, Date date, Integer duration) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.duration = duration;
    }

    public CalendarEventDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
