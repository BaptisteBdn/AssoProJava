package eseo.assoprojava.model;

import java.util.Date;

/**
 * 
 * @author Suline
 * @version 1.0
 *
 */
public abstract class Occasion {

	private Date dateBegin;
	private Date dateEnd;
	private String name;
	private int numberMinimum;
	private int numberMaximum;
	private double price;
	
	/**
	 * Create a basic object
	 */
	public Occasion() {
		this.dateBegin = new Date();
		this.dateEnd = new Date();
		this.name = "unknown";
		this.numberMinimum = 0;
		this.numberMaximum = 0;
		this.price = 0;
	}

	/**
	 * Create an object based on the parameters
	 * @param dateBegin beginning date and time of the occasion
	 * @param dateEnd ending date and time of the occasion
	 * @param name name of the occasion
	 * @param numberMinimum the minimum number of participants
	 * @param numberMaximum the maximum number of participants
	 * @param price the price of the occasion
	 */
	public Occasion(Date dateBegin, Date dateEnd, String name, int numberMinimum, int numberMaximum, double price) {
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.name = name;
		this.numberMinimum = numberMinimum;
		this.numberMaximum = numberMaximum;
		this.price = price;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberMinimum() {
		return numberMinimum;
	}

	public void setNumberMinimum(int numberMinimum) {
		this.numberMinimum = numberMinimum;
	}

	public int getNumberMaximum() {
		return numberMaximum;
	}

	public void setNumberMaximum(int numberMaximum) {
		this.numberMaximum = numberMaximum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Returns a textual representation of the Occasion
	 * @return String 
	 */
	@Override
	public String toString() {
		return "Occasion [dateBegin=" + dateBegin + ", dateEnd=" + dateEnd + ", name=" + name + ", numberMinimum="
				+ numberMinimum + ", numberMaximum=" + numberMaximum + ", price=" + price + "]";
	}

}
