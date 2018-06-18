package pt.isep.nsheets.server.lapr4.red.s1.core.n1160634.notes.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.shared.services.NoteDTO;

/**
 *
 * @author Pedro Marques Vieira
 */
@Entity
public class Note implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    private String titleNote;
    private String textNote;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNote;

    /**
     *
     * @param titleNote must be non-null
     * @param textNote in case of null, it is initialized as empty String
     * @throws IllegalArgumentException
     */
    public Note(String titleNote, String textNote) throws IllegalArgumentException {
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

    /**
     * It is mandatory to have a default constructor with no arguments to be
     * serializable and for ORM!
     */
    protected Note() {
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

    @Override
    public String toString() {
        return "Note{" + "titleNote=" + titleNote + ", textNote=" + textNote + ", dateNote=" + dateNote + '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Note)) {
            return false;
        }

        final Note that = (Note) other;
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
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    /**
     *
     * @return
     */
    public NoteDTO toDTO() {
        return new NoteDTO(this.titleNote, this.textNote, this.id());
    }

    /**
     *
     * @param noteDTO
     * @return
     * @throws IllegalArgumentException
     */
    public static Note fromDTO(NoteDTO noteDTO) throws IllegalArgumentException {
        return new Note(noteDTO.getTitleNote(), noteDTO.getTextNote());
    }

}
