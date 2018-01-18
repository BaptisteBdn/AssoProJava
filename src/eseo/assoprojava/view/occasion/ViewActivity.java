package eseo.assoprojava.view.occasion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.ui.MainWindow;

public class ViewActivity {
	private final List<Activity> activities;
	
	public ViewActivity(List<Activity> activities) {
		this.activities = activities;
	}
	
	public List<Activity> getListActivities() {
		return activities;
	}
	
	public void show(JPanel mainPanel) {
	    
	    GridBagConstraints mgbc = new GridBagConstraints();
        mgbc.gridx = 0;
        mgbc.gridy = 1;
        mgbc.weightx = 1;
        mgbc.fill = GridBagConstraints.HORIZONTAL;
        mgbc.insets = new Insets(4, 4, 4, 4);
        mgbc.anchor = GridBagConstraints.WEST;
        
        JLabel title = new JLabel("Activitée(s)");
        title.setFont(MainWindow.TITLE_FONT);
        
        mainPanel.add(title, mgbc);
        mgbc.gridy++;
        for(int i = 0; i < activities.size(); i++) {
        	GridBagConstraints gbc = new GridBagConstraints();
        	gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;
        	JPanel panel = new JPanel(new GridBagLayout());
        	
        	panel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));
        	
        	Activity activity = activities.get(i);
        	panel.add(createPane("Nom",createLabel(activity.getName() + "")),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Date",createLabel(activity.getDateBegin() + " jusqu'a " + activity.getDateEnd())),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Nombre de participants",createLabel(activity.getNumberMinimum() + " à " + activity.getNumberMaximum())),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Par",createLabel(activity.getOrganiser().getFirstName() + " " + activity.getOrganiser().getLastName())),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Prix",createLabel(activity.getPrice() + " €")),gbc);
    	    gbc.gridy++;
    	    
    	    mainPanel.add(panel,mgbc);
    	    mgbc.gridy++;
    	    
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
