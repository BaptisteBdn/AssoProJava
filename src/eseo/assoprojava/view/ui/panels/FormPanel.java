package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanel extends JPanel {
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 280;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	
	private JTextField nameField;
	private JTextField placeNumberField;
	private JTextField placeStreetField;
	private JTextField priceField;
	private JTextField clubField;
	private JTextField dateBeginField;
	private JTextField dateEndField;
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
        nameField = new JTextField("");
        add(createPane("Name",nameField),gbc);
        gbc.gridy++;
        placeNumberField = new JTextField("0");
        placeNumberField.setHorizontalAlignment(JTextField.CENTER);

        placeStreetField = new JTextField("Rue");
        placeStreetField.setHorizontalAlignment(JTextField.CENTER);

        add(createPlacePane("Lieu",placeNumberField,placeStreetField),gbc);
        gbc.gridy++;
        priceField = new JTextField("");
        add(createPane("Prix",priceField),gbc);
        gbc.gridy++;
        clubField = new JTextField("");
        add(createPane("Club",clubField),gbc);
        gbc.gridy++;
        dateBeginField = new JTextField("");
        add(createPane("Date de début",dateBeginField),gbc);
        gbc.gridy++;
        dateEndField = new JTextField("");
        add(createPane("Date de fin",dateEndField),gbc);
        gbc.gridy++;
        numberMinField = new JTextField("");
        add(createPane("Nombre minimum de personnes",numberMinField),gbc);
        gbc.gridy++;
        numberMaxField = new JTextField("");
        add(createPane("Nombre maximum de personnes",numberMaxField),gbc);
        gbc.gridy++;

	}
	
		
	private Component createPlacePane(String text, JTextField jTextField, JTextField placeStreetField)
	{
		JPanel jPanel = new JPanel();
		jPanel.setBackground(DEFAULT_COLOR);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.weightx = 1;
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
        return jPanel;	
   }

	private JPanel createPane(String text, JTextField jTextField){
		JPanel jPanel = new JPanel();
		jPanel.setBackground(DEFAULT_COLOR);
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.weightx = 1;
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


