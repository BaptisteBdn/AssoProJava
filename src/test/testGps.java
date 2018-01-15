package test;
import eseo.assoprojava.model.place.gps.GpsCoord;

public class testGps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GpsCoord test1= new GpsCoord();
		GpsCoord test2= new GpsCoord(52.25,-66.2);
		GpsCoord test3= new GpsCoord(12,54,23.21,25,36,45.21,true,false);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
	}

}
