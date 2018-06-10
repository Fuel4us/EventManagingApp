/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.application;

import eapli.framework.application.Controller;
import java.io.ByteArrayOutputStream;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain.PDFBuilder;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.WorkbookDTO;

/**
 *
 * @author pedromonteiro
 */
public class ExportStyledPDFController implements Controller{
    
    public boolean buildPDF(WorkbookDTO workbookDTO, String style,String color){
        PDFBuilder pdfFile = new PDFBuilder(Workbook.fromDTO(workbookDTO));
        return pdfFile.createPdf(style,color);
    }
    
}
