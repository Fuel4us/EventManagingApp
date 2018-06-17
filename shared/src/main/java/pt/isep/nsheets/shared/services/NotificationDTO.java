package pt.isep.nsheets.shared.services;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NotificationDTO implements Serializable {

    private String username;
    private String sender;
    private String text;

    public NotificationDTO(String username, String from, String text) {
        this.username = username;
        this.sender = from;
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

    public String getSender() {
        return sender;
    }

}
