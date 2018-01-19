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
	
	@SuppressWarnings("deprecation")
	public void show(JPanel mainPanel) {
		/*
    	 * We created the constraint that is used to place the activity panels
    	 */
	    GridBagConstraints mgbc = new GridBagConstraints();
        mgbc.gridx = 0;
        mgbc.gridy = 1;
        mgbc.weightx = 1;
        mgbc.fill = GridBagConstraints.HORIZONTAL;
        mgbc.insets = new Insets(4, 4, 4, 4);
        mgbc.anchor = GridBagConstraints.WEST;
        
        /*
    	 * Verify is there is an activity to display the title
    	 */
        if(!activities.isEmpty()) {
        
        JLabel title = new JLabel("Activitée(s)");
        title.setFont(MainWindow.TITLE_FONT);
        
        mainPanel.add(title, mgbc);
        mgbc.gridy++;
        
        }
        for(int i = 0; i < activities.size(); i++) {
        	/*
        	 * We created the constraint that is used to place the activity panels
        	 */
        	GridBagConstraints gbc = new GridBagConstraints();
        	gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.anchor = GridBagConstraints.WEST;
            
            /*
             * Creating the panel for each activities
             */
            JPanel activityPanel = new JPanel(new BorderLayout());
            
            /*
             * This panel is separated in 2 parts, the information of the activity and the buttons
             */
        	JPanel panel = new JPanel(new GridBagLayout());
        	JPanel buttonPanel = new JPanel(new BorderLayout());
        	
        	/*
        	 * Set the backgrounds of the panels
        	 */
        	activityPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	panel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	buttonPanel.setBackground(MainWindow.getInstance().getWorkPanel().getBackground());
        	activityPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));
        	
        	/*
        	 * Display the informations of the activity
        	 */
        	Activity activity = activities.get(i);
        	panel.add(createPane("Nom",createLabel(activity.getName() + "")),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Date",createLabel(activity.getDateBegin().toLocaleString() + " jusqu'au " + activity.getDateEnd().toLocaleString())),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Nombre de participants",createLabel(activity.getNumberMinimum() + " à " + activity.getNumberMaximum())),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Par",createLabel(activity.getOrganiser().getFirstName() + " " + activity.getOrganiser().getLastName())),gbc);
    	    gbc.gridy++;
    	    panel.add(createPane("Prix",createLabel(activity.getPrice() + " €")),gbc);
    	    gbc.gridy++;
    	    
    	    gbc.gridy = 1;
    	    gbc.gridx++;
    	    
    	    JLabel titleDesc = new JLabel("Description");
    	    titleDesc.setFont(MainWindow.TITLE_FONT);
            
            panel.add(titleDesc, gbc);
            gbc.gridy++;
            
            panel.add(createLabel(activity.getDescription() + ""),gbc);
    	    
    	    /*
    	     * Add the buttons Modifier and Supprimer
    	     */
    	    JButton modifyButton = new JButton("Modifier");
    	    modifyButton.addActionListener(new ActionModifyActivity(activity));
    	    
    	    JButton deleteButton = new JButton("Supprimer");
    	    deleteButton.addActionListener(new ActionDeleteActivity(activity));
    	    
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

}
