package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.view.ui.FormWindow;
import eseo.assoprojava.view.ui.MainWindow;

/**
 * @author baptiste
 */

public class ActionCreateEvent extends javax.swing.AbstractAction {
	
	private static final long serialVersionUID = 1L;

	public ActionCreateEvent(){
		super();
	}
	
	/**
	 * Disable all the buttons and display a FormEventPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainWindow.getInstance().getToolsPanel().disableButtons();
		FormWindow formWindow = new FormWindow(true,"Événement",null);
		formWindow.getFormEventPanel().setCreating(true);
		MainWindow.setCurrentFormWindow(formWindow);
		formWindow.pack();
		formWindow.setVisible(true);
	}

}
