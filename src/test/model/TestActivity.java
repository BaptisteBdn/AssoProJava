package test.model;

import java.util.Date;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.activity.organiser.Organiser;

public class TestActivity {
	
	public static void main(String[] args) {
		// Create two basic activities and display them
		Activity test1 = new Activity();
		Activity test2 = new Activity(new Date(), new Date(), "Soir�e BDE", 0, 100, 2.5, "description de la soir�e", new Organiser());
	
		System.out.println(test1);
		System.out.println(test2);

	}
}
