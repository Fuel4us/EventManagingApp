/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Leandro
 */
@SuppressWarnings("serial")
public class MessagesDTO implements Serializable{
    
    private String text;
    private Date date;
    private String user;

    public MessagesDTO(String text, Date date, String user) {
        this.text = text;
        this.date = date;
        this.user = user;
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
    
}
