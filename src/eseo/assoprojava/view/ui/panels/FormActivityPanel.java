package eseo.assoprojava.view.ui.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import eseo.assoprojava.model.Occasion;
import eseo.assoprojava.model.activity.Activity;

public class FormActivityPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	
	private Activity activity;
	private boolean isCreating;
	
	
	// Each field is individual in order to get their values 
	private JTextField nameField;
	private JTextField priceField;
	private JSpinner dateBeginField;
	private JSpinner dateEndField;
	private JTextField numberMinField;
	private JTextField numberMaxField;
	private JTextArea descriptionField;

	private JTextField organiserFirstField;
	private JTextField organiserLastField;
	private JTextField organiserClubField;
	private JTextField organiserRoleField;

	/**
	 * Basic constructor
	 * @param occasion
	 */
	public FormActivityPanel(Occasion occasion)
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, occasion);
	}
	
	
	/**
	 * Constructor, init activityPanel
	 * @param width
	 * @param height
	 * @param color
	 * @param occasion
	 */
	public FormActivityPanel(int width, int height, Color color, Occasion occasion)
	{
		// Set activity
		if (occasion == null)
		{
			activity = new Activity();
		}
		else
		{
			activity = (Activity) occasion;
		}
		
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setBackground(color);
		init();		
	}
	
	/**
	 * Init the panel with a new Layout which is containing constraints
	 * gbc : Constraints used to structure the panel layout
	 * Initializing each field with their name
	 */
	private void init(){
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;

		nameField = new JTextField(activity.getName());
		add(createPane("Nom", nameField), gbc);
		gbc.gridy++;

		priceField = new JTextField(String.valueOf(activity.getPrice()));
		add(createPane("Prix", priceField), gbc);
		gbc.gridy++;

		dateBeginField = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(dateBeginField, "dd-MM-yyyy HH:mm:ss");
		dateBeginField.setEditor(timeEditor);
		dateBeginField.setValue(activity.getDateBegin());
		add(createPane("Date de début", dateBeginField), gbc);
		gbc.gridy++;

		dateEndField = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(dateEndField, "dd-MM-yyyy HH:mm:ss");
		dateEndField.setEditor(timeEditor1);
		dateEndField.setValue(activity.getDateEnd());
		add(createPane("Heure de fin", dateEndField), gbc);
		gbc.gridy++;

		numberMinField = new JTextField(String.valueOf(activity.getNumberMinimum()));
		add(createPane("Nombre minimum de personnes", numberMinField), gbc);
		gbc.gridy++;

		numberMaxField = new JTextField(String.valueOf(activity.getNumberMaximum()));
		add(createPane("Nombre maximum de personnes", numberMaxField), gbc);
		gbc.gridy++;

		descriptionField = new JTextArea(activity.getDescription());
		add(createPane("Description", descriptionField), gbc);
		gbc.gridy++;

		organiserFirstField = new JTextField(activity.getOrganiser().getFirstName());
		organiserLastField = new JTextField(activity.getOrganiser().getLastName());
		organiserClubField = new JTextField(activity.getOrganiser().getClub());
		organiserRoleField = new JTextField(activity.getOrganiser().getRole());

		add(createOrganiserPane("Animateur", organiserFirstField, organiserLastField, organiserClubField, organiserRoleField), gbc);
		gbc.gridy++;

		centerTextFields();
	}
	
	/**
	 * Create a new pane contained in the formActiviyPanel
	 * @param text
	 * @param jTextField
	 * @return JPanel containing a JLabel and a jTextfield on the same line (to structure the mainPanel)
	 */
	private JPanel createPane(String text, Component jTextField)
	{
		JPanel jPanel = new JPanel();
		jPanel.setBackground(DEFAULT_COLOR);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		jPanel.add(new JLabel(text + " : "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;
		jPanel.add(jTextField, gbc);
		return jPanel;
	}

	/**
	 * Center the value inside the textFields
	 * Set the descriptionField
	 */
	private void centerTextFields()
	{
		nameField.setHorizontalAlignment(JTextField.CENTER);
		descriptionField.setEditable(true);
		descriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		descriptionField.setWrapStyleWord(true);
		descriptionField.setLineWrap(true);
		descriptionField.setRows(4);
		organiserFirstField.setHorizontalAlignment(JTextField.CENTER);
		organiserLastField.setHorizontalAlignment(JTextField.CENTER);
		organiserClubField.setHorizontalAlignment(JTextField.CENTER);
		organiserRoleField.setHorizontalAlignment(JTextField.CENTER);
		priceField.setHorizontalAlignment(JTextField.CENTER);
		numberMaxField.setHorizontalAlignment(JTextField.CENTER);
		numberMinField.setHorizontalAlignment(JTextField.CENTER);
	}

	/**
	 * Special createPane with multiple jTextField in order to have multiple textField for the same label
	 * @param text
	 * @param jTextField
	 * @param placeStreetField
	 * @param placeNameField2
	 * @param placePostalCodeField2
	 * @return JPanel containing a JLabel and multiple jTextfield on the same line (to structure the mainPanel)
	 */
	private JPanel createOrganiserPane(String text, JTextField jTextField, JTextField placeStreetField, JTextField placeNameField2, JTextField placePostalCodeField2)
	{
		JPanel jPanel = new JPanel();
		jPanel.setBackground(DEFAULT_COLOR);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		jPanel.add(new JLabel(text + " : "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(jTextField, gbc);
		gbc.gridy++;
		jPanel.add(placeStreetField, gbc);
		gbc.gridy++;
		jPanel.add(placePostalCodeField2, gbc);
		gbc.gridy++;
		jPanel.add(placeNameField2, gbc);
		gbc.gridy++;
		return jPanel;
	}

	public Activity getActivity()
	{
		return activity;
	}

	public JTextField getNameField()
	{
		return nameField;
	}

	public JTextField getPriceField()
	{
		return priceField;
	}

	public JSpinner getDateBeginField()
	{
		return dateBeginField;
	}

	public JSpinner getDateEndField()
	{
		return dateEndField;
	}

	public JTextField getNumberMinField()
	{
		return numberMinField;
	}

	public JTextField getNumberMaxField()
	{
		return numberMaxField;
	}

	public JTextArea getDescriptionField()
	{
		return descriptionField;
	}

	public JTextField getOrganiserFirstField()
	{
		return organiserFirstField;
	}

	public JTextField getOrganiserLastField()
	{
		return organiserLastField;
	}

	public JTextField getOrganiserClubField()
	{
		return organiserClubField;
	}

	public JTextField getOrganiserRoleField()
	{
		return organiserRoleField;
	}

	public boolean isCreating()
	{
		return isCreating;
	}

	public void setCreating(boolean isCreating)
	{
		this.isCreating = isCreating;
	}
}
