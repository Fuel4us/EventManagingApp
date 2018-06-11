package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import pt.isep.nsheets.server.lapr4.blue.n1050475.s2.persistence.CellStyleRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCellStyleRepository extends NSheetsJpaRepositoryBase<CellStyle, Long> implements CellStyleRepository {

    JpaCellStyleRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public CellStyle findByAddress(Address address) {
        final Map<String, Object> params = new HashMap<>();
        params.put("address", address);

        return matchOne("e.address=:address", params);
    }




    @Override
    public void removeCellStyle(CellStyle cellStyle) {
            this.entityManager().getTransaction().begin();
            entityManager().createQuery("delete from CellStyle c where c.address=:addressid")
                    .setParameter("addressid", cellStyle.getAddress())
                    .executeUpdate();
            this.entityManager().getTransaction().commit();

    }


    @Override
    public CellStyle updateCellStyle(CellStyle cellStyle) {
        CellStyle style = findByAddress(cellStyle.getAddress());

        this.entityManager().getTransaction().begin();
        style.setBackgroungColor(cellStyle.getBackgroungColor());
        style.setFontColor(cellStyle.getFontColor());
        style.setFontSize(cellStyle.getFontSize());
        style.setTextALIGN(cellStyle.getTextALIGN());
        this.entityManager().getTransaction().commit();
        return null;
    }
}
