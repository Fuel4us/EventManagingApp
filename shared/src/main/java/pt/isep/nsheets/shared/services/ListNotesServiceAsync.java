/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author Tiago Correia
 */
public interface ListNotesServiceAsync {

    /**
     *
     * @param callback
     */
    void getNotes(AsyncCallback<ArrayList<ListNotesDTO>> callback);

    /**
     *
     * @param ListNotesDTO
     * @param callback
     */
    void addNote(NoteDTO ListNotesDTO, AsyncCallback<ListNotesDTO> callback);

}
