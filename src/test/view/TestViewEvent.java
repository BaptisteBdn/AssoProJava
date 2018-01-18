package test.view;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import java.util.ArrayList;
import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.model.organiser.Organiser;
import eseo.assoprojava.model.place.Place;
import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.occasion.ViewEvent;
import eseo.assoprojava.view.ui.MainWindow;

public class TestViewEvent {
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		
		GpsCoord coord = new GpsCoord(65.21,-56.23);
		Place place = new Place(12, "rue crépon", "Angers", "Maine et Loire", "France", 49100, coord, "Bar du samedi");		
		Organiser organiser = new Organiser("Calvin", "Ageneau", "Alchoolo Eseo", "Chef");
		
		Activity activ1 = new Activity(new Date(), new Date(), "Boire", 0, 20, 2.5, "Le but est de boire", organiser);
		Activity activ2 = new Activity(new Date(), new Date(), "Parler", 2, 5, 0, "Le but est de parler", organiser);
		Activity activ3 = new Activity(new Date(), new Date(), "Danser", 0, 20, 0, "Le but est de danser", organiser);
		Activity activ4 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		Activity activ5 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		Activity activ6 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		Activity activ7 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		Activity activ8 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		Activity activ9 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		Activity activ10 = new Activity(new Date(), new Date(), "Jouer", 20, 60, 3.2, "Le but est de jouer", organiser);
		
		List<Activity> listActivs = new ArrayList<Activity>();
		listActivs.add(activ1);
		listActivs.add(activ2);
		listActivs.add(activ3);
		listActivs.add(activ4);
		listActivs.add(activ5);
		listActivs.add(activ6);
		listActivs.add(activ7);
		listActivs.add(activ8);
		listActivs.add(activ9);
		listActivs.add(activ10);
		
		Event event = new Event(place, new Date(), new Date(), "Grosse chouille", 0, 100, "Alchoolo Eseo", 30.5, listActivs, "Une grossse soirée de folie");
				ViewEvent viewEvent = new ViewEvent(event);
		viewEvent.show();

		mainWindow.setVisible(true);
	}
	

}
