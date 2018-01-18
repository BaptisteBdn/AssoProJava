package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import eseo.assoprojava.model.activity.Activity;
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
		List<Activity> listActivities = MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent().getActivities();
		
		System.out.println(listActivities);
		
		listActivities.remove(activity);
		
		System.out.println(listActivities);

		MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesScrollPane().setVisible(false);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getEvent().setActivities(listActivities);
		MainWindow.getInstance().getWorkPanel().getViewEvent().show();
		MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);
		MainWindow.getInstance().getWorkPanel().getViewEvent().getActivitiesScrollPane().setVisible(true);
	}

}
