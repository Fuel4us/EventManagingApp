/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * from https://stackoverflow.com/questions/13725198/how-can-a-user-download-a-file-in-client-side-google-web-toolkit
 *
 * @author pedromonteiro
 */
public class DownloadServelet extends HttpServlet {

    private final String FILE_PATH = "../PDF.pdf";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            ByteArrayOutputStream b= req.getInputStream();
//        ServletOutputStream out = resp.getOutputStream();
//        int BUFFER = 1024 * 100;
//        String reportContents = getServletContext().getServerInfo();
////for PDF
//        resp.setContentType("application/pdf");
//        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".pdf");
//for CVS files
//resp.setContentType("text/cvs"); 
//resp.setHeader(“Content-Disposition”, “attachment; filename=”+ fileName + “.csv”);
//for Word Document
//resp.setContentType(“text/doc”); 
//resp.setHeader(“Content-Disposition”, “attachment; filename=”+ fileName + “.doc”);
//        resp.setContentLength(Long.valueOf(reportContents.length()).intValue());
//        resp.setBufferSize(BUFFER);
//        out.write(reportContents.getBytes());
//        out.flush();
//        out.close();
//PDF Creation with iText
//            response.setHeader("Expires", "0");
//            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
//            response.setHeader("Pragma", "public");
//            response.setContentType("application/pdf");
//
//            response.setContentLength(byteArraysIZE.size());
//            OutputStream os = response.getOutputStream();
//            b.writeTo(os);
//            os.flush();
//            os.close();
//        } catch (DocumentException ex) {
//            Logger.getLogger(DownloadServelet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Cookie[] cookies = request.getCookies();
            // get cookies, generate PDF.
            // If PDF is generated to to temp file, read it
            byte[] bytes = getFile(FILE_PATH);
            sendPDF(response, bytes, FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(DownloadServelet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    byte[] getFile(String filename) {

        FileInputStream fis = null;
        try {
            byte[] bytes = null;
            java.io.File file = new java.io.File(filename);
            fis = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            try {
                fis.read(bytes);
            } catch (IOException ex) {
                Logger.getLogger(DownloadServelet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return bytes;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DownloadServelet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DownloadServelet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    void sendPDF(HttpServletResponse response, byte[] bytes, String name) throws IOException {
        ServletOutputStream stream = null;

        stream = response.getOutputStream();
        response.setContentType("application/pdf");
        response.addHeader("Content-Type", "application/pdf");
        response.addHeader("Content-Disposition", "attachment;filename=" + "Workbook.pdf");
        response.setContentLength((int) bytes.length);
        stream.write(bytes);
        stream.close();
    }

}
