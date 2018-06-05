package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160998.ExportCSV;

import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rúben (1160998)
 */
public class ExportCSVController {
    private final String CRLF = ",\r\n";
    private String delimiter = ",";

    public ExportCSVController() {
    }

    public void exportWorkbook(Workbook workbook) {
        try {
            String csvFile = "../CSV.csv";

            FileWriter writer = new FileWriter(csvFile);

            writer.append(workbook.name() + CRLF + workbook.description() + CRLF);

            for (int x = 0; x < workbook.getSpreadsheetCount(); x++) {
                Spreadsheet s = workbook.getSpreadsheet(x);

                int r_count = s.getRowCount();
                int c_count = s.getColumnCount();

                for (int y = 0; y < r_count; y++) {
                    for (int z = 0; z < c_count; z++) {
                        writer.append(s.getCell(y, z).getContent());

                        if (z < r_count - 1)
                            writer.append(delimiter);
                    }

                    if (y < c_count - 1)
                        writer.append(CRLF);
                }
            }

            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
