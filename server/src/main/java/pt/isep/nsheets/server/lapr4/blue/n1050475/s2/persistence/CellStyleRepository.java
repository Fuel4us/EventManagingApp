package pt.isep.nsheets.server.lapr4.blue.n1050475.s2.persistence;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import eapli.framework.persistence.repositories.Repository;

import java.util.Optional;

public interface CellStyleRepository extends Repository<CellStyle, Long> {

    public CellStyle findByAddress(Address adddress);

    public void removeCellStyle(CellStyle cellStyle);

    public CellStyle updateCellStyle(CellStyle cellStyle);
}
