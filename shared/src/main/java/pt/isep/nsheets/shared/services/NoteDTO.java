package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Pedro Marques Vieira
 */
@SuppressWarnings("serial")
public class NoteDTO implements Serializable {
	
	private String titleNote;
	private String textNote;
	
	public NoteDTO(String titleNote, String textNote) {
		this.titleNote=titleNote;
		this.textNote=textNote;		
	}

	// It is mandatory to have a default constructor with no arguments to be serializable!
	public NoteDTO() {
		this.titleNote="";
		this.textNote="";
	}
	
	public String getTitleNote() {
		return this.titleNote;
	}

	public String getTextNote() {
		return this.textNote;
	}
}
