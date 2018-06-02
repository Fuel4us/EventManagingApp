package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

public class CalendarEventDTO implements Serializable {

    String name;
    String description;
    Date date;
    Date time;
    Integer duration;

    public CalendarEventDTO(String name, String description, Date date, Date time, Integer duration) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
