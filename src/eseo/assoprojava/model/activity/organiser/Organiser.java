package eseo.assoprojava.model.activity.organiser;
/**
 * 
 * @author Lucien
 * @version 1.0
 *
 */
public class Organiser {
	private String firstName;
	private String lastName;
	private String club;
	private String role;
	
	/**
	 * Create a default organiser
	 */
	public Organiser() {
		this.firstName="Prénom";
		this.lastName="Nom";
		this.club="Club";
		this.role="Rôle";
	}
	
	/**
	 * Create an organiser with his full name, his club and his role
	 * @param firstName first name of the organiser
	 * @param lastName last name of the organiser
	 * @param club club name of the organiser
	 * @param role role of the organisre
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