package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.ui.MainWindow;

public class ActionDeleteActivity extends javax.swing.AbstractAction {

	Activity activity;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionDeleteActivity(Activity activity)
	{
		super();
		this.activity = activity;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		// TODO Auto-generated method stub
		Event event = MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent();
		
		System.out.println(event.getActivities());
		
		event.getActivities().remove(activity);
		
		System.out.println(event.getActivities());

		MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(false);
		MainWindow.getInstance().getWorkPanel().getViewEvent().setEvent(event);
		MainWindow.getInstance().getWorkPanel().getViewEvent().show();
		MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesPanel().setVisible(true);
	}

}
