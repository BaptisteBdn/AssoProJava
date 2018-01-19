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
import eseo.assoprojava.controller.ActionCreateEvent;
import eseo.assoprojava.controller.ActionLoadEvent;
import eseo.assoprojava.controller.ActionModifyEvent;
import eseo.assoprojava.controller.ActionSaveEvent;
import eseo.assoprojava.view.ui.MainWindow;

/**
 * @author baptiste
 */

public class ToolsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton buttonNew;
	JButton buttonLoad;
	JButton buttonSave;
	JButton buttonModify;
	JButton buttonCreateActivity;

	/**
	 * Default constructor
	 */
	public ToolsPanel()
	{
		this.setLayout(new GridLayout(1, 4));
		this.setPreferredSize(new Dimension(100, 30));
		initComponents();
	}

	/**
	 * Init all the button
	 */
	private void initComponents()
	{
		buttonNew = createButton("Nouveau", new ActionCreateEvent());
		buttonLoad = createButton("Ouvrir", new ActionLoadEvent());
		buttonSave = createButton("Sauvegarder", new ActionSaveEvent());
		buttonSave.setEnabled(false);
		buttonModify = createButton("Modifier l'�v�nement", new ActionModifyEvent());
		buttonModify.setEnabled(false);
		buttonCreateActivity = createButton("Cr�er une activit�", new ActionCreateActivity());
		buttonCreateActivity.setEnabled(false);
	}

	
	/**
	 * Disable all the button
	 */
	public void disableButtons()
	{
		this.buttonNew.setEnabled(false);
		this.buttonLoad.setEnabled(false);
		this.buttonSave.setEnabled(false);
		this.buttonModify.setEnabled(false);
		this.buttonCreateActivity.setEnabled(false);
	}
	
	/**
	 * Enable all the button if they can be used
	 * Otherwise only enable buttonNew and buttonLoad
	 */
	public void enableButtons()
	{
		this.buttonNew.setEnabled(true);
		this.buttonLoad.setEnabled(true);
		if(MainWindow.getInstance().getWorkPanel().getViewEvent() != null){
			this.buttonSave.setEnabled(true);
			this.buttonModify.setEnabled(true);
			this.buttonCreateActivity.setEnabled(true);
		}
	}

	/**
	 * Create a button and add it to the main panel
	 * @param textButton
	 * @param action
	 * @return JButton
	 */
	private JButton createButton(String text, ActionListener action)
	{
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
		return button;
	}

}
