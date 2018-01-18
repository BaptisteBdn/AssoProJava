package eseo.assoprojava.model.place;

import eseo.assoprojava.model.place.gps.GpsCoord;

/**
 * 
 * @author Calvin
 * @version 1.0
 *
 */
public class Place {

	int number, postalCode;
	String street, city, country, name, state;
	GpsCoord gpsCoord;

	/**
	 * Create an empty object
	 */
	public Place()
	{
		number = 0;
		postalCode = 0;
		street = "Rue";
		city = "Ville";
		country = "Pays";
		name = "Nom";
		state = "Région";
		gpsCoord = new GpsCoord();
	}

	/**
	 * Create an object with the passed variables
	 * 
	 * @param number
	 * @param street
	 * @param city
	 * @param country
	 * @param postalCode
	 * @param gpsCoord
	 * @param name
	 */
	public Place(int number, String street, String city, String state, String country, int postalCode, GpsCoord gpsCoord, String name)
	{
		setNumber(number);
		setStreet(street);
		setCity(city);
		setState(state);
		setCountry(country);
		setPostalCode(postalCode);
		setGpsCoord(gpsCoord);
		setName(name);
	}

	@Override
	/**
	 * Returns a string representation of the place
	 * 
	 * @return String str
	 */
	public String toString()
	{
		return name + " at " + number + " " + street + ", " + city + ", " + state + ", " + country + ", " + postalCode + " (" + gpsCoord + ")";

	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public int getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(int postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public GpsCoord getGpsCoord()
	{
		return gpsCoord;
	}

	public void setGpsCoord(GpsCoord gpsCoord)
	{
		this.gpsCoord = gpsCoord;
	}
}
