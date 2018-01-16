package eseo.assoprojava.model.organiser;
/**
 * 
 * @author Lucien
 * @version 1.0
 *
 */
public class Organiser {
	public String firstName;
	public String lastName;
	public String club;
	public String role;
	
	/**
	 * Create a default organiser
	 */
	public Organiser() {
		this.firstName="Unknow";
		this.lastName="Unknow";
		this.club="Unknow";
		this.role="Unknow";
	}
	
	/**
	 * Create an organiser with his full name, his club and his role
	 * @param firstName
	 * @param lastName
	 * @param club
	 * @param role
	 */
	public Organiser(String firstName, String lastName, String club, String role) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.club=club;
		this.role=role;
	}
	
	/**
	 * Returns a string with the first name, the last name, the club and the organiser role
	 * @return String organiser
	 */
	public String toString() {
		String organiser = firstName + " " + lastName + " " + club + " " + role;
		return organiser;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}