package pt.isep.nsheets.server.lapr4.red.s1.core.n1160629.export.application;

import pt.isep.nsheets.shared.core.Workbook;

import java.io.*;

public class ExportCSLController {

    public boolean exportWorkbook(Workbook workbook) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ficheiro.csl"));
            oos.writeObject(workbook);
            oos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
