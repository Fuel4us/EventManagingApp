/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

/**
 *
 * @author Tiago Correia
 */
@RemoteServiceRelativePath("listNotesService")
public interface ListNotesService extends RemoteService {

    /**
     *
     * @return
     */
    ArrayList<ListNotesDTO> getNotes();

    /**
     *
     * @param listNotesDTO
     * @return
     * @throws DataException
     */
    NoteDTO addNote(ListNotesDTO listNotesDTO) throws DataException;
}
