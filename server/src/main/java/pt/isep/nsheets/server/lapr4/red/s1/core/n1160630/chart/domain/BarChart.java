/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.red.s1.core.n1160630.chart.domain;

import java.util.Iterator;
import java.util.SortedSet;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.ChartDTO;
import pt.isep.nsheets.shared.services.ChartType;

/**
 * The Bar Chart Implementation.
 *
 * @author pedromonteiro
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorColumn(name = "BAR")
public class BarChart extends Chart {

    private String graph_name;
    private String[][] content;
    @OneToOne
    private Address firstCell;
    @OneToOne
    private Address lastCell;
    private boolean considerFirstField;
    private boolean isRow;
    @OneToOne
    private Address associatedCell;
    private static String BAR_CHART_NAME = "Bar Chart";

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Empty constructor.
     */
    protected BarChart() {
        //FOR ORM
    }

    public BarChart(ChartDTO dto) {
        this(dto.getFirstAddress(), dto.getLastAddress(), dto.isConsiderFirstField(), dto.isRow(), dto.getAssociatedCell());

        if (dto.getType() != ChartType.BAR_CHART) {
            throw new IllegalArgumentException("Cannot instantiate a " + dto.getType().name() + "in BarChart");
        }

        this.graph_name = dto.getGraph_name();
    }

    /**
     * The constructor with the following parameters:
     *
     * @param firstAddress First cell Address
     * @param lastAddress Last cell Address
     * @param considerFirstField consider first field content of the graph
     * @param isRow is based on row
     * @param associatedCell
     */
    public BarChart(Address firstAddress, Address lastAddress, boolean considerFirstField, boolean isRow, Address associatedCell) {
        this.graph_name = BAR_CHART_NAME;
        firstCell = firstAddress;
        lastCell = lastAddress;
        this.considerFirstField = considerFirstField;
        this.isRow = isRow;
        this.associatedCell = associatedCell;

    }

    /**
     * The constructor with the following parameters:
     *
     * @param graph_name Graph Name
     * @param firstAddress First cell Address
     * @param lastAddress Last cell Address
     * @param considerFirstField consider first field content of the graph
     * @param isRow is based on row
     * @param associatedCell
     */
    public BarChart(String graph_name, Address firstAddress, Address lastAddress, boolean considerFirstField, boolean isRow, Address associatedCell) {
        this(firstAddress, lastAddress, considerFirstField, isRow, associatedCell);
        this.graph_name = graph_name;
    }

    /**
     * Graph generator.
     *
     * @param spreadsheet
     */
    @Override
    public void generateChartValues(Spreadsheet spreadsheet) {

        int endCol = lastCell.getColumn();
        int startCol = firstCell.getColumn();
        int endRow = lastCell.getRow();
        int startRow = firstCell.getRow();

        endCol++; //Incrementes because col-2 is the 3rd column
        endRow++;

        if (spreadsheet == null) {
            spreadsheet = generateSpreadsheet();
            firstCell = new Address(0, 0);
            lastCell = new Address(2, 2);
        }

        associatedCell = spreadsheet.getCell(endCol, startRow).getAddress();

        Cell[] cells = cellSetToArray(spreadsheet.getCells(firstCell, lastCell));


        String values[][] = new String[endCol - startCol][endRow - startRow];
        int k = 0;
        for (int i = startCol; i < endCol; i++) {
            for (int j = startRow; j < endRow; j++) {
                values[i - startCol][j - startRow] = cells[k].getContent();
                k++;
            }
        }

        content = values;
    }

    /**
     * Tranforms a bar chart in a DTO Chart.
     *
     * @return Chart DTO
     */
    @Override
    public ChartDTO toDTO() {
        return new ChartDTO(graph_name, firstCell, lastCell, isRow, considerFirstField, ChartType.BAR_CHART, associatedCell, content);
    }

    @Override
    public Address associatedCell() {
        return associatedCell;
    }

    private Spreadsheet generateSpreadsheet() {
        String[][] contents = new String[][]{{"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}};
        Workbook wb = new Workbook("graph", "desc", contents);
        return wb.getSpreadsheet(0);
    }

    private Cell[] cellSetToArray(SortedSet<Cell> setCell) {

        Cell[] cells = new Cell[setCell.size()];
        int i = 0;

        Iterator iterator = setCell.iterator();

        while (iterator.hasNext()) {
            cells[i] = (Cell) iterator.next();
            i++;
        }

        return cells;
    }

}
