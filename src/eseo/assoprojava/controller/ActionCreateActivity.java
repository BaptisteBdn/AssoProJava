package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.view.ui.FormWindow;
import eseo.assoprojava.view.ui.MainWindow;

public class ActionCreateActivity extends javax.swing.AbstractAction  {
	
	/**
	 * @author baptiste
	 */
	private static final long serialVersionUID = 1L;

	public ActionCreateActivity(){
		super();
	}
	
	/**
	 * Disable all the buttons and display a FormActivityPanel
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainWindow.getInstance().getToolsPanel().disableButtons();
		FormWindow formWindow = new FormWindow(false,"Activité",null);
		formWindow.getFormActivityPanel().setCreating(true);
		MainWindow.setCurrentFormWindow(formWindow);
		formWindow.pack();
		formWindow.setVisible(true);
	}
	
	
}
