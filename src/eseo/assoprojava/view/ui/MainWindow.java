package eseo.assoprojava.view.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import eseo.assoprojava.view.ui.panels.ToolsPanel;
import eseo.assoprojava.view.ui.panels.WorkPanel;

/**
 * 
 * @author baptiste
 *
 */

public class MainWindow extends JFrame {
	public static final String DEFAUT_TITLE = "AssoPro";
	public static final Font DEFAUT_FONT = new Font("Arial", Font.PLAIN, 14);
	public static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
	private static MainWindow mainWindow;
	private static FormWindow currentFormWindow;
	private WorkPanel workPanel;
	private ToolsPanel toolsPanel;

	public MainWindow()
	{
		MainWindow.mainWindow = this;
		this.workPanel = new WorkPanel();
		this.add(this.workPanel, BorderLayout.CENTER);
		this.toolsPanel = new ToolsPanel();
		this.add(this.toolsPanel, BorderLayout.NORTH);
		this.setTitle(DEFAUT_TITLE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // TODO Get confirm ?
		
		this.pack();
	}

	public static MainWindow getInstance()
	{
		if (mainWindow == null)
		{
			mainWindow = new MainWindow();
		}
		return mainWindow;
	}

	public WorkPanel getWorkPanel()
	{
		return this.workPanel;
	}

	public ToolsPanel getToolsPanel()
	{
		return toolsPanel;
	}

	public static FormWindow getCurrentFormWindow()
	{
		return currentFormWindow;
	}

	public static void setCurrentFormWindow(FormWindow currentFormWindow)
	{
		MainWindow.currentFormWindow = currentFormWindow;
	}

	public void setWorkPanel(WorkPanel workPanel)
	{
		this.workPanel = workPanel;
	}

}
