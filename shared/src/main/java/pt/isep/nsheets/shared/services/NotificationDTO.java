package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NotificationDTO implements Serializable {

    private String username;
    private String text;

    public NotificationDTO(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public NotificationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

}
