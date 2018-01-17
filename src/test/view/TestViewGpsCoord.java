package test.view;

import eseo.assoprojava.model.place.gps.GpsCoord;
import eseo.assoprojava.view.occasion.ViewGpsCoord;
import eseo.assoprojava.view.ui.MainWindow;

public class TestViewGpsCoord {
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		
		GpsCoord coord = new GpsCoord(65.21,-56.23);
		
		ViewGpsCoord viewCoord = new ViewGpsCoord(coord);
		
		viewCoord.show();
		mainWindow.setVisible(true);
	}
	

}
