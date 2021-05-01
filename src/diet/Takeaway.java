package diet;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents the main class in the
 * take-away system.
 * 
 * It allows adding restaurant, users, and creating orders.
 *
 */
public class Takeaway {
	
	private List<Restaurant> restaurants = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	/**
	 * Adds a new restaurant to the take-away system
	 * 
	 * @param r the restaurant to be added
	 */
	public void addRestaurant(Restaurant r) {
		restaurants.add(r);
	}
	
	/**
	 * Returns the collections of restaurants
	 * 
	 * @return collection of added restaurants
	 */
	public Collection<String> restaurants() {
		List<String> r = new ArrayList<>();
		restaurants.forEach(res -> r.add(res.getName()));
		return r;
	}
	
	/**
	 * Define a new user
	 * 
	 * @param firstName first name of the user
	 * @param lastName  last name of the user
	 * @param email     email
	 * @param phoneNumber telephone number
	 * @return
	 */
	public User registerUser(String firstName, String lastName, String email, String phoneNumber) {
		User user = new User(firstName, lastName);
		user.SetEmail(email);
		user.setPhone(phoneNumber);
		users.add(user);
		users.sort(null);
		return user;
	}
	
	/**
	 * Gets the collection of registered users
	 * 
	 * @return the collection of users
	 */
	public Collection<User> users(){
		return users;
	}
	
	/**
	 * Create a new order by a user to a given restaurant.
	 * 
	 * The order is initially empty and is characterized
	 * by a desired delivery time. 
	 * 
	 * @param user				user object
	 * @param restaurantName	restaurant name
	 * @param h					delivery time hour
	 * @param m					delivery time minutes
	 * @return newly created order
	 */
	public Order createOrder(User user, String restaurantName, int h, int m) {
		return null;
	}
	
	/**
	 * Retrieves the collection of restaurant that are open
	 * at the given time.
	 * 
	 * @param time time to check open
	 * 
	 * @return collection of restaurants
	 */
	public Collection<Restaurant> openedRestaurants(String time){
		return null;
	}

	
	
}
