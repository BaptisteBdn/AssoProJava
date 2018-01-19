package eseo.assoprojava.view.occasion;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private JPanel activitiesPanel;

	
	public ViewEvent(Event event) {
		this.event = event;
		MainWindow.getInstance().getWorkPanel().setViewEvent(this);
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void show() {
		// Create the differents panels
		mainEventPanel = new JPanel(new BorderLayout());
		JPanel mainPlacePanel = new JPanel(new BorderLayout());
		JPanel tabulationPanel = new JPanel(new BorderLayout());
		
		JPanel eventPanel = new JPanel(new GridBagLayout());
		JPanel placePanel = new JPanel(new GridBagLayout());
		JPanel coordPanel = new JPanel(new GridBagLayout());
		
		// Set their backgrounds
		mainEventPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		mainPlacePanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		tabulationPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		eventPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		placePanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		coordPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
		
		// Add the panels to their respective parents
		mainPlacePanel.add(placePanel,BorderLayout.LINE_START);
		mainPlacePanel.add(tabulationPanel,BorderLayout.CENTER);
		mainPlacePanel.add(coordPanel,BorderLayout.LINE_END);
		
		mainEventPanel.add(eventPanel,BorderLayout.WEST);		
		mainEventPanel.add(mainPlacePanel,BorderLayout.EAST);
		
		mainEventPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));
		
		MainWindow.getInstance().getWorkPanel().add(mainEventPanel,BorderLayout.NORTH);
		
		activitiesPanel = new JPanel(new BorderLayout());
		JPanel activitiesScrollPanel = new JPanel(new GridBagLayout());
		
		// Add a tabulation panel to separate GpsCoord and Place
		tabulationPanel.add(new JLabel("                            "));
		
		showEvent(eventPanel);
		
		// Show each views and give them their respective panels
		ViewPlace viewPlace = new ViewPlace(event.getPlace());
		viewPlace.show(placePanel);
		
		ViewGpsCoord viewGpsCoord = new ViewGpsCoord(event.getPlace().getGpsCoord());
		viewGpsCoord.show(coordPanel);
		
		ViewActivity viewActivities = new ViewActivity(event.getActivities());
		viewActivities.show(activitiesScrollPanel);
		
		JScrollPane activitiesScrollPane = new JScrollPane(activitiesScrollPanel);
		
		activitiesScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		activitiesPanel.add(activitiesScrollPane);
		
		MainWindow.getInstance().getWorkPanel().add(activitiesPanel,BorderLayout.CENTER);
	}
	
	@SuppressWarnings("deprecation")
	private void showEvent(JPanel panel) {
		// We created the constraint that is used to place the event panels
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        
        // The title of the panel
        JLabel title = new JLabel("Événement");
        title.setFont(MainWindow.TITLE_FONT);
        
        // The informations of the event
        panel.add(title, gbc);
        gbc.gridy++;
	    panel.add(createPane("Nom",createLabel(event.getName() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Date",createLabel(event.getDateBegin().toLocaleString() + " jusqu'au " + event.getDateEnd().toLocaleString())),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Nombre de participants",createLabel(event.getNumberMinimum() + " à " + event.getNumberMaximum())),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Club",createLabel(event.getClubOrganiser() + "")),gbc);
	    gbc.gridy++;
	    panel.add(createPane("Prix",createLabel(event.getPrice() + " €")),gbc);
	    
	    gbc.gridy = 1;
	    gbc.gridx++;
	    
	    JLabel titleDesc = new JLabel("Description");
	    titleDesc.setFont(MainWindow.TITLE_FONT);
        
        panel.add(titleDesc, gbc);
        gbc.gridy++;
        
        panel.add(createLabel(event.getDescription() + ""),gbc);
	    
	}
	
	/**
	 * Create a new pane contained in the formActiviyPanel
	 * @param text
	 * @param jTextField
	 * @return JPanel containing a JLabel and a jTextfield on the same line (to structure the mainPanel)
	 */
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
	/**
	 * 
	 * @param text
	 * @return JLabel containing the text that we passed
	 */
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

	public JPanel getActivitiesPanel()
	{
		return activitiesPanel;
	}

	
}
