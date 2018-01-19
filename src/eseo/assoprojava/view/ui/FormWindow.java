package eseo.assoprojava.view.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import eseo.assoprojava.model.Occasion;
import eseo.assoprojava.view.ui.panels.FormActivityPanel;
import eseo.assoprojava.view.ui.panels.FormEventPanel;
import eseo.assoprojava.view.ui.panels.ValidationPanel;

/**
 * @author baptiste
 */

public class FormWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public String title = "Événement";
	private JPanel container;
	private boolean isEvent;
	private ValidationPanel validationPanel;
	private FormEventPanel formEventPanel;
	private FormActivityPanel formActivityPanel;
	
	/**
	 * Constructor, initialize the window with two panels :
	 * formPanel : event
	 * formActivityPanel : activity
	 * @param isEvent a boolean, true = event, false = activity
	 * @param title title of the window
	 * @param occasion Current Occasion
	 */
	public FormWindow(boolean isEvent, String title, Occasion occasion){
		this.isEvent = isEvent;
		this.title = title;
		container = new JPanel();
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    if(isEvent){
		    this.formEventPanel = new FormEventPanel(occasion);
		    container.add(this.formEventPanel, BorderLayout.CENTER);
	    } else {
		    this.formActivityPanel = new FormActivityPanel(occasion);
		    container.add(this.formActivityPanel, BorderLayout.CENTER);
	    }
	    this.validationPanel = new ValidationPanel();
	    container.add(this.validationPanel, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setTitle(title);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public ValidationPanel getValidationPanel()
	{
		return validationPanel;
	}

	public FormEventPanel getFormEventPanel()
	{
		return formEventPanel;
	}

	public boolean isEvent()
	{
		return isEvent;
	}

	public FormActivityPanel getFormActivityPanel()
	{
		return formActivityPanel;
	}
	
	
}
