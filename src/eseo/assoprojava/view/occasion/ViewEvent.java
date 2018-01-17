package eseo.assoprojava.view.occasion;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.ui.MainWindow;

public class ViewEvent {
private final Event event;
	
	public ViewEvent(Event event) {
		this.event = event;
		MainWindow.getInstance().getWorkPanel().setViewEvent(this);
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void show() {
		JPanel mainEventPanel = new JPanel();
		JPanel eventPanel = new JPanel(new GridBagLayout());
		JPanel placePanel = new JPanel(new GridBagLayout());
		JPanel coordPanel = new JPanel(new GridBagLayout());

		coordPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		
		mainEventPanel.add(eventPanel,BorderLayout.WEST);
		mainEventPanel.add(placePanel,BorderLayout.CENTER);
		mainEventPanel.add(coordPanel,BorderLayout.EAST);
		
		MainWindow.getInstance().getWorkPanel().add(mainEventPanel,BorderLayout.NORTH);
		
		JPanel activitiesPanel = new JPanel();
		MainWindow.getInstance().getWorkPanel().add(activitiesPanel,BorderLayout.CENTER);
		
		ViewPlace viewPlace = new ViewPlace(event.getPlace());
		viewPlace.show(placePanel);
		
		ViewGpsCoord viewGpsCoord = new ViewGpsCoord(event.getPlace().getGpsCoord());
		viewGpsCoord.show(coordPanel);
		
		
	}
	
}
