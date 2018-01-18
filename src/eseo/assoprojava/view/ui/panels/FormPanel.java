package eseo.assoprojava.view.ui.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import eseo.assoprojava.model.Occasion;
import eseo.assoprojava.model.event.Event;

public class FormPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 500;
	public static final Color DEFAULT_COLOR = Color.WHITE;

	private Event event;
	private boolean isCreating;

	private JTextField nameField;
	private JTextArea descriptionField;

	private JTextField placeNumberField;
	private JTextField placeStreetField;
	private JTextField placePostalCodeField;
	private JTextField placeCityField;
	private JTextField placeCountryField;
	private JTextField placeNameField;
	private JTextField placeStateField;
	private JTextField placeGPSLatField;
	private JTextField placeGPSLongField;

	private JTextField priceField;
	private JTextField clubField;

	private JSpinner dateBeginField;
	private JSpinner dateEndField;

	private JTextField numberMinField;
	private JTextField numberMaxField;

	public FormPanel(Occasion occasion)
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR, occasion);
	}

	public FormPanel(int width, int height, Color color, Occasion occasion)
	{
		if (occasion == null)
		{
			event = new Event();
		}
		else
		{
			event = (Event) occasion;
		}
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setBackground(color);
		initComponents();
	}

	public void initComponents()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;

		nameField = new JTextField(event.getName());
		add(createPane("Nom", nameField), gbc);
		gbc.gridy++;

		descriptionField = new JTextArea(event.getDescription());
		add(createPane("Description", descriptionField), gbc);
		gbc.gridy++;

		placeNumberField = new JTextField(String.valueOf(event.getPlace().getNumber()));
		if (event.getPlace().getPostalCode() != 0)
		{
			placePostalCodeField = new JTextField(String.valueOf(event.getPlace().getPostalCode()));
		}
		else
		{
			placePostalCodeField = new JTextField("Code postal");
		}
		placeStreetField = new JTextField(event.getPlace().getStreet());
		placeNameField = new JTextField(event.getPlace().getName());
		placeCityField = new JTextField(event.getPlace().getCity());
		placeCountryField = new JTextField(event.getPlace().getCountry());
		placeStateField = new JTextField(event.getPlace().getState());
		if (event.getPlace().getGpsCoord().getLatitude() != 0)
		{
			placeGPSLatField = new JTextField(String.valueOf(event.getPlace().getGpsCoord().getLatitude()));
		}
		else
		{
			placeGPSLatField = new JTextField("Latitude");
		}

		if (event.getPlace().getGpsCoord().getLongitude() != 0)
		{
			placeGPSLongField = new JTextField(String.valueOf(event.getPlace().getGpsCoord().getLongitude()));
		}
		else
		{
			placeGPSLongField = new JTextField("Longitude");
		}

		add(createPlacePane("Lieu", placeNumberField, placeStreetField, placeNameField, placePostalCodeField, placeCityField, placeCountryField, placeStateField, placeGPSLatField, placeGPSLongField), gbc);
		gbc.gridy++;

		priceField = new JTextField(String.valueOf(event.getPrice()));
		add(createPane("Prix", priceField), gbc);
		gbc.gridy++;

		clubField = new JTextField(event.getClubOrganiser());
		add(createPane("Club", clubField), gbc);
		gbc.gridy++;

		dateBeginField = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(dateBeginField,"dd-MM-yyyy HH:mm");
		dateBeginField.setEditor(timeEditor);
		dateBeginField.setValue(event.getDateBegin());
		add(createPane("Date de début", dateBeginField), gbc);
		gbc.gridy++;

		dateEndField = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(dateEndField, "dd-MM-yyyy HH:mm");
		dateEndField.setEditor(timeEditor1);
		dateEndField.setValue(event.getDateEnd());
		add(createPane("Heure de fin", dateEndField), gbc);
		gbc.gridy++;

		numberMinField = new JTextField(String.valueOf(event.getNumberMinimum()));
		add(createPane("Nombre minimum de personnes", numberMinField), gbc);
		gbc.gridy++;
		
		numberMaxField = new JTextField(String.valueOf(event.getNumberMaximum()));
		add(createPane("Nombre maximum de personnes", numberMaxField), gbc);
		gbc.gridy++;

		centerTextFields();
	}

	private void centerTextFields()
	{
		nameField.setHorizontalAlignment(JTextField.CENTER);
		placeNumberField.setHorizontalAlignment(JTextField.CENTER);
		placeStreetField.setHorizontalAlignment(JTextField.CENTER);
		placePostalCodeField.setHorizontalAlignment(JTextField.CENTER);
		placeCityField.setHorizontalAlignment(JTextField.CENTER);
		placeCountryField.setHorizontalAlignment(JTextField.CENTER);
		placeNameField.setHorizontalAlignment(JTextField.CENTER);
		placeStateField.setHorizontalAlignment(JTextField.CENTER);
		placeGPSLatField.setHorizontalAlignment(JTextField.CENTER);
		placeGPSLongField.setHorizontalAlignment(JTextField.CENTER);
		priceField.setHorizontalAlignment(JTextField.CENTER);
		clubField.setHorizontalAlignment(JTextField.CENTER);
		numberMaxField.setHorizontalAlignment(JTextField.CENTER);
		numberMinField.setHorizontalAlignment(JTextField.CENTER);
		descriptionField.setEditable(true);
		descriptionField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		descriptionField.setWrapStyleWord(true);
		descriptionField.setLineWrap(true);
		descriptionField.setRows(4);
	}

	private Component createPlacePane(String text, JTextField jTextField, JTextField placeStreetField, JTextField placeNameField2, JTextField placePostalCodeField2, JTextField placeCityField2, JTextField placeCountryField2, JTextField placeStateField2, JTextField placeGPSField2, JTextField placeGPSLongField2)
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
		gbc.gridy++;
		jPanel.add(placeGPSLongField2, gbc);
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

	public JTextField getPlaceGPSLatField()
	{
		return placeGPSLatField;
	}

	public JTextField getPlaceGPSLongField()
	{
		return placeGPSLongField;
	}

	public JTextArea getDescriptionField()
	{
		return descriptionField;
	}

	public Event getEvent()
	{
		return event;
	}

	public void setEvent(Event event)
	{
		this.event = event;
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
