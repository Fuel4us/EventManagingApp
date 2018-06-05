/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.ext.SpreadsheetExtension;
import pt.isep.nsheets.shared.lapr4.red.s1.core.n1161292.services.SpreadsheetDTO;

/**
 *
 * @author Berccar
 */
public class StylableSpreadsheet extends SpreadsheetExtension {
    
    /** The unique version identifier used for serialization */
	private static final long serialVersionUID = -302349897603798290L;

	/** The width of the columns in the spreadsheet */
	private Map<Integer, Integer> columnWidths = new HashMap<Integer, Integer>();

	/** The heights of the rows in the spreadsheet */
	private Map<Integer, Integer> rowHeights = new HashMap<Integer, Integer>();

	/** The spans of cells in the spreadsheet */
	@SuppressWarnings("unused")
	private Map<Address, Address> cellSpans = new HashMap<Address, Address>();

	/*
	 * Possible additions:
	 * - Cell spanning
	 * - Grid visiblity (horizontal and vertical)
	 * - Grid color
	 * - Cell margin
	 */

	/**
	 * Creates a stylable cell spreadsheet for the given spreadsheet.
	 * @param spreadsheet the spreadsheet to extend
	 */
	protected StylableSpreadsheet(Spreadsheet spreadsheet) {
		super(spreadsheet, StyleExtension.NAME);
	}

	/**
	 * Returns the height of the given row.
	 * @param row the index of the row
	 * @return the height of the given row, or -1 if the default height applies
	 */
	public int getRowHeight(int row) {
		Integer height = rowHeights.get(row);
		if (height != null)
			return height;
		else
			return -1;
	}

	/**
	 * Sets the height of the given row.
	 * @param row the index of the row
	 * @param height the height of the row
	 */
	public void setRowHeight(int row, int height) {
		rowHeights.put(row, height);
	}

	/**
	 * Returns the width of the given column.
	 * @param column the index of the column
	 * @return the width of the given column, or -1 if the default width applies
	 */
	public int getColumnWidth(int column) {
		Integer width = columnWidths.get(column);
		if (width != null)
			return width;
		else
			return -1;
	}

	/**
	 * Sets the width of the given column.
	 * @param column the index of the column
	 * @param width the width of the column
	 */
	public void setColumnWidth(int column, int width) {
		columnWidths.put(column, width);
	}

    @Override
    public SpreadsheetDTO toDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
