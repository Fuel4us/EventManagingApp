package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Leandro, Pedro Vieira
 */
@SuppressWarnings("serial")
public class MessagesDTO implements Serializable{
    
    private String text;
    private Date date;
    private String user;
    private int chatIndex;

    public MessagesDTO(String text, Date date, String user, int chatIndex) {
        this.text = text;
        this.date = date;
        this.user = user;
        this.chatIndex = chatIndex;
    }
    
    // It is mandatory to have a default constructor with no arguments to be serializable!
    public MessagesDTO(){
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public int getChatIndex() {
        return chatIndex;
    }
    
}
