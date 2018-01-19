package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.ui.FormWindow;
import eseo.assoprojava.view.ui.MainWindow;

public class ActionModifyEvent extends javax.swing.AbstractAction {

	/**
	 * @author baptiste
	 */
	private static final long serialVersionUID = 1L;

	public ActionModifyEvent()
	{
		super();
	}
	
	/**
	 * Disable all the buttons and open a FormEventPanel initialized with an event
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainWindow.getInstance().getToolsPanel().disableButtons();
		Event event = MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent();
		FormWindow formWindow = new FormWindow(true,"Événement",event);
		formWindow.getFormEventPanel().setCreating(false);
		formWindow.getFormEventPanel().setEvent(event);
		MainWindow.setCurrentFormWindow(formWindow);
		formWindow.pack();
		formWindow.setVisible(true);
	}

}
