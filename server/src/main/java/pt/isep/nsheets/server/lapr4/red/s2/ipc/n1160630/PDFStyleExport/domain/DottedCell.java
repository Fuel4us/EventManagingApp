/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s2.ipc.n1160630.PDFStyleExport.domain;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;

/**
 *
 * @author pedromonteiro
 */
public class DottedCell implements PdfPCellEvent {
    private int border = 0;
    private final BaseColor color;
    private final int size;
    public DottedCell(int border, BaseColor color, int size) {
        this.border = border;
        this.color = color;
        this.size=size;
    }
    @Override
    public void cellLayout(PdfPCell cell, Rectangle position,
        PdfContentByte[] canvases) {
        PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
        canvas.saveState();
        canvas.setColorStroke(color);
        canvas.setLineDash(0, 4, 2);
        canvas.setLineWidth(size);
        if ((border & PdfPCell.TOP) == PdfPCell.TOP) {
            canvas.moveTo(position.getRight(), position.getTop());
            canvas.lineTo(position.getLeft(), position.getTop());
        }
        if ((border & PdfPCell.BOTTOM) == PdfPCell.BOTTOM) {
            canvas.moveTo(position.getRight(), position.getBottom());
            canvas.lineTo(position.getLeft(), position.getBottom());
        }
        if ((border & PdfPCell.RIGHT) == PdfPCell.RIGHT) {
            canvas.moveTo(position.getRight(), position.getTop());
            canvas.lineTo(position.getRight(), position.getBottom());
        }
        if ((border & PdfPCell.LEFT) == PdfPCell.LEFT) {
            canvas.moveTo(position.getLeft(), position.getTop());
            canvas.lineTo(position.getLeft(), position.getBottom());
        }
        canvas.stroke();
        canvas.restoreState();
    }
}
