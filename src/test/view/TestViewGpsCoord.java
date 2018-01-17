package test.view;

import javax.swing.JFrame;

import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.occasion.ViewGpsCoord;
import eseo.assoprojava.view.ui.MainWindow;

public class TestViewGpsCoord {
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		
		GpsCoord coord = new GpsCoord(65.21,-56.23);
		
		ViewGpsCoord viewGpsCoord = new ViewGpsCoord(coord);
		viewGpsCoord.show(MainWindow.getInstance().getWorkPanel());
		
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TODO Get confirm ?
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
	

}
