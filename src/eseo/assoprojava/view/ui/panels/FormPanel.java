package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FormPanel extends JPanel {
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 400;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	private JPanel formPanel;
	private JButton bouton = new JButton("Go");
	private JButton bouton2 = new JButton("Stop");
	
	public FormPanel(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	public FormPanel(int width, int height, Color color){
	    this.setLayout(new BorderLayout());
	    this.formPanel = new JPanel();
	    this.add(this.formPanel , BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH));
		this.setBackground(color);
		
	    bouton.addActionListener(null);     
	    bouton2.addActionListener(null);
	    bouton2.setEnabled(false);    
	    JPanel south = new JPanel();
	    south.add(bouton);
	    south.add(bouton2);
	    this.add(south, BorderLayout.SOUTH);
	}
}
