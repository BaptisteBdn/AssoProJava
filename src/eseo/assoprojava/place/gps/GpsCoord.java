package eseo.assoprojava.place.gps;

/**
 * 
 * @author Calvin
 * @version 1.0
 *
 */
public class GpsCoord {
	private double latitude, longitude;
	
	private int latitudeDegree, latitudeMinute;
	private double latitudeSecond;
	
	private int longitudeDegree, longitudeMinute;
	private double longitudeSecond;
	
	private boolean north, east;
	
	/**
	 * Create a basic object
	 */
	public GpsCoord(){
		latitude = longitude = 0.0;
		
		latitudeDegree = latitudeMinute = 0;
		latitudeSecond = 0.0;
		
		longitudeDegree = longitudeMinute = 0;
		longitudeSecond = 0.0;
		
		north = east = true;
	}
	
	/**
	 * Create an object based on the latitude and the longitude passed in Decimal Degrees
	 * @param latitude
	 * @param longitude
	 */
	public GpsCoord(double latitude, double longitude){
		setLatitude(latitude);
		setLongitude(longitude);
		
		DDtoDMS();
	}
	
	/**
	 * Create an object based on the latitude and the longitude passed in Degree Minute Second
	 * @param latitudeDegree
	 * @param latitudeMinute
	 * @param latitudeSecond
	 * @param longitudeDegree
	 * @param longitudeMinute
	 * @param longitudeSecond
	 * @param north
	 * @param east
	 */
	public GpsCoord(int latitudeDegree, int latitudeMinute, double latitudeSecond, int longitudeDegree, int longitudeMinute, double longitudeSecond, boolean north, boolean east){
		setLatitudeDegree(latitudeDegree);
		setLatitudeMinute(latitudeMinute);
		setLatitudeSecond(latitudeSecond);
		
		setLongitudeDegree(longitudeDegree);
		setLongitudeMinute(longitudeMinute);
		setLongitudeSecond(longitudeSecond);
		
		setNorth(north);
		setEast(east);
		
		DMStoDD();
	}
	
	/**
	 * Returns a string representation of the GPS coordinate
	 * @return String str
	 */
	public String toString() {
		
		String str = "DD : [" + String.format("%.2f", latitude) + ", " + String.format("%.2f", longitude) + "] / DMS : [" + latitudeDegree + "°" + latitudeMinute + "'" + String.format("%.2f", latitudeSecond) + "\"";
		
		if(isNorth()){
			str = str + "N";
		} else {
			str = str + "S";
		}
		
		str = str + ", " + longitudeDegree + "°" + longitudeMinute + "'" + String.format("%.2f", longitudeSecond) + "\"";
		
		if(isEast()){
			str = str + "E";
		} else {
			str = str + "W";
		}
		
		str = str + "]";
		
		return str;
	}
	
	/**
	 * Convert a Decimal Degrees GPS coordinate to a Degree Minute Second one
	 */
	public void DDtoDMS(){
		double latitude, longitude;
		
		if(getLatitude() > 0) {
			latitude = getLatitude();
			setNorth(true);
		} else {
			latitude = - getLatitude();
			setNorth(false);
		}
		
		if(getLongitude() > 0) {
			longitude = getLongitude();
			setEast(true);
		} else {
			longitude = - getLongitude();
			setEast(false);
		}
		
		setLatitudeDegree((int) latitude);
		setLatitudeMinute((int) ((latitude - latitudeDegree)*60));
		setLatitudeSecond((latitude - latitudeDegree - (double) latitudeMinute/60)*3600);
		
		setLongitudeDegree((int) longitude);
		setLongitudeMinute((int) ((longitude - longitudeDegree)*60));
		setLongitudeSecond((longitude - longitudeDegree - (double) longitudeMinute/60)*3600);
	}
	
	/**
	 * Convert a Degree Minute Second GPS coordinate to a Decimal Degrees one
	 */
	public void DMStoDD(){
		if(isNorth())
			setLatitude(latitudeDegree + (double) latitudeMinute/60 + (double) latitudeSecond/3600);
		else
			setLatitude(- (latitudeDegree + (double) latitudeMinute/60 + (double) latitudeSecond/3600));
		
		if(isEast())
			setLongitude(longitudeDegree + (double) longitudeMinute/60 + (double) longitudeSecond/3600);
		else
			setLongitude(- ( longitudeDegree + (double) longitudeMinute/60 + (double) longitudeSecond/3600));
	
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getLatitudeDegree() {
		return latitudeDegree;
	}

	public void setLatitudeDegree(int latitudeDegree) {
		this.latitudeDegree = latitudeDegree;
	}

	public int getLatitudeMinute() {
		return latitudeMinute;
	}

	public void setLatitudeMinute(int latitudeMinute) {
		this.latitudeMinute = latitudeMinute;
	}

	public double getLatitudeSecond() {
		return latitudeSecond;
	} 

	public void setLatitudeSecond(double latitudeSecond) {
		this.latitudeSecond = latitudeSecond;
	}

	public int getLongitudeDegree() {
		return longitudeDegree;
	}

	public void setLongitudeDegree(int longitudeDegree) {
		this.longitudeDegree = longitudeDegree;
	}

	public int getLongitudeMinute() {
		return longitudeMinute;
	}

	public void setLongitudeMinute(int longitudeMinute) {
		this.longitudeMinute = longitudeMinute;
	}

	public double getLongitudeSecond() {
		return longitudeSecond;
	}

	public void setLongitudeSecond(double longitudeSecond) {
		this.longitudeSecond = longitudeSecond;
	}

	public boolean isNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}
}
