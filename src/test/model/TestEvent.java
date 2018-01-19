package test.model;

import java.util.Date;

import eseo.assoprojava.model.event.place.Place;
import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.Event;

import java.util.List;
import java.util.ArrayList;

public class TestEvent {

	public static void main(String[] args) {
		// Create two basic events and display them
		Event test1 = new Event();
		List<Activity> activities = new ArrayList<Activity> ();
		Event test2 = new Event(new Place(), new Date(), new Date(), "Concours Photos", 0, 100, "STUDIO ESEO", 3, activities,"Desciption");
	
		
		System.out.println(test1);
		System.out.println(test2);

	}
}
