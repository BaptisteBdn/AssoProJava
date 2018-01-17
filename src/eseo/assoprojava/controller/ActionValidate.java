package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSeparatorUI;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.occasion.ViewEvent;
import eseo.assoprojava.view.ui.MainWindow;
import eseo.assoprojava.view.ui.panels.FormPanel;
import eseo.assoprojava.view.ui.panels.WorkPanel;

public class ActionValidate extends javax.swing.AbstractAction {
	
	private Activity activity;
	
	public ActionValidate()
	{
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(MainWindow.getCurrentFormWindow().isEvent()){
			Event event = new Event();
			FormPanel formPanel = MainWindow.getCurrentFormWindow().getFormPanel();
			event.setName(formPanel.getNameField().getText());
			event.setClubOrganiser(formPanel.getClubField().getText());
//			event.setDateBegin(formPanel.getDateBeginField().getText());
//			event.setDateEnd(formPanel.getDateEndField().getText());
			MainWindow.getCurrentFormWindow().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().setEvent(event);
			MainWindow.getInstance().getWorkPanel().getViewEvent().show();
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);

		}
	}

}
