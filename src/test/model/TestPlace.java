package test.model;
import eseo.assoprojava.model.event.place.Place;
import eseo.assoprojava.model.event.place.gps.GpsCoord;

public class TestPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Place test1 = new Place();
		Place test2 = new Place(12, "rue George Grégaint", "Angers", "Maine et Loire", "France", 49100, new GpsCoord(42.56,-85.2), "Party time");
	
		System.out.println(test1);
		System.out.println(test2);
	}

}
