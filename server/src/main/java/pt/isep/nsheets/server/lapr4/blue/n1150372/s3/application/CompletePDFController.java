package pt.isep.nsheets.server.lapr4.blue.n1150372.s3.application;

import eapli.framework.application.Controller;
import java.util.List;
import pt.isep.nsheets.server.lapr4.blue.n1150372.s3.domain.CompletePDFBuilder;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author Pedro Alves 1150372@isep.ipp.pt
 */
public class CompletePDFController implements Controller{

    /**
     * Call the PDF Builder, to build the pdf.
     *
     * @param listOptions
     * @param list cell style list
     * @param workbookDTO workbook
     * @param style line style (dashed/dotted/solid/double)
     * @param color line color
     * @param range line width
     * @return
     */
    public boolean buildPDF(List<Object> listOptions, List<CellStyleDTO> list, WorkbookDTO workbookDTO, String style, String color, int range) {
        CompletePDFBuilder pdfFile = new CompletePDFBuilder(listOptions, list, Workbook.fromDTO(workbookDTO));
        return pdfFile.createPdf(style, color, range);
    }
}
