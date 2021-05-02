package diet;

/**
 * Represent a take-away system user
 *  
 */
public class User implements Comparable<User>{
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	/**
	 * 
	 * @param firstName user's first name
	 * @param lastName user's last name
	 * @return null
	 */
	public User (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
		
	/**
	 * get user's last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * get user's first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * get user's email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * get user's phone number
	 * @return  phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * change user's email
	 * @param email new email
	 */
	public void SetEmail(String email) {
		this.email = email;
	}
	
	/**
	 * change user's phone number
	 * @param phone new phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		int result = this.firstName.compareTo(o.firstName);
		result = result == 0 ? this.lastName.compareTo(o.lastName) : result;
		return result;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
	
	
}
