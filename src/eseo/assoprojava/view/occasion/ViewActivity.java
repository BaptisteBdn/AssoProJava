package eseo.assoprojava.view.occasion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eseo.assoprojava.controller.ActionDeleteActivity;
import eseo.assoprojava.controller.ActionModifyActivity;
import eseo.assoprojava.model.activity.Activity;
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
            JPanel activityPanel = new JPanel(new BorderLayout());
            
        	JPanel panel = new JPanel(new GridBagLayout());
        	JPanel buttonPanel = new JPanel(new BorderLayout());
        	
        	activityPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	panel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	buttonPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	activityPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));
        	
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
    	    
    	    
    	    JButton modifyButton = new JButton("Modifier");
    	    modifyButton.addActionListener(new ActionModifyActivity(activity));
    	    JButton deleteButton = new JButton("Supprimer");
    	    modifyButton.addActionListener(new ActionDeleteActivity(activity));
    	    
    	    modifyButton.setForeground(Color.BLACK);
    	    modifyButton.setBackground(Color.LIGHT_GRAY);
    		
    		deleteButton.setForeground(Color.BLACK);
    		deleteButton.setBackground(Color.LIGHT_GRAY);
    	    
    	    buttonPanel.add(modifyButton,BorderLayout.NORTH);
    	    buttonPanel.add(deleteButton,BorderLayout.SOUTH);
    	    
    	    activityPanel.add(panel,BorderLayout.WEST);
    	    activityPanel.add(buttonPanel,BorderLayout.EAST);
    	    
    	    
    	    mainPanel.add(activityPanel,mgbc);
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
