package test.view;

import javax.swing.JFrame;

import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.model.place.Place;
import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.occasion.ViewEvent;
import eseo.assoprojava.view.ui.MainWindow;

public class TestViewEvent {
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		
		GpsCoord coord = new GpsCoord(65.21,-56.23);
		Place place = new Place(12, "rue crépon", "Angers", "Maine et Loire", "France", 49100, coord, "Bar du samedi");
		Event event = new Event(place, null, null, null, 0, 0, null, 0, null);
		
		ViewEvent viewEvent = new ViewEvent(event);
		viewEvent.show();
		
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TODO Get confirm ?
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
	

}
