package eseo.assoprojava.view.occasion;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.ui.MainWindow;

public class ViewGpsCoord {
	private final GpsCoord gpsCoord;
	
	public ViewGpsCoord(GpsCoord gpsCoord) {
		this.gpsCoord = gpsCoord;
	}
	
	public GpsCoord getGpsCoord() {
		return gpsCoord;
	}
	
	public void show() {
		JPanel panel = MainWindow.getInstance().getWorkPanel();
		
		JLabel jlabel = new JLabel("This is a label");
	    panel.add(jlabel);
	}

}
