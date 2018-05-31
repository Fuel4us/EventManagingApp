//package pt.isep.nsheets.server.lapr4.red.s1.core.1160634.notes.domain;
//
//import java.io.Serializable;
//import java.util.Objects;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//import eapli.framework.domain.AggregateRoot;
//
//import pt.isep.nsheets.shared.services.NoteDTO;
//
///**
// *
// * @author Pedro Marques Vieira
// */
//@Entity
//public class Note implements AggregateRoot<Long>, Serializable {
//
//    // ORM primary key
//    @Id
//    @GeneratedValue
//    private Long pk = null;
//
//    private String titleNote;
//    private String textNote;
//
//    public Note(String titleNote, String textNote) throws IllegalArgumentException {
//        if (titleNote == null || textNote == null) {
//            throw new IllegalArgumentException("title of the Note must be non-null");
//        }
//        this.titleNote = titleNote;
//        this.textNote = textNote;
//    }
//
//    // It is mandatory to have a default constructor with no arguments to be
//    // serializable and for ORM!
//    protected Note() {
//        this.titleNote = "";
//        this.textNote = "";
//    }
//
//    public String getTitleNote() {
//        return this.titleNote;
//    }
//
//    public String getTextNote() {
//        return this.textNote;
//    }
//
//    @Override
//    public String toString() {
//        if (this.titleNote == null) {
//            return super.toString();
//        } else {
//            return this.titleNote + " " + this.textNote;
//        }
//    }
//
//    @Override
//    public boolean sameAs(Object other) {
//        if (!(other instanceof Note)) {
//            return false;
//        }
//
//        final Note that = (Note) other;
//        if (this == that) {
//            return true;
//        }
//        if (!this.titleNote.equals(that.titleNote)) {
//            return false;
//        }
//        if (!this.textNote.equals(that.textNote)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean is(Long id) {
//        return (this.pk.compareTo(id) == 0);
//    }
//
//    @Override
//    public Long id() {
//        return this.pk;
//    }
//
//    public NoteDTO toDTO() {
//        return new NoteDTO(this.titleNote, this.textNote);
//    }
//
//    public static Note fromDTO(NoteDTO noteDTO) throws IllegalArgumentException {
//        return new Note(noteDTO.getTitleNote(), noteDTO.getTextNote());
//    }
//
//}
