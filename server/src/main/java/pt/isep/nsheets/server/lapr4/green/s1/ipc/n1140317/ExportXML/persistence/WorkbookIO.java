package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1140317.ExportXML.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Carlos Figueiredo (1140317)
 */
public interface WorkbookIO {
    
    public Workbook read(InputStream stream) throws IOException, ClassNotFoundException;

    public void write(List<String[][]> workbook, OutputStream stream) throws IOException;

    public void write(String[][] spreadsheet, OutputStream stream) throws IOException;

}

