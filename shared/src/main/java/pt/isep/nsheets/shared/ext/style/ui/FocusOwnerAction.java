/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style.ui;

import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Berccar
 */
public abstract class FocusOwnerAction extends BaseAction implements PropertyChangeListener {
    
    /** The current focus owner */
	//protected SpreadsheetTable focusOwner;

	/**
	 * Creates a new focus owner action.
	 */
	public FocusOwnerAction() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
			.addPropertyChangeListener("permanentFocusOwner", this);
	}

	/**
	 * Stores the focus owner
	 * @param event the event that was fired
	 */
	/*public void propertyChange(PropertyChangeEvent event) {
		Object o = event.getNewValue();
		if (o instanceof SpreadsheetTable)
			focusOwner = (SpreadsheetTable)o;
	}*/
    
}
