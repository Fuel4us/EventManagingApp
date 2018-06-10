/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain;

import pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1160630.services.CellStyle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author pedromonteiro
 */
public class PDFBuilder {

    private Workbook workbook;
    private final Font TABLE_FONT = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
    private final Font SUB_FONT = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
    private final Font SUB_FONT_WORK = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
    private final String FILE_PATH = "nsheets/src/main/webapp/resources/PDF.pdf";
    private final Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private final BaseColor TITLE_COLOR = new BaseColor(224, 224, 224);
    private BaseColor color;

    public PDFBuilder(Workbook workbook) {
        this.workbook = workbook;
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
    }

    private void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("WORKBOOK EXPORT", catFont));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Workbook: " + workbook.name(), SUB_FONT_WORK));
        preface.add(new Paragraph("Subject: " + workbook.description(), SUB_FONT));
        addEmptyLine(preface, 1);
        document.add(preface);
    }

    private void addSubjectInfo(Document document, Spreadsheet ss) throws DocumentException {
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph("Spreadsheet: " + ss.getTitle(), SUB_FONT));
        addEmptyLine(preface, 1);
        document.add(preface);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public boolean createPdf(String style, String s_color, int size) {

        CellStyle cellStyle = CellStyle.getCellStyleByValue(style);
        Color c = new ColorUtil(s_color).getColor();
        color = new BaseColor(c.getRed(), c.getGreen(), c.getBlue());

        try {

            Spreadsheet ss;
            Document document = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(document, new FileOutputStream(FILE_PATH));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }

            document.open();
            PdfPTable table;
            PdfPCell cell;

            addTitlePage(document);

            for (int k = 0; k < workbook.getSpreadsheetCount(); k++) {

                ss = workbook.getSpreadsheet(k);
                char letter = 'A';
                table = new PdfPTable(ss.getColumnCount() + 1);

                addSubjectInfo(document, ss);

                for (int firstLine = -1; firstLine < ss.getColumnCount(); firstLine++) {

                    if (firstLine < 0) {
                        cell = new PdfPCell(new Phrase("", TABLE_FONT));
                        letter--;
                    } else {
                        Font font = new Font(TABLE_FONT);
                        font.setStyle(Font.BOLD);
                        cell = new PdfPCell(new Phrase(String.valueOf(letter), font));
                    }

                    cell.setBackgroundColor(TITLE_COLOR);
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setCellEvent(chooseCellEvent(cellStyle, color, size));
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
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setCellEvent(chooseCellEvent(cellStyle, color, size));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setMinimumHeight(20);
                    cell.setBorderWidth(1);
                    table.addCell(cell);
                    for (int j = 0; j < ss.getColumnCount(); j++) {

                        Cell spread_cell = ss.getCell(j, i);

                        Font text_font = new Font(TABLE_FONT);

//                        StyleCell style_cell = spread_cell.style();
//
//                        if (style_cell != null) {
//                            String hex_back_color = ColorTranformer.getHexColorByGWTColor(style_cell.getBack_color());
//                            String hex_text_color = ColorTranformer.getHexColorByGWTColor(style_cell.getFont_color());
//
//                            if (hex_back_color != null && hex_back_color.length() > 0) {
//                                ColorUtil util_color = new ColorUtil(hex_back_color);
//                                cell.setBackgroundColor(new BaseColor(util_color.getColor().getRed(), util_color.getColor().getGreen(), util_color.getColor().getBlue()));
//                            } else {
//                                cell.setBackgroundColor(BaseColor.WHITE);
//                            }
//
//                            if (hex_text_color != null && hex_text_color.length() > 0) {
//                                ColorUtil util_color = new ColorUtil(hex_text_color);
//                                text_font.setColor(util_color.getColor().getRed(), util_color.getColor().getGreen(), util_color.getColor().getBlue());
//                            }
//                            
//                        }else{
                            cell.setBackgroundColor(BaseColor.WHITE);
//                        }

                        cell = new PdfPCell(new Phrase(spread_cell.getContent().toUpperCase(), text_font));
                        cell.setBorder(Rectangle.NO_BORDER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorderWidth(1);
                        cell.setCellEvent(chooseCellEvent(cellStyle, color, size));
                        cell.setMinimumHeight(20);
                        table.addCell(cell);
                    }
                }
                table.setWidthPercentage(110);
                document.add(table);
            }
            document.close();
            return true;
        } catch (DocumentException ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    private PdfPCellEvent chooseCellEvent(CellStyle style, BaseColor color, int size) {
        switch (style) {
            case DASHED:
                return new DashedCell(PdfPCell.RIGHT | PdfPCell.BOTTOM, color, size);
            case DOTTED:
                return new DottedCell(PdfPCell.RIGHT | PdfPCell.BOTTOM, color, size);
            case SOLID:
                return new SolidCell(PdfPCell.RIGHT | PdfPCell.BOTTOM, color, size);
            case DOUBLE:
                return new DoubleCell(PdfPCell.RIGHT | PdfPCell.BOTTOM, color, size);
        }

        return null;
    }

}
