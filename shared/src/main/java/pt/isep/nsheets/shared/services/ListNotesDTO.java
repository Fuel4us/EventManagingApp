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
 * @author Tiago Correia
 */

@SuppressWarnings("serial")
public class ListNotesDTO implements Serializable{
    
    private String titleNote;
    private String textNote;
    private Date dateNote;

    /**
     * 
     * @param titleNote must be non-null
     * @param textNote in case of null, it is initialized as empty String
     * @throws IllegalArgumentException
     */
    public ListNotesDTO(String titleNote, String textNote) throws IllegalArgumentException {
        if (titleNote == null) {
            throw new IllegalArgumentException("title of the ListNote must be non-null");
        }
        this.titleNote = titleNote;
        
        if(textNote == null)
            this.textNote = "";
        else
            this.textNote = textNote;
        
        this.dateNote = new Date();
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable!
     */
    public ListNotesDTO() {
    }

    /**
     * Method that returns the title of the ListNotes
     * @return
     */
    public String getTitleNote() {
        return this.titleNote;
    }

    /**
     * Method that returns the text of the ListNotes
     * @return
     */
    public String getTextNote() {
        return this.textNote;
    }

    /**
     * Method that returns the date of the ListNotes
     * @return
     */
    public Date getDateNote() {
        return this.dateNote;
    }

    /**
     * Method that allows the change of the title of the ListNotes
     * @param titleNote
     */
    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
        this.dateNote = new Date();
    }

    /**
     * Method that allows the change of the text of the ListNotes
     * @param textNote
     */
    public void setTextNote(String textNote) {
        this.textNote = textNote;
        this.dateNote = new Date();
    }
}
