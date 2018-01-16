package test.model;

import java.util.Date;

import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.organiser.Organiser;

public class TestActivity {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity test1 = new Activity();
		Activity test2 = new Activity(new Date(), new Date(), "Soirée BDE", 0, 100, 2.5, "description de la soirée", new Organiser());
	
		System.out.println(test1);
		System.out.println(test2);

	}
}
