package eseo.assoprojava.view.occasion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.ui.MainWindow;

public class ViewEvent {
	
	private Event event;
	private JPanel mainEventPanel;

	
	public ViewEvent(Event event) {
		this.event = event;
		MainWindow.getInstance().getWorkPanel().setViewEvent(this);
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void show() {
		mainEventPanel = new JPanel(new BorderLayout());
		JPanel mainPlacePanel = new JPanel(new BorderLayout());
		JPanel tabulationPanel = new JPanel(new BorderLayout());
		
		JPanel eventPanel = new JPanel(new GridBagLayout());
		JPanel placePanel = new JPanel(new GridBagLayout());
		JPanel coordPanel = new JPanel(new GridBagLayout());
		
		mainEventPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		mainPlacePanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		tabulationPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		eventPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		placePanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		coordPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		

		mainPlacePanel.add(placePanel,BorderLayout.WEST);
		mainPlacePanel.add(tabulationPanel,BorderLayout.CENTER);
		mainPlacePanel.add(coordPanel,BorderLayout.EAST);
		
		mainEventPanel.add(eventPanel,BorderLayout.WEST);		
		mainEventPanel.add(mainPlacePanel,BorderLayout.EAST);
		
		mainEventPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));
		
		MainWindow.getInstance().getWorkPanel().add(mainEventPanel,BorderLayout.NORTH);
		
		JPanel activitiesPanel = new JPanel(new BorderLayout());
		JPanel activitiesScrollPanel = new JPanel(new GridBagLayout());
		
		
		tabulationPanel.add(new JLabel("                            "));
		
		showEvent(eventPanel);
		
		ViewPlace viewPlace = new ViewPlace(event.getPlace());
		viewPlace.show(placePanel);
		
		ViewGpsCoord viewGpsCoord = new ViewGpsCoord(event.getPlace().getGpsCoord());
		viewGpsCoord.show(coordPanel);
		
		ViewActivity viewActivities = new ViewActivity(event.getActivities());
		viewActivities.show(activitiesScrollPanel);
		
		JScrollPane activitiesScrollPane = new JScrollPane(activitiesScrollPanel);
		activitiesPanel.setPreferredSize(new Dimension(450,200));
		activitiesPanel.add(activitiesScrollPane);
		
		MainWindow.getInstance().getWorkPanel().add(activitiesPanel,BorderLayout.CENTER);
		
		
		
	}
	
	private void showEvent(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel title = new JLabel("Evenement");
        title.setFont(MainWindow.TITLE_FONT);
        panel.add(title, gbc);
        gbc.gridy++;
        gbc.gridy++;
        
	    panel.add(createPane("Nom",createLabel(event.getName() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Date",createLabel(event.getDateBegin() + " jusqu'a " + event.getDateEnd())),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Nombre de participants",createLabel(event.getNumberMinimum() + " à " + event.getNumberMaximum())),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Club",createLabel(event.getClubOrganiser() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Prix",createLabel(event.getPrice() + "")),gbc);
	    gbc.gridy = 0;
	    gbc.gridx++;
	    panel.add(createPane("Description",createLabel(event.getDescription() + "")),gbc);
	    
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

	public JPanel getMainEventPanel()
	{
		return mainEventPanel;
	}

	public void setMainEventPanel(JPanel mainEventPanel)
	{
		this.mainEventPanel = mainEventPanel;
	}

	public void setEvent(Event event)
	{
		this.event = event;
	}
	
}
