package pt.isep.nsheets.server.lapr4.blue.n1150372.s2.domain;

import com.google.gwt.dev.util.collect.HashSet;
import java.util.Set;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class ListAgenda {

    private Set<Agenda> listAgendas = new HashSet<>();

    public boolean addAgenda(Agenda agenda) {
        return listAgendas.add(agenda);
    }

    public boolean removeAgenda(Agenda agenda) {
        return listAgendas.remove(agenda);
    }

    public Set<Agenda> getListAgendas() {
        return listAgendas;
    }

}
