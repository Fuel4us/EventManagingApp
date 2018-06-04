/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style.ui;

import javax.swing.AbstractAction;
import static javax.swing.Action.ACTION_COMMAND_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.JOptionPane;

/**
 *
 * @author Berccar
 */
public abstract class BaseAction extends AbstractAction {
    
    
	/**
	 * Creates a new base action.
	 */
	public BaseAction() {
		// Configures action
		String name = getName();
		putValue(NAME, name);
		putValue(SHORT_DESCRIPTION, name);
		putValue(ACTION_COMMAND_KEY, name);
		defineProperties();
	}

	/**
	 * Returns the action's name.
	 * @return the action's name, which is used as short description and action command
	 */
	protected abstract String getName();

	/**
	 * Defines the action's properties.
	 */
	protected void defineProperties() {}

	/**
	 * Returns whether the action requires the active workbook to be
	 * modified in order to be enabled. By default, the method returns false.
	 * @return whether the action should be enabled
	 */
	protected boolean requiresModification() {
		return false;
	}

	/**
	 * Returns whether the action requires the active workbook to be
	 * stored in a file in order to be enabled. By default, the method
	 * returns false.
	 * @return whether the action should be enabled
	 */
	protected boolean requiresFile() {
		return false;
	}

	/**
	 * Shows the user an error message.
         * @param message message
	 */
	protected void showErrorDialog(Object message) {
		JOptionPane.showMessageDialog(
			null,
			message,
			"Error",
			JOptionPane.ERROR_MESSAGE
		);
	}
    
}
