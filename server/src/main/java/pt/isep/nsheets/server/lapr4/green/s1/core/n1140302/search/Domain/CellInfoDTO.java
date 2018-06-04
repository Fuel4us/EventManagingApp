package pt.isep.nsheets.server.lapr4.green.s1.core.n1140302.search.Domain;

import pt.isep.nsheets.shared.core.Value;

public class CellInfoDTO {

    private int row;
    private int column;
    private Value value;
    private String content;

    public CellInfoDTO(int row, int column, Value value, String content) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.content = content;
    }
}
