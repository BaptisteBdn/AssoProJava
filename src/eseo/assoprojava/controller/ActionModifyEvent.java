package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.ui.FormWindow;
import eseo.assoprojava.view.ui.MainWindow;

public class ActionModifyEvent extends javax.swing.AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionModifyEvent()
	{
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Event event = MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent();
		FormWindow formWindow = new FormWindow(true,"Événement",event);
		formWindow.getFormPanel().setEvent(event);
		MainWindow.setCurrentFormWindow(formWindow);
		formWindow.pack();
		formWindow.setVisible(true);
	}

}
