package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

import eseo.assoprojava.view.ui.FormWindow;

public class ActionCreateActivity extends javax.swing.AbstractAction  {
	
	public ActionCreateActivity(){
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FormWindow formWindow = new FormWindow(false,"Activité");
		formWindow.pack();
		formWindow.setVisible(true);
	}
	
	
}
