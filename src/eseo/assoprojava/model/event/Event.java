package eseo.assoprojava.model.event;
/**
 * 
 * @author Lucien
 * @version 1.0
 *
 */
import eseo.assoprojava.model.Occasion;
import eseo.assoprojava.model.activity.Activity;
import eseo.assoprojava.model.event.place.Place;

import java.util.List;
import java.util.ArrayList;

import java.util.Date;

public class Event extends Occasion {
	private Place place;
	private String clubOrganiser;
	private List<Activity> activities;
	private String description;
	
	/**
	 * Create a basic object
	 */
	public Event() {
		super();
		this.place = new Place();
		this.clubOrganiser = "Unknown";
		this.activities = new ArrayList<Activity> ();
		this.description = "Unknown";
	}
	
	/**
	 * Create an object based on the parameters
	 * @param place place of the event
	 * @param dateBegin beginning date of the event
	 * @param dateEnd ending date of the event
	 * @param name name of the event
	 * @param numberMinimum minimum number of participants of the event
	 * @param numberMaximum maximum number of participants of the event
	 * @param clubOrganiser organiser club of the event
	 * @param price price of the event
	 * @param activities activities include in the event
	 * @param description description of the event
	 */
	public Event(Place place, Date dateBegin, Date dateEnd, String name, int numberMinimum, int numberMaximum, String clubOrganiser, double price, List<Activity> activities, String description) {
		super(dateBegin, dateEnd, name, numberMinimum, numberMaximum, price);
		this.place = place;
		this.clubOrganiser = clubOrganiser;
		this.activities = activities;
		this.description = description;
	}

	/**
	 * Add an activity in the list of activities
	 * @param activity activity to add
	 */
	public void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	/**
	 * Remove an activity in the list of activities
	 * @param activity activity to remove
	 */
	public void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	/**
	 * Get the index of the activity in the List
	 * @param activity activity
	 * @return indexOfActivity
	 * @author baptiste
	 */
	public int getIndexOfActivity(Activity activity){
		return activities.indexOf(activity);
	}
	
	/**
	 * Replace an activity at an index
	 * @param index new index of an activity
	 * @param activity to replace
	 * @author baptiste
	 */
	public void setActivity(int index, Activity activity){
		activities.set(index, activity);
	}
	/**
	 * Returns the String representation of the event
	 * @return String the representation of the event
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
