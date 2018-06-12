
package pt.isep.nsheets.server.lapr4.blue.s2.n1140403.domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain.Note;
import pt.isep.nsheets.shared.services.ListNotesDTO;
import pt.isep.nsheets.shared.services.NoteDTO;

/**
 *
 * @author Tiago Correia
 */
@Entity
public class ListNotes implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long primaryKey = null;
    private String titleNote;
    private String textNote;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNote;

    /**
     * Constructor
     * @param titleNote must be non-null
     * @param textNote in case of null, it is initialized as empty String
     * @throws IllegalArgumentException
     */
    public ListNotes(String titleNote, String textNote) throws IllegalArgumentException {
        if (titleNote == null) {
            throw new IllegalArgumentException("title of the Note must be non-null");
        }
        this.titleNote = titleNote;

        if (textNote == null) {
            this.textNote = "";
        } else {
            this.textNote = textNote;
        }

        this.dateNote = new Date();
    }
    
    public ListNotes(Note note){
        if (note.getTitleNote() == null) {
            throw new IllegalArgumentException("title of the Note must be non-null");
        }
        this.titleNote = note.getTitleNote();

        if (note.getTextNote() == null) {
            this.textNote = "";
        } else {
            this.textNote = note.getTextNote();
        }

        this.dateNote = note.getDateNote();
    }

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable and for ORM!
     */
    protected ListNotes() {
    }

    /**
     * Method that return the title of the ListNotes
     * @return
     */
    public String getTitleListNotes() {
        return this.titleNote;
    }

    /**
     * Method that return the text of the ListNotes
     * @return
     */
    public String getTextNote() {
        return this.textNote;
    }

    /**
     * Method that return the date of the ListNotes
     * @return
     */
    public Date getDateNote() {
        return dateNote;
    }

    /**
     * It updates the date of the Note automatically
     *
     * @param titleNote
     */
    public void changeTitleNote(String titleNote) {
        this.titleNote = titleNote;
        this.dateNote = new Date();
    }

    /**
     * It updates the date of the Note automatically
     *
     * @param textNote
     */
    public void changeTextNote(String textNote) {
        this.textNote = textNote;
        this.dateNote = new Date();
    }

    /**
     * Method that returns a string with the information of the ListNotes
     * @return 
     */
    @Override
    public String toString() {
        return "Note{" + "titleNote=" + titleNote + ", textNote=" + textNote + ", dateNote=" + dateNote + '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof ListNotes)) {
            return false;
        }

        final ListNotes that = (ListNotes) other;
        if (this == that) {
            return true;
        }
        if (!this.titleNote.equals(that.titleNote)) {
            return false;
        }

        if (!this.textNote.equals(that.textNote)) {
            return false;
        }

        return this.dateNote.equals(that.dateNote);
   }

    @Override
    public boolean is(Long id) {
        return (this.primaryKey.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.primaryKey;
    }

    /**
     *
     * @return
     */
    public ListNotesDTO toDTO() {
        return new ListNotesDTO(this.titleNote, this.textNote);
    }

    /**
     *
     * @param listNotesDTO
     * @return
     * @throws IllegalArgumentException
     */
    public static ListNotes fromDTO(ListNotesDTO listNotesDTO) throws IllegalArgumentException {
        return new ListNotes(listNotesDTO.getTitleNote(), listNotesDTO.getTextNote());
    }

}
