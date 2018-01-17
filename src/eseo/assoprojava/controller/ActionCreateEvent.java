package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;

public class ActionCreateEvent extends javax.swing.AbstractAction {

	public static final String NOM_ACTION = "Nouveau";
	
	public ActionCreateEvent(){
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Yes");		
	}

}
