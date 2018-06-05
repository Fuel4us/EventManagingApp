/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style.ui;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import pt.isep.nsheets.shared.ext.UIExtension;
import pt.isep.nsheets.shared.ext.style.StylableCell;
import pt.isep.nsheets.shared.ext.style.StyleExtension;

/**
 *
 * @author Berccar
 */
public class AlignTopAction extends StyleAction {
    
    /**
	 * Creates a new align top action.
	 * @param uiController the user interface controller
	 */
	public AlignTopAction(UIExtension uiController) {
		super(uiController);
	}

	protected String getName() {
		return "Top Align";
	}

	protected void defineProperties() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_T);
		putValue(SMALL_ICON, new ImageIcon(StyleExtension.class.getResource("res/img/align_top.gif")));
	}

	/**
	 * Aligns the content of the given cell to the top.
	 * @param cell the cell to which style should be applied
	 */
	protected void applyStyle(StylableCell cell) {
		cell.setVerticalAlignment(SwingConstants.TOP);
	}

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
