package pt.isep.nsheets.server.lapr4.blue.n1150372.s2.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.services.AgendaDTO;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class CreateAgendaController {

    public void createAgenda(AgendaDTO dto) throws DataConcurrencyException, DataIntegrityViolationException {
        new AgendaService().addAgenda(dto);
    }

}
