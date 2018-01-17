package eseo.assoprojava.view.occasion;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.ui.MainWindow;
import eseo.assoprojava.view.ui.panels.WorkPanel;

public class ViewGpsCoord {
	private final GpsCoord gpsCoord;
	
	public ViewGpsCoord(GpsCoord gpsCoord) {
		this.gpsCoord = gpsCoord;
	}
	
	public GpsCoord getGpsCoord() {
		return gpsCoord;
	}
	
	public void show() {
	    WorkPanel panel = MainWindow.getInstance().getWorkPanel();
	    panel.setViewGpsCoord(this);
	    
	    panel.add(createLabel(gpsCoord.getLatitude() + ""));
	    panel.add(createLabel(gpsCoord.getLongitude() + ""));
	    panel.add(createLabel(gpsCoord.getLatitudeDegree() + ""));
	    panel.add(createLabel(gpsCoord.getLatitudeMinute() + ""));
	    panel.add(createLabel(gpsCoord.getLatitudeSecond() + ""));
	    panel.add(createLabel(gpsCoord.getLongitudeDegree() + ""));
	    panel.add(createLabel(gpsCoord.getLongitudeMinute() + ""));
	    panel.add(createLabel(gpsCoord.getLongitudeSecond() + ""));
	    
	}
	
	public JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.getPreferredSize();
		label.setForeground(Color.BLACK);
		label.setBackground(Color.LIGHT_GRAY);
		Border line = label.getBorder();
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		label.setBorder(compound);
		
		System.out.println(label);
		return new JLabel(text);
		
	}

}
