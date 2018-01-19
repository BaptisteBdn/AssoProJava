package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import eseo.assoprojava.model.event.Event;
import eseo.assoprojava.view.occasion.ViewEvent;

public class WorkPanel extends JPanel{
	/**
	 * @author baptiste
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 1240;
	public static final int DEFAULT_HEIGHT = 1024;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	private ViewEvent viewEvent;

	/**
	 * Default constructor
	 */
	public WorkPanel(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	/**
	 * Set the panel
	 * @param width
	 * @param height
	 * @param color
	 */
	public WorkPanel(int width, int height, Color color){
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(height, width));
		this.setBackground(color);
	}
	
	/**
	 * init the viewEvent
	 */
	public void init(){
		if(this.viewEvent != null  && this.viewEvent.getMainEventPanel() != null && this.viewEvent.getActivitiesPanel() != null){
			this.viewEvent.getMainEventPanel().setVisible(false);
			this.viewEvent.getActivitiesPanel().setVisible(false);
		}
		this.viewEvent = new ViewEvent(new Event());
		this.viewEvent.show();
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
