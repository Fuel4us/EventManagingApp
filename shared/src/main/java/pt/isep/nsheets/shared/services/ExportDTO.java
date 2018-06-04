package pt.isep.nsheets.shared.services;

import pt.isep.nsheets.shared.core.Workbook;

import java.io.Serializable;

/**
 *
 * @author Rúben (1160998)
 */
public class ExportDTO implements Serializable {
    private Workbook workbook;

    public ExportDTO(Workbook workbook) {
        this.workbook = workbook;
    }

    public ExportDTO() {
    }

    public Workbook getWorkbook() {
        return workbook;
    }
}
