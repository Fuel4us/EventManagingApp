/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style;

import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.ext.Extension;

/**
 *
 * @author Berccar
 */
public class StyleExtension extends Extension{
    
    /** The name of the extension */
	public static final String NAME = "Style";

	/**
	 * Creates a new style extension.
	 */
	public StyleExtension() {
		super(NAME);
	}
        
        /**
	 * Makes the given spreadsheet stylable.
	 * @param spreadsheet the spreadsheet to extend
	 * @return a stylable spreadsheet
	 */
	public StylableSpreadsheet extend(Spreadsheet spreadsheet) {
		return new StylableSpreadsheet(spreadsheet);
	}

	/**
	 * Makes the given cell stylable.
	 * @param cell the cell to extend
	 * @return a stylable cell
	 */
        @Override
	public StylableCell extend(Cell cell) {
		return new StylableCell(cell);
	}
    
}
