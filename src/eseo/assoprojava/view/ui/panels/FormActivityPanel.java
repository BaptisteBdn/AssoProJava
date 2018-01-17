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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormActivityPanel extends JPanel {
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	private static final int TA_ROWS = 5;
	private static final int TA_COLS = 5;

	private JTextField nameField;
	private JTextField priceField;
	private JTextField dateBeginField;
	private JTextField dateEndField;
	private JTextField numberMinField;
	private JTextField numberMaxField;
	private JTextArea descriptionField;

	private JTextField organiserFirstField;
	private JTextField organiserLastField;
	private JTextField organiserClubField;
	private JTextField organiserRoleField;

	public FormActivityPanel()
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}

	public FormActivityPanel(int width, int height, Color color)
	{
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setBackground(color);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;

		nameField = new JTextField("Nom");
		add(createPane("Nom", nameField), gbc);
		gbc.gridy++;

		priceField = new JTextField("Prix");
		add(createPane("Prix", priceField), gbc);
		gbc.gridy++;

		dateBeginField = new JTextField("dd//MM//YY HH:mm");
		add(createPane("Date de début", dateBeginField), gbc);
		gbc.gridy++;

		dateEndField = new JTextField("dd//MM//YY HH:mm");
		add(createPane("Date de fin", dateEndField), gbc);
		gbc.gridy++;

		numberMinField = new JTextField("-");
		add(createPane("Nombre minimum de personnes", numberMinField), gbc);
		gbc.gridy++;

		numberMaxField = new JTextField("-");
		add(createPane("Nombre maximum de personnes", numberMaxField), gbc);
		gbc.gridy++;

		descriptionField = new JTextArea();
		add(createPane("Description", descriptionField), gbc);
		gbc.gridy++;

		organiserFirstField = new JTextField("Prénom");
		organiserLastField = new JTextField("Nom");
		organiserClubField = new JTextField("Club");
		organiserRoleField = new JTextField("Role");

		add(createOrganiserPane("Animateur", organiserFirstField, organiserLastField, organiserClubField, organiserRoleField), gbc);
		gbc.gridy++;

		centerTextFields();
	}

	private Component createPane(String text, JTextArea descriptionField2)
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
		jPanel.add(descriptionField2, gbc);
		return jPanel;
	}

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
		dateBeginField.setHorizontalAlignment(JTextField.CENTER);
		dateEndField.setHorizontalAlignment(JTextField.CENTER);
		numberMaxField.setHorizontalAlignment(JTextField.CENTER);
		numberMinField.setHorizontalAlignment(JTextField.CENTER);
	}

	private Component createOrganiserPane(String text, JTextField jTextField, JTextField placeStreetField, JTextField placeNameField2, JTextField placePostalCodeField2)
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

	private JPanel createPane(String text, JTextField jTextField)
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
}
