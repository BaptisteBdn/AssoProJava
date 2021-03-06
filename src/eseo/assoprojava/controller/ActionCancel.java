package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.view.ui.MainWindow;

/**
 * @author baptiste
 */

public class ActionCancel extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;

	public ActionCancel()
	{
		super();
	}
	
	/**
	 * Close the current FormWindow and enable buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainWindow.getCurrentFormWindow().setVisible(false);
		MainWindow.getInstance().getToolsPanel().enableButtons();
	}

}
