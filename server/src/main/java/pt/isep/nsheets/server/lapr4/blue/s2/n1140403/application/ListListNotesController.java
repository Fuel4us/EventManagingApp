/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s2.n1140403.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.blue.s2.n1140403.domain.ListNotes;

/**
 *
 * @author Tiago Correia
 */
public class ListListNotesController implements Controller {

    /**
     *
     * @return
     */
    public Iterable<ListNotes> listListNotes() {
        return new ListNotesService().allListNotes();
    }
}
