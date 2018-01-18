package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import eseo.assoprojava.view.occasion.ViewEvent;

/**
 * 
 * @author baptiste
 *
 */

public class WorkPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 1240;
	public static final int DEFAULT_HEIGHT = 1024;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	private ViewEvent viewEvent;

	public WorkPanel(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	public WorkPanel(int width, int height, Color color){
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(height, width));
		this.setBackground(color);
		this.setViewEvent(null);
	}

	public ViewEvent getViewEvent()
	{
		return viewEvent;
	}

	public void setViewEvent(ViewEvent viewEvent)
	{
		this.viewEvent = viewEvent;
	}
}
