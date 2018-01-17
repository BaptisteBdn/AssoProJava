package eseo.assoprojava.view.occasion;

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
		
	}
	
}
