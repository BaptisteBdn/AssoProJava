package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.view.ui.FormWindow;
import eseo.assoprojava.view.ui.MainWindow;

/**
 * @author baptiste
 */

public class ActionModifyActivity extends javax.swing.AbstractAction {

	private Activity activity;
	
	private static final long serialVersionUID = 1L;

	public ActionModifyActivity(Activity activity)
	{
		super();
		this.activity = activity;
	}
	
	/**
	 * Disable all the buttons and open a FormActivityPanel initialized with an activity
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainWindow.getInstance().getToolsPanel().disableButtons();
		FormWindow formWindow = new FormWindow(false,"Activité", activity);
		formWindow.getFormActivityPanel().setCreating(false);
		MainWindow.setCurrentFormWindow(formWindow);
		formWindow.pack();
		formWindow.setVisible(true);
	}

}
