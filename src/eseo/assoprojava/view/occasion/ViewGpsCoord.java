package eseo.assoprojava.view.occasion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import eseo.assoprojava.model.place.gps.GpsCoord;

public class ViewGpsCoord {
	private final GpsCoord gpsCoord;
	
	public ViewGpsCoord(GpsCoord gpsCoord) {
		this.gpsCoord = gpsCoord;
	}
	
	public GpsCoord getGpsCoord() {
		return gpsCoord;
	}
	
	public void show(JPanel panel) {
	    
	    GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
	    
	    panel.add(createPane("Latitude",createLabel(gpsCoord.getLatitude() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Longitude",createLabel(gpsCoord.getLongitude() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("LatitudeDegree",createLabel(gpsCoord.getLatitudeDegree() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("LatitudeMinute",createLabel(gpsCoord.getLatitudeMinute() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("LatitudeSecond",createLabel(gpsCoord.getLatitudeSecond() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("LongitudeDegree",createLabel(gpsCoord.getLongitudeDegree() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("LongitudeMinute",createLabel(gpsCoord.getLongitudeMinute() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("LongitudeSecond",createLabel(gpsCoord.getLongitudeSecond() + "")),gbc);
	    gbc.gridy++;
	    
	}
	
	private JPanel createPane(String text, JLabel jLabel){
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.white);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        jPanel.add(new JLabel(text + " : "), gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.BOTH;
        jPanel.add(jLabel, gbc);
        return jPanel;
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
		
		return new JLabel(text);
		
	}

}
