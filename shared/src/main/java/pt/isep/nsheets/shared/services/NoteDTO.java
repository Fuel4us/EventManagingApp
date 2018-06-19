package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pedro Marques Vieira
 */
@SuppressWarnings("serial")
public class NoteDTO implements Serializable {

    private String titleNote;
    private String textNote;
    private Date dateNote;
    private Long id;
    private List<Boolean> activeCheckBox;
    
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
        this.id = null;
        activeCheckBox = new ArrayList<>();
    }
    
    public NoteDTO(String titleNote, String textNote, Long id) throws IllegalArgumentException {
        if (titleNote == null) {
            throw new IllegalArgumentException("title of the Note must be non-null");
        }
        this.titleNote = titleNote;
        
        if(textNote == null)
            this.textNote = "";
        else
            this.textNote = textNote;
        
        this.dateNote = new Date();
        this.id = id;
        activeCheckBox = new ArrayList<>();
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

    public List<Boolean> getActiveCheckBox() {
        return activeCheckBox;
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
    
    public void setCheckBoxValue(int i,Boolean value){
        activeCheckBox.set(i, value);
    }
    
    public NoteDTO clone(){
        return new NoteDTO(titleNote, textNote,this.id);
    }
    
    public Long getID(){
        return id;
    }

}
