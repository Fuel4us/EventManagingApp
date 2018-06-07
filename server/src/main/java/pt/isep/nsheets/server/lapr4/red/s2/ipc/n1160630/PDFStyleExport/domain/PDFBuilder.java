/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author pedromonteiro
 */
public class PDFBuilder {
    
    private Workbook workbook;
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private final String FILE_PATH = "../PDF.pdf";
    private final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

    public PDFBuilder(Workbook workbook) {
        this.workbook = workbook;
    }
    
    private void createTable(Section section) {

        int size = workbook.getSpreadsheetCount();


        for (int x = 0; x < size; x++) {
            Spreadsheet spreadsheet = workbook.getSpreadsheet(x);

            int row = spreadsheet.getRowCount();
            int col = spreadsheet.getColumnCount();

            PdfPTable table = new PdfPTable(col);
            PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            for (int y = 0; y < row; y++) {
                for (int k = 0; k < col; k++) {
                    table.addCell(spreadsheet.getCell(y, k).getContent());

                    if (y < col - 1) section.add(table);
                    if (k < row - 1) section.add(table);
                }
            }
        }

    }

    public boolean exportWorkbook() {
        try {
            
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE_PATH));
            document.open();
            fillMetaInfo(document);
            addTitlePage(document);
            addContent(document);
            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void fillMetaInfo(Document document) {
        document.addTitle("PDF exporter");
        document.addSubject("LAPR4");
        document.addKeywords("lapr4,2DB, pdf, export, algorithm, hardwork");
        document.addAuthor("LAPR4 2DB PDF GENERATOR");
        document.addCreator("LAPR4 2DB PDF GENERATOR");
    }

    private void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Export to PDF", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Report generated by: Gonçalo Fonseca " + new Date()));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("This document is your workbook in PDF Format ", smallBold));
        addEmptyLine(preface, 8);
        preface.add(new Paragraph("Workbook:" + workbook.name(), smallBold));
        addEmptyLine(preface, 9);
        preface.add(new Paragraph("Subject:" + workbook.description(), smallBold));
        document.add(preface);

    }

    private void addContent(Document document) {
        Chapter chapter = new Chapter(new Paragraph(" "), 0);
        Section section = chapter.addSection(new Paragraph(" "));
        document.newPage();
        createTable(section);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
    
}
