package eseo.assoprojava.view.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import eseo.assoprojava.view.ui.panels.FormPanel;
import eseo.assoprojava.view.ui.panels.ValidationPanel;

public class FormWindow extends JFrame{
	public static final String DEFAUT_TITLE = "Événement";
	private FormWindow formWindow;
	private ValidationPanel validationPanel;
	private FormPanel formPanel;
	
	public FormWindow(){
		this.formPanel = new FormPanel();
		this.add(this.formPanel);
		this.validationPanel = new ValidationPanel();
		this.add(this.validationPanel);
		this.setTitle(DEFAUT_TITLE);
		this.pack();
		this.setSize(new Dimension(this.getFormPanel().getPreferredSize()));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public FormWindow getInstance()
	{
		if (formWindow == null)
		{
			formWindow = new FormWindow();
		}
		return formWindow;
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
