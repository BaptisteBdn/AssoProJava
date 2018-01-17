package eseo.assoprojava.view.occasion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
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
		
		showEvent(eventPanel);
		
		ViewPlace viewPlace = new ViewPlace(event.getPlace());
		viewPlace.show(placePanel);
		
		ViewGpsCoord viewGpsCoord = new ViewGpsCoord(event.getPlace().getGpsCoord());
		viewGpsCoord.show(coordPanel);
		
		
	}
	
	private void showEvent(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        
	    panel.add(createPane("Name",createLabel(event.getName() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Date",createLabel(event.getDateBegin() + " until " + event.getDateEnd())),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Number of participants",createLabel(event.getNumberMinimum() + " to " + event.getNumberMaximum())),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Club",createLabel(event.getClubOrganiser() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Price",createLabel(event.getPrice() + "")),gbc);
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
