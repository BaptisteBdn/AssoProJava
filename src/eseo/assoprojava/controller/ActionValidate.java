package eseo.assoprojava.controller;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.text.DateFormatter;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.model.place.Place;
import eseo.assoprojava.model.place.gps.GpsCoord;
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
			event.setDateBegin((Date) formPanel.getDateBeginField().getValue());
			event.setDateEnd((Date) formPanel.getDateEndField().getValue());
			event.setNumberMaximum(Integer.parseInt(formPanel.getNumberMaxField().getText()));
			event.setNumberMinimum(Integer.parseInt(formPanel.getNumberMinField().getText()));
//			event.setPlace(new Place(Integer.parseInt(formPanel.getPlaceNumberField().getText()),
//								 	formPanel.getPlaceStreetField().getText(),
//								 	formPanel.getPlaceCityField().getText(), 
//								 	formPanel.getPlaceStateField().getText(), 
//								 	formPanel.getPlaceCountryField().getText(), 
//								 	formPanel.getPlacePostalCodeField().getText(), 
//								 	new GpsCoord(getPlaceGPSField().getText()), 
//								 	formPanel.getPlaceNameField().getText()));
			//			event.setDateBegin(formPanel.getDateBeginField().getText());
//			event.setDateEnd(formPanel.getDateEndField().getText());
			MainWindow.getCurrentFormWindow().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(false);
			MainWindow.getInstance().getWorkPanel().getViewEvent().setEvent(event);
			MainWindow.getInstance().getWorkPanel().getViewEvent().show();
			MainWindow.getInstance().getWorkPanel().getViewEvent().getMainEventPanel().setVisible(true);

		}
		
		//TODO POPUP INCORECCT VALUE : DATE END
	}

}
