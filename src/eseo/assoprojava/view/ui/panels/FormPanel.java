package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormPanel extends JPanel {
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 190;
	public static final Color DEFAULT_COLOR = Color.WHITE;

	private JPanel controls = new JPanel(new GridBagLayout());

	public FormPanel()
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}

	public FormPanel(int width, int height, Color color)
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH));
		this.setBackground(color);
		init();

		// JLabel nameLabel = new JLabel("Name"+" : ");
		// TextField nameField = new TextField("Name");
		// controls.setBackground(DEFAULT_COLOR);
		// GridBagConstraints c = new GridBagConstraints();
		// c.weightx = 1.0;
		// c.fill = GridBagConstraints.BOTH;
		// c.insets = new Insets(2, 2, 2, 2);
		// controls.add(nameLabel,c);
		// controls.add(nameField, c);
		// c.gridwidth = GridBagConstraints.REMAINDER; //end row
		//
		//// controls.add(new JLabel("Name"+" : "),c);
		//// c.weightx = 0;
		//
		// controls.add(new JLabel("Name"+" : "),c);
		//
		//
		// this.add(controls, BorderLayout.NORTH);
	}

	private void createLineForm(String text)
	{

	}

	protected void makebutton(String name, GridBagLayout gridbag, GridBagConstraints c)
	{
		Button button = new Button(name);
		gridbag.setConstraints(button, c);
		add(button);
	}

	public void init()
	{
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setLayout(gridbag);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		makebutton("Button1", gridbag, c);
		makebutton("Button2", gridbag, c);
		makebutton("Button3", gridbag, c);
//		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		
		makebutton("Button4", gridbag, c);

		c.weightx = 0.0; // reset to the default
		makebutton("Button5", gridbag, c); // another row

	}

}
