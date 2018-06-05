package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1150503.ExportPDF;

/*import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pt.isep.nsheets.shared.core.Spreadsheet;
import java.io.FileOutputStream;
import java.util.Date;*/

import pt.isep.nsheets.shared.core.Workbook;

/**
 * @author Gonçalo Fonseca <1150503@isep.ipp.pt>
 */
public class ExportPdfController {

    /*private String FILE;
    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);


    public ExportPdfController() {
        FILE = "../PDF.pdf";
    }

    public void exportWorkbook(Workbook workbook) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addStuffToMetaData(document);
            addTitlePage(document);
            addContent(document, workbook);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addStuffToMetaData(Document document) {
        document.addTitle("Workbook on PDF");
        document.addSubject("LAPR4");
        document.addKeywords("lapr4, pdf, export, algorithm, hardwork, willThisBeEvenChecked, AristaNetworks is a great buy!");
        document.addAuthor("Gonçalo Fonseca");
        document.addCreator("Gonçalo Fonseca");
    }

    private void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Export to PDF", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date()));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("This document is your workbook in PDF Format ", smallBold));
        addEmptyLine(preface, 8);
        document.add(preface);

    }

    private static void createTable(Section section, Workbook workbook) {

        int size = workbook.getSpreadsheetCount();


        for(int x = 0; x < size; x++) {
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

                    if (y < col-1) section.add(table);
                    if (k < row-1) section.add(table);
                }
            }
        }

    }

    private void addContent(Document document, Workbook workbook) {
        Chapter chapter = new Chapter(new Paragraph(" "), 0);
        Section section = chapter.addSection(new Paragraph(" "));
        document.newPage();
        createTable(section, workbook);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }*/

    public void exportWorkbook(Workbook workbook) {

    }



}
