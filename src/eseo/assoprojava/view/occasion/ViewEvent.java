package eseo.assoprojava.view.occasion;

import java.awt.BorderLayout;

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
		JPanel eventPanel = new JPanel();
		JPanel planPanel = new JPanel();
		JPanel coordPanel = new JPanel();

		coordPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		
		mainEventPanel.add(eventPanel,BorderLayout.WEST);
		mainEventPanel.add(planPanel,BorderLayout.CENTER);
		mainEventPanel.add(coordPanel,BorderLayout.EAST);
		
		MainWindow.getInstance().getWorkPanel().add(mainEventPanel,BorderLayout.NORTH);
		
		JPanel activitiesPanel = new JPanel();
		MainWindow.getInstance().getWorkPanel().add(activitiesPanel,BorderLayout.CENTER);
		
		ViewGpsCoord viewGpsCoord = new ViewGpsCoord(event.getPlace().getGpsCoord());
		viewGpsCoord.show(coordPanel);
	}
	
}
