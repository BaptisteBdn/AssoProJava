package eseo.assoprojava.view.ui.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import eseo.assoprojava.view.occasion.ViewEvent;
import eseo.assoprojava.view.occasion.ViewGpsCoord;
import eseo.assoprojava.view.occasion.ViewOrganiser;
import eseo.assoprojava.view.occasion.ViewPlace;

/**
 * 
 * @author baptiste
 *
 */

public class WorkPanel extends JPanel{
	public static final int DEFAULT_WIDTH = 1240;
	public static final int DEFAULT_HEIGHT = 1024;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	private ViewEvent viewEvent;
	private ViewOrganiser viewOrganiser;
	private ViewPlace viewPlace;
	private ViewGpsCoord viewGpsCoord;

	public WorkPanel(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	public WorkPanel(int width, int height, Color color){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH));
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

	public ViewOrganiser getViewOrganiser()
	{
		return viewOrganiser;
	}

	public void setViewOrganiser(ViewOrganiser viewOrganiser)
	{
		this.viewOrganiser = viewOrganiser;
	}

	public ViewPlace getViewPlace()
	{
		return viewPlace;
	}

	public void setViewPlace(ViewPlace viewPlace)
	{
		this.viewPlace = viewPlace;
	}

	public ViewGpsCoord getViewGpsCoord()
	{
		return viewGpsCoord;
	}

	public void setViewGpsCoord(ViewGpsCoord viewGpsCoord)
	{
		this.viewGpsCoord = viewGpsCoord;
	}
}
