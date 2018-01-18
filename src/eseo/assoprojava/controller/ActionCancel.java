package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.view.ui.MainWindow;

public class ActionCancel extends javax.swing.AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionCancel()
	{
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainWindow.getCurrentFormWindow().setVisible(false);
	}

}
