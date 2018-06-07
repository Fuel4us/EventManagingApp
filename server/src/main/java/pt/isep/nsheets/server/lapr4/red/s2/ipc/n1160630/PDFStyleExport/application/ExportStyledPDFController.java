/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.application;

import eapli.framework.application.Controller;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain.PDFBuilder;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author pedromonteiro
 */
public class ExportStyledPDFController implements Controller{
    
    public boolean buildPDF(Workbook wb){
        PDFBuilder pdfFile = new PDFBuilder(wb);
        return pdfFile.createPdf();
    }
    
}
