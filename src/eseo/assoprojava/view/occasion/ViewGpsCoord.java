package eseo.assoprojava.view.occasion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
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
	    System.out.println(panel);
	    panel.setViewGpsCoord(this);
	    
	    JButton button = new JButton("Test");
		button.setMargin(new Insets(2, 2, 2, 2));
		button.getPreferredSize();
		button.setForeground(Color.BLACK);
		button.setBackground(Color.LIGHT_GRAY);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		button.setBorder(compound);
		button.addActionListener(null);
		panel.add(button);
	   
	    
	}

}
