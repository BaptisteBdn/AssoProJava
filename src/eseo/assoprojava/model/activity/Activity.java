package eseo.assoprojava.model.activity;

import java.util.Date;

import eseo.assoprojava.model.Occasion;
import eseo.assoprojava.model.activity.organiser.Organiser;


/**
 * 
 * @author Suline
 * @version 1.0
 *
 */
public class Activity extends Occasion {
	private String description;
	private Organiser organiser;
	
	/**
	 * Create a basic object
	 */
	public Activity() {
		super();
		this.description = "Description";
		this.organiser = new Organiser();
	}
	
	/**
	 * Create an object based on the parameters
	 * @param dateBegin beginning date and time of the activity
	 * @param dateEnd ending date and time of the activity
	 * @param name name of the activity
	 * @param numberMinimum minimum number of participants of the activity
	 * @param numberMaximum maximum number of participants of the activity
	 * @param price price of the activity
	 * @param description description of the activity
	 * @param organiser name of the person who organise the activity
	 */
	public Activity(Date dateBegin, Date dateEnd, String name, int numberMinimum, int numberMaximum, double price, String description, Organiser organiser) {
		super(dateBegin, dateEnd, name, numberMinimum, numberMaximum, price);
		this.description = description;
		this.organiser = organiser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organiser getOrganiser() {
		return organiser;
	}

	public void setOrganiser(Organiser organiser) {
		this.organiser = organiser;
	}

	/**
	 * Returns a textual representation of the Occasion
	 * @return String
	 */
	@Override
	public String toString() {
		return "Activity [description=" + description + ", organiser=" + organiser + ", getDateBegin()="
				+ getDateBegin() + ", getDateEnd()=" + getDateEnd() + ", getName()=" + getName()
				+ ", getNumberMinimum()=" + getNumberMinimum() + ", getNumberMaximum()=" + getNumberMaximum()
				+ ", getPrice()=" + getPrice() + "]";
	}

}