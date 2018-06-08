/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author pedromonteiro
 */
public class PDFBuilder {

    private Workbook workbook;
    private final Font TABLE_FONT = FontFactory.getFont(FontFactory.HELVETICA, 6, Font.NORMAL, BaseColor.BLACK);
    private final Font SUB_FONT = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    private final String FILE_PATH = "../PDF.pdf";
    private final Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static final BaseColor DEFAULT_COLOR = new BaseColor(66, 165, 245);
    private static final BaseColor TITLE_COLOR = new BaseColor(224,224,224);
    private final BaseColor tableColor = DEFAULT_COLOR;

    public PDFBuilder(Workbook workbook) {
        this.workbook = workbook;
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
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

                    if (y < col - 1) {
                        section.add(table);
                    }
                    if (k < row - 1) {
                        section.add(table);
                    }
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
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
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
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Workbook: " + workbook.name(), SUB_FONT));
        preface.add(new Paragraph("Subject: " + workbook.description(), SUB_FONT));
        addEmptyLine(preface, 2);
        document.add(preface);
    }
    
    private void addSubjectInfo(Document document, Spreadsheet ss) throws DocumentException {
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph("Spreadsheet: "+ss.getTitle(), SUB_FONT));
        addEmptyLine(preface, 1);
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

    public boolean createPdf(CellStyle cellStyle) {
        try {

            Spreadsheet ss;
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(FILE_PATH));
            document.open();
            PdfPTable table;
            PdfPCell cell;
            
            addTitlePage(document);

            for (int k = 0; k < workbook.getSpreadsheetCount(); k++) {

                ss = workbook.getSpreadsheet(k);
                char letter = 'A';
                table = new PdfPTable(ss.getColumnCount() + 1);
                
                addSubjectInfo(document,ss);

                for (int firstLine = -1; firstLine < ss.getColumnCount(); firstLine++) {

                    if (firstLine < 0) {
                        cell = new PdfPCell(new Phrase("", TABLE_FONT));
                        letter--;
                    } else {
                        cell = new PdfPCell(new Phrase(String.valueOf(letter), TABLE_FONT));
                    }
                    cell.setBackgroundColor(TITLE_COLOR);
                    cell.setBorder(Rectangle.BOTTOM + Rectangle.RIGHT);
                    cell.setBorderColor(DEFAULT_COLOR);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setMinimumHeight(25);
                    cell.setBorderWidth(1);
                    table.addCell(cell);
                    letter++;
                }

                for (int i = 0; i < ss.getRowCount(); i++) {
                    cell = new PdfPCell(new Phrase(String.valueOf(i + 1), TABLE_FONT));
                    cell.setBackgroundColor(TITLE_COLOR);
                    cell.setBorder(Rectangle.BOTTOM + Rectangle.RIGHT);
                    cell.setBorderColor(DEFAULT_COLOR);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setMinimumHeight(20);
                    cell.setBorderWidth(1);
                    table.addCell(cell);
                    for (int j = 0; j < ss.getColumnCount(); j++) {
                        cell = new PdfPCell(new Phrase(ss.getCell(j, i).getContent().toUpperCase(), TABLE_FONT));
                        cell.setBackgroundColor(BaseColor.WHITE);
                        cell.setBorder(Rectangle.NO_BORDER);
                        cell.setBorderColor(DEFAULT_COLOR);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorderWidth(1);
                        cell.setCellEvent(chooseCellEvent(cellStyle, PdfPCell.RIGHT | PdfPCell.BOTTOM, tableColor));
                        cell.setMinimumHeight(20);
                        table.addCell(cell);
                    }
                }
                table.setWidthPercentage(110);
                document.add(table);
            }
            document.close();
            return true;
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    private PdfPCellEvent chooseCellEvent(CellStyle style, int value, BaseColor color){
        switch(style){
            case DASHED:
                return new DashedCell(value, color);
                
            case DOTTED:
                return new DottedCell(value, color);
        }
        
        return null;
    }

}
