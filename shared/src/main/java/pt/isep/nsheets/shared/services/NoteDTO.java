package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pedro Marques Vieira
 */
@SuppressWarnings("serial")
public class NoteDTO implements Serializable {

    private String titleNote;
    private String textNote;
    private Date dateNote;

    /**
     * 
     * @param titleNote must be non-null
     * @param textNote in case of null, it is initialized as empty String
     * @throws IllegalArgumentException
     */
    public NoteDTO(String titleNote, String textNote) throws IllegalArgumentException {
        if (titleNote == null) {
            throw new IllegalArgumentException("title of the Note must be non-null");
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
    public NoteDTO() {
    }

    /**
     *
     * @return
     */
    public String getTitleNote() {
        return this.titleNote;
    }

    /**
     *
     * @return
     */
    public String getTextNote() {
        return this.textNote;
    }

    /**
     *
     * @return
     */
    public Date getDateNote() {
        return this.dateNote;
    }

    /**
     * It updates the date of the Note automatically
     * @param titleNote
     */
    public void changeTitleNote(String titleNote) {
        this.titleNote = titleNote;
        this.dateNote = new Date();
    }

    /**
     * It updates the date of the Note automatically
     * @param textNote
     */
    public void changeTextNote(String textNote) {
        this.textNote = textNote;
        this.dateNote = new Date();
    }

}
