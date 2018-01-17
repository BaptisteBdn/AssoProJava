 package eseo.assoprojava.view.ui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import eseo.assoprojava.controller.ActionCreateActivity;

/**
 * 
 * @author baptiste
 *
 */

public class ToolsPanel extends JPanel {

	public ToolsPanel(){
		this.setLayout(new GridLayout(1, 4));
		this.setPreferredSize(new Dimension(100, 30));
		initComponents();
	}
	
	private void initComponents(){
		createButton("Nouveau", new ActionCreateActivity());
		createButton("Ouvrir", null );
		createButton("Sauvegarder", null );
		createButton("Modifier", null );
		createButton("Créer une activité", null );
	}
	
	private void createButton(String text, ActionListener action){
		JButton button = new JButton(text);
		button.setMargin(new Insets(2, 2, 2, 2));
		button.getPreferredSize();
		button.setForeground(Color.BLACK);
		button.setBackground(Color.LIGHT_GRAY);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		button.setBorder(compound);
		button.addActionListener(action);
		this.add(button);
	}

}
