package eseo.assoprojava.view.ui.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class FormPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 500;
	public static final Color DEFAULT_COLOR = Color.WHITE;

	private JTextField nameField;

	private JTextField placeNumberField;
	private JTextField placeStreetField;
	private JTextField placePostalCodeField;
	private JTextField placeCityField;
	private JTextField placeCountryField;
	private JTextField placeNameField;
	private JTextField placeStateField;
	private JTextField placeGPSField;

	private JTextField priceField;
	private JTextField clubField;
	
	private JSpinner dateBeginField;
	private JSpinner dateEndField;

	private JTextField numberMinField;
	private JTextField numberMaxField;

	public FormPanel()
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}

	public FormPanel(int width, int height, Color color)
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
		
		placeNumberField = new JTextField("0");
		placeStreetField = new JTextField("Rue");
		placeNameField = new JTextField("Nom");
		placePostalCodeField = new JTextField("Code postal");
		placeCityField = new JTextField("Ville");
		placeCountryField = new JTextField("Pays");
		placeStateField = new JTextField("Région");
		placeGPSField = new JTextField("GPS (Degrées Décimals ou Degrées Minutes Secondes)");

		add(createPlacePane("Lieu", placeNumberField, placeStreetField, placeNameField, placePostalCodeField, placeCityField, placeCountryField, placeStateField, placeGPSField), gbc);
		gbc.gridy++;
		
		priceField = new JTextField("Prix");
		add(createPane("Prix", priceField), gbc);
		gbc.gridy++;
		
		clubField = new JTextField("Club");
		add(createPane("Club", clubField), gbc);
		gbc.gridy++;

		dateBeginField = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(dateBeginField, "dd-MM-yyyy HH:mm:ss");
		dateBeginField.setEditor(timeEditor);
		add(createPane("Date de début", dateBeginField), gbc);
		gbc.gridy++;

		dateEndField = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(dateEndField, "dd-MM-yyyy HH:mm:ss");
		dateEndField.setEditor(timeEditor1);
		add(createPane("Heure de fin", dateEndField), gbc);
		gbc.gridy++;
		
		numberMinField = new JTextField("-");
		add(createPane("Nombre minimum de personnes", numberMinField), gbc);
		gbc.gridy++;
		numberMaxField = new JTextField("-");
		add(createPane("Nombre maximum de personnes", numberMaxField), gbc);
		gbc.gridy++;
		
		
		centerTextFields();
	}

	private void centerTextFields(){
		nameField.setHorizontalAlignment(JTextField.CENTER);
		placeNumberField.setHorizontalAlignment(JTextField.CENTER);
		placeStreetField.setHorizontalAlignment(JTextField.CENTER);
		placePostalCodeField.setHorizontalAlignment(JTextField.CENTER);
		placeCityField.setHorizontalAlignment(JTextField.CENTER);
		placeCountryField.setHorizontalAlignment(JTextField.CENTER);
		placeNameField.setHorizontalAlignment(JTextField.CENTER);
		placeStateField.setHorizontalAlignment(JTextField.CENTER);
		placeGPSField.setHorizontalAlignment(JTextField.CENTER);
		priceField.setHorizontalAlignment(JTextField.CENTER);
		clubField.setHorizontalAlignment(JTextField.CENTER);
		numberMaxField.setHorizontalAlignment(JTextField.CENTER);
		numberMinField.setHorizontalAlignment(JTextField.CENTER);
		dateBeginField.setValue(new Date());
		dateEndField.setValue(new Date());
	}

	private Component createPlacePane(String text, JTextField jTextField, JTextField placeStreetField, JTextField placeNameField2, JTextField placePostalCodeField2, JTextField placeCityField2, JTextField placeCountryField2, JTextField placeStateField2, JTextField placeGPSField2)
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
		jPanel.add(placeCityField2, gbc);
		gbc.gridy++;
		jPanel.add(placeCountryField2, gbc);
		gbc.gridy++;
		jPanel.add(placeStateField2, gbc);
		gbc.gridy++;
		jPanel.add(placeGPSField2, gbc);
		return jPanel;
	}

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

	public JTextField getNameField()
	{
		return nameField;
	}

	public JTextField getPlaceNumberField()
	{
		return placeNumberField;
	}

	public JTextField getPlaceStreetField()
	{
		return placeStreetField;
	}

	public JTextField getPlacePostalCodeField()
	{
		return placePostalCodeField;
	}

	public JTextField getPlaceCityField()
	{
		return placeCityField;
	}

	public JTextField getPlaceCountryField()
	{
		return placeCountryField;
	}

	public JTextField getPlaceNameField()
	{
		return placeNameField;
	}

	public JTextField getPlaceStateField()
	{
		return placeStateField;
	}

	public JTextField getPlaceGPSField()
	{
		return placeGPSField;
	}

	public JTextField getPriceField()
	{
		return priceField;
	}

	public JTextField getClubField()
	{
		return clubField;
	}

	public JTextField getNumberMinField()
	{
		return numberMinField;
	}

	public JTextField getNumberMaxField()
	{
		return numberMaxField;
	}

	public JSpinner getDateBeginField()
	{
		return dateBeginField;
	}

	public JSpinner getDateEndField()
	{
		return dateEndField;
	}
}
