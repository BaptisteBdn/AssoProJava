package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.view.ui.FormWindow;
import eseo.assoprojava.view.ui.MainWindow;

public class ActionCreateEvent extends javax.swing.AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionCreateEvent(){
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		FormWindow formWindow = new FormWindow(true,"Événement");
		MainWindow.setCurrentFormWindow(formWindow);
		formWindow.pack();
		formWindow.setVisible(true);
	}

}
