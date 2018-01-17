package eseo.assoprojava.view.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import eseo.assoprojava.view.ui.panels.FormActivityPanel;
import eseo.assoprojava.view.ui.panels.FormPanel;
import eseo.assoprojava.view.ui.panels.ValidationPanel;

public class FormWindow extends JFrame{
	public static final String DEFAUT_TITLE = "Événement";
	private JPanel container;
	private FormWindow formWindow;
	private ValidationPanel validationPanel;
	private FormPanel formPanel;
	private FormActivityPanel formActivityPanel;
	
	public FormWindow(boolean isEvent){
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
		this.setTitle(DEFAUT_TITLE);
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
	
	
}
