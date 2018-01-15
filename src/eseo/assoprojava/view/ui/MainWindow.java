package eseo.assoprojava.view.ui;

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
	private MainWindow mainWindow;
	private WorkPanel workPanel;
	private ToolsPanel toolsPanel;
	
	public MainWindow(){
		this.workPanel = new WorkPanel();
		this.add(this.workPanel);
		this.toolsPanel = new ToolsPanel();
		this.add(this.toolsPanel);
		this.setTitle(DEFAUT_TITLE);
		this.setLocationRelativeTo(null);
	}
	
	public MainWindow getInstance(){
		if(mainWindow == null){
			mainWindow = new MainWindow();
		}
		return mainWindow;
	}


}
