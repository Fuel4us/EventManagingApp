package pt.isep.nsheets.server.services;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * https://gist.github.com/kevzlou7979/2d97b81437760016cad8ecc9d74b8f7a
 */
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not a multipart request");
            return;
        }

        ServletFileUpload upload = new ServletFileUpload(); // from Commons

        try {
            FileItemIterator iter = upload.getItemIterator(request);

            if (iter.hasNext()) {
                FileItemStream fileItem = iter.next();

                ServletOutputStream out = response.getOutputStream();
                response.setBufferSize(32768);

                InputStream in = fileItem.openStream();
                // The destination of your uploaded files.
                File file = new File("./uploadedFiles/" + fileItem.getName());
                OutputStream outputStream = new FileOutputStream(file);

                int length = 0;
                byte[] bytes = new byte[1024];

                while ((length = in.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }

                response.setContentType("text/html");
                response.setContentLength((length > 0 && length <= Integer.MAX_VALUE) ? (int) length : 0);

                outputStream.close();
                in.close();
                out.flush();
                out.close();
            }
        } catch (Exception caught) {
            throw new RuntimeException(caught);
        }
    }
}
