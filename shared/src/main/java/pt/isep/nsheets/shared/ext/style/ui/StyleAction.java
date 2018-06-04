/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style.ui;

import java.awt.event.ActionEvent;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.ext.UIExtension;
import pt.isep.nsheets.shared.ext.style.StylableCell;
import pt.isep.nsheets.shared.ext.style.StyleExtension;

/**
 *
 * @author Berccar
 */
public abstract class StyleAction extends FocusOwnerAction {

    public Object focusOwner;
    
    /**
     * The user interface controller
     */
    protected UIExtension uiController;

    /**
     * Creates a new style action.
     *
     * @param uiController the user interface controller
     */
    public StyleAction(UIExtension uiController) {
        this.uiController = uiController;
    }

    /**
     * Applies the style to the selected cells in the focus owner table.
     *
     * @param event the event that was fired
     */
    public void actionPerformed(ActionEvent event) {
        /*if (focusOwner == null) {
            return;
        }

        // Aligns each selected cell
        for (Cell[] row : focusOwner.getSelectedCells()) {
            for (Cell cell : row) {
                StylableCell stylableCell = (StylableCell) cell.getExtension(
                        StyleExtension.NAME);
                applyStyle(stylableCell);
            }
        }

        uiController.setWorkbookModified(focusOwner.getSpreadsheet().getWorkbook());
        focusOwner.repaint();*/
    }

    /**
     * Applies the style to the given stylable cell
     *
     * @param cell the cell to which style should be applied
     */
    protected abstract void applyStyle(StylableCell cell);

}
