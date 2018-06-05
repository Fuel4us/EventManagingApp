/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.ext.style.ui;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import pt.isep.nsheets.shared.ext.UIExtension;

/**
 *
 * @author Berccar
 */
public class StyleMenu extends JMenu{
    
    /**
	 * Creates a new style menu.
	 * @param uiController the user interface controller
	 */
	public StyleMenu(UIExtension uiController) {
		super("Style");
		setMnemonic(KeyEvent.VK_S);

		// Adds alignment actions
		add(new AlignLeftAction(uiController));
		add(new AlignCenterAction(uiController));
		add(new AlignRightAction(uiController));
		addSeparator();
		add(new AlignTopAction(uiController));
		add(new AlignMiddleAction(uiController));
		add(new AlignBottomAction(uiController));
	}
    
}
