package pt.isep.nsheets.server.lapr4.blue.n1150372.s3.domain;

import java.util.List;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain.PDFBuilder;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class CompletePDFBuiler extends PDFBuilder {

    public CompletePDFBuiler(List<CellStyleDTO> list, Workbook workbook) {
        super(list, workbook);
    }

}
