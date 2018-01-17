package eseo.assoprojava.view.ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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

	public WorkPanel(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	public WorkPanel(int width, int height, Color color){
		this.setLayout(new GridBagLayout());
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
