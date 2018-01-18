package eseo.assoprojava.view.occasion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eseo.assoprojava.model.place.Place;
import eseo.assoprojava.view.ui.MainWindow;

public class ViewPlace {
private final Place place;
	
	public ViewPlace(Place place) {
		this.place = place;
	}
	
	public Place getGpsCoord() {
		return place;
	}
	
public void show(JPanel panel) {
	    
	    GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel title = new JLabel("Lieu");
        title.setFont(MainWindow.TITLE_FONT);
        
        panel.add(title, gbc);
        gbc.gridy++;
	    panel.add(createPane("Nom",createLabel(place.getName() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("A",createLabel(place.getNumber() + " " + place.getStreet() + ", " + place.getCity() + ", " + place.getState() + ", " + place.getCountry() + ", " + place.getPostalCode())),gbc);
	    gbc.gridy++;
	    
	    for(int i = 0; i < 3; i++) {
	    	JLabel nLabel = new JLabel(" ");
	    	panel.add(nLabel, gbc);
	    	gbc.gridy++;
	    }
	    
	    
	    
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
        JLabel tmpLabel = new JLabel(text + " : ");
        tmpLabel.setFont(MainWindow.DEFAUT_FONT);
        jPanel.add(tmpLabel, gbc);


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
		label.setFont(MainWindow.DEFAUT_FONT);
		return label;
		
	}

}
