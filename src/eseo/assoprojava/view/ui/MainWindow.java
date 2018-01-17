package eseo.assoprojava.view.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
	private static MainWindow mainWindow;
	private WorkPanel workPanel;
	private ToolsPanel toolsPanel;

	public MainWindow()
	{
		MainWindow.mainWindow = this;
		this.workPanel = new WorkPanel();
		this.add(this.workPanel,BorderLayout.CENTER);
		this.toolsPanel = new ToolsPanel();
		this.add(this.toolsPanel,BorderLayout.NORTH);
		this.setTitle(DEFAUT_TITLE);
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

}
