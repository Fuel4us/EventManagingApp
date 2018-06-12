package pt.isep.nsheets.server.lapr4.blue.n1050475.s2.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.blue.n1050475.s2.persistence.CellStyleRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.extensions.CellStyleExtension;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;

import java.util.ArrayList;
import java.util.Iterator;

public class CellStyleController implements Controller {

    public CellStyleController(){
    }

    public CellStyle addCellStyle(CellStyleDTO cellStyleDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        final CellStyleRepository cellstyleRepository = PersistenceContext.repositories().cellstyle();

        CellStyle cellStyle = CellStyle.fromDTO(cellStyleDTO);
        Iterable<CellStyle> cellStyles = loadCellStyleFromDatabase();
        for(CellStyle c : cellStyles){
            if(c.getAddress().equals(cellStyle.getAddress())){
                cellstyleRepository.removeCellStyle(c); // maybe it works maybe not
            }
        }

        cellstyleRepository.save(cellStyle);

        //CellStyleExtension.removeCellStyle(CellStyleExtension.getCellStyle(address));

        return cellStyle;
    }

    public Iterable<CellStyle> loadCellStyleFromDatabase() {
        final CellStyleRepository cellStyleRepository = PersistenceContext.repositories().cellstyle();

        return cellStyleRepository.findAll();
    }
}

/*
        , ,\/\/\
        , |\|\|`     :
        .-.|`            \
        \-\                \
        \                  \
        \          ____ ,-^-.
        \       ,'    `.   o\            You accessed my controller, now my soul is naked!
        \     (    o  :    ;
        \     \      ;`-"' )
        \_    `-..-'   -'(
        ,'a`               \
        `._,'   ,           )
        \   '`----=-----'
        ;       ,-'
        /        \
        ,'          \
        ;             \
        '    ,        \ \
        /    /    .    .) \
        :    /           \  \
        ;   |;            \  :
        ;   |              | |
        \   |          .   | :
        )   \             ,' |
        ,    )  ,---------|_;;
        (_/ //   |CENSURADO|
        `' |   |_________|
        |     ; |    |
        |     | |    |
        -hrr- |     |,'    `-._
        |     `-._    `..)
        |       `.;""---`
        `--._;_)-'
*/