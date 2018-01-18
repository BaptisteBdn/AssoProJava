package eseo.assoprojava.view.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import eseo.assoprojava.view.ui.panels.FormActivityPanel;
import eseo.assoprojava.view.ui.panels.FormPanel;
import eseo.assoprojava.view.ui.panels.ValidationPanel;

public class FormWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String title = "Événement";
	private JPanel container;
	private boolean isEvent;
	private ValidationPanel validationPanel;
	private FormPanel formPanel;
	private FormActivityPanel formActivityPanel;
	
	public FormWindow(boolean isEvent, String title){
		this.isEvent = isEvent;
		this.title = title;
		container = new JPanel();
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    if(isEvent){
		    this.formPanel = new FormPanel();
		    container.add(this.formPanel, BorderLayout.CENTER);
	    } else {
		    this.formActivityPanel = new FormActivityPanel();
		    container.add(this.formActivityPanel, BorderLayout.CENTER);
	    }
	    this.validationPanel = new ValidationPanel();
	    container.add(this.validationPanel, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setTitle(title);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public ValidationPanel getValidationPanel()
	{
		return validationPanel;
	}

	public FormPanel getFormPanel()
	{
		return formPanel;
	}

	public boolean isEvent()
	{
		return isEvent;
	}
	
	
}
