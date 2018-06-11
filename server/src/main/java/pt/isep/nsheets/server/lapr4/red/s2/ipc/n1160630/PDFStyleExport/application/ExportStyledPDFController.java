/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.application;

import eapli.framework.application.Controller;
import java.util.List;
import java.util.Set;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain.PDFBuilder;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.core.CellStyle;
import pt.isep.nsheets.shared.lapr4.blue.n1050475.s2.services.CellStyleDTO;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author pedromonteiro
 */
public class ExportStyledPDFController implements Controller{
    
    public boolean buildPDF(List<CellStyleDTO> list, WorkbookDTO workbookDTO, String style,String color, int range){
        PDFBuilder pdfFile = new PDFBuilder(list,Workbook.fromDTO(workbookDTO));
        return pdfFile.createPdf(style,color, range);
    }
    
    public Iterable<CellStyle> getCellStyles(){
//        new CellStyle.all();
        return null;
    }
    
}
