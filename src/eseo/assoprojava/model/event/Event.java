package eseo.assoprojava.model.event;
/**
 * 
 * @author Lucien
 * @version 1.0
 *
 */
import eseo.assoprojava.model.Occasion;
import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.place.Place;

import java.util.List;
import java.util.ArrayList;

import java.util.Date;

public class Event extends Occasion {
	private Place place;
	private String clubOrganiser;
	private List<Activity> activities;
	
	/**
	 * Create a basic object
	 */
	public Event() {
		super();
		this.place = new Place();
		this.clubOrganiser = "Unknown";
		this.activities = new ArrayList<Activity> ();
	}
	
	/**
	 * Create an object based on the parameters
	 * @param place
	 * @param dateBegin
	 * @param dateEnd
	 * @param name
	 * @param numberMinimum
	 * @param numberMaximum
	 * @param clubOrganiser
	 * @param price
	 * @param activities
	 */
	public Event(Place place, Date dateBegin, Date dateEnd, String name, int numberMinimum, int numberMaximum, String clubOrganiser, int price, List<Activity> activities) {
		super();
		this.place = place;
		this.clubOrganiser = clubOrganiser;
		this.activities = activities;
		
	}

	/**
	 * Add an activity in the list of activities
	 * @param activity
	 */
	public void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	/**
	 * Remove an activity in the list of activities
	 * @param activity
	 */
	public void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	/**
	 * Returns the String representation of the event
	 * @return String
	 */
	@Override
	public String toString() {
		return "Event [place=" + place + ", clubOrganiser=" + clubOrganiser + ", activities=" + activities
				+ ", getDateBegin()=" + getDateBegin() + ", getDateEnd()=" + getDateEnd() + ", getName()=" + getName()
				+ ", getNumberMinimum()=" + getNumberMinimum() + ", getNumberMaximum()=" + getNumberMaximum()
				+ ", getPrice()=" + getPrice() + "]";
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getClubOrganiser() {
		return clubOrganiser;
	}

	public void setClubOrganiser(String clubOrganiser) {
		this.clubOrganiser = clubOrganiser;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
