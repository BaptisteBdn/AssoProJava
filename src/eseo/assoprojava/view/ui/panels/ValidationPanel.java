package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import eseo.assoprojava.controller.ActionCancel;
import eseo.assoprojava.controller.ActionValidate;

public class ValidationPanel extends JPanel {
	
	/**
	 * @author baptiste
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonValidate = new JButton("Valider");
	private JButton buttonCancel = new JButton("Annuler");
	
	/**
	 * Default constructor
	 * Init the validationPanel
	 */
	public ValidationPanel(){
		this.setBackground(Color.WHITE);
		createButton(buttonValidate, new ActionValidate());
		createButton(buttonCancel, new ActionCancel());
	}
	
	/**
	 * Create a new button and add it to the main panel
	 * @param button
	 * @param action
	 */
	private void createButton(JButton button, ActionListener action){
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
