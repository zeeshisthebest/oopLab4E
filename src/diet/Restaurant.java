package diet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import diet.Order.OrderStatus;

/**
 * Represents a restaurant in the take-away system
 *
 */
public class Restaurant {
	private String name;
	private Food food;
	private List<String> timings = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private Map<String, Menu> menus = new TreeMap<>();
	
	/**
	 * Constructor for a new restaurant.
	 * 
	 * Materials and recipes are taken from
	 * the food object provided as argument.
	 * 
	 * @param name	unique name for the restaurant
	 * @param food	reference food object
	 */
	public Restaurant(String name, Food food) {
		// TODO: implement constructor
		this.name = name;
		this.food = food;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHours(String ... hm) {
		for(String str: hm) {
			timings.add(str);
		}
	}
	
	public Menu getMenu(String name) {
		return menus.get(name);
	}
	
	/**
	 * Creates a new menu
	 * 
	 * @param name name of the menu
	 * 
	 * @return the newly created menu
	 */
	public Menu createMenu(String name) {
		Menu m = food.createMenu(name);
		menus.put(name, m);
		return m;
	}

	/**
	 * Find all orders for this restaurant with 
	 * the given status.
	 * 
	 * The output is a string formatted as:
	 * <pre>
	 * Napoli, Judi Dench : (19:00):
	 * 	M6->1
	 * Napoli, Ralph Fiennes : (19:00):
	 * 	M1->2
	 * 	M6->1
	 * </pre>
	 * 
	 * The orders are sorted by name of restaurant, name of the user, and delivery time.
	 * 
	 * @param status the status of the searched orders
	 * 
	 * @return the description of orders satisfying the criterion
	 */
	public String ordersWithStatus(OrderStatus status) {
		return null;
	}
	
	/**
	 * @param user 	user object
	 * @param h		hours
	 * @param m		minutes
	 */
	public Order addOrderForRestaurant(User user, int h, int m) {
		Order o = new Order(user, this.name, h, m);
		orders.add(o);
		return o;
	}
	
	public String toString() {
		return name + getTiming() + getMenus();
	}
	
	String getTiming() {
		return ": Opens from " + timings.get(0) +
				" to " + timings.get(1) +
				" and from " + timings.get(2) +
				" to " +  timings.get(3) + ". ";
	}
	
	String getMenus() {
		String str = "\n";
		for(Map.Entry<String, Menu> m : menus.entrySet()) {
			str += "Menu " + m.getKey() + " " + m.getValue() + "\n";
		}
		return str;
	}
}
