package diet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents an order in the take-away system
 */
public class Order {
	private User user;
	private String restaurant;
	private int h;
	private int m;
	private OrderStatus orderStatus;
	private PaymentMethod paymentMethod;
	private Map<String, Integer> menus = new TreeMap<>();
	

	/**
	 * @param user user object
	 * @param r name of the restaurant
	 * @param h hour
	 * @param m minute
	 * @return none
	 */
	public Order(User user, String r, int h, int m) {
		this.user = user;
		this.h = h;
		this.m = m;
		this.restaurant = r;
	}
 
	/**
	 * Defines the possible order status
	 */
	public enum OrderStatus {
		ORDERED, READY, DELIVERED;
	}
	/**
	 * Defines the possible valid payment methods
	 */
	public enum PaymentMethod {
		PAID, CASH, CARD;
	}
		
	/**
	 * Total order price
	 * @return order price
	 */
	public double Price() {
		return -1.0;
	}
	
	/**
	 * define payment method
	 * 
	 * @param method payment method
	 */
	public void setPaymentMethod(PaymentMethod method) {
		paymentMethod = method;
	}
	
	
	/**
	 * get payment method
	 * 
	 * @return payment method
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod != null ? paymentMethod : PaymentMethod.CASH;
	}
	
	/**
	 * change order status
	 * @param newStatus order status
	 */
	public void setStatus(OrderStatus newStatus) {
		orderStatus = newStatus;
	}
	
	
	/**
	 * get current order status
	 * @return order status
	 */
	public OrderStatus getStatus(){
		return orderStatus != null ? orderStatus : OrderStatus.ORDERED;
	}
	
	/**
	 * Add a new menu with the relative order to the order.
	 * The menu must be defined in the {@link Food} object
	 * associated the restaurant that created the order.
	 * 
	 * @param menu     name of the menu
	 * @param quantity quantity of the menu
	 * @return this order to enable method chaining
	 */
	public Order addMenus(String menu, int quantity) {
		menus.put(menu, quantity);
		return this;
	}
	
	/**
	 * Converts to a string as:
	 * <pre>
	 * RESTAURANT_NAME, USER_FIRST_NAME USER_LAST_NAME : DELIVERY(HH:MM):
	 * 	MENU_NAME_1->MENU_QUANTITY_1
	 * 	...
	 * 	MENU_NAME_k->MENU_QUANTITY_k
	 * </pre>
	 */
	@Override
	public String toString() {
		String str = "";
		str += "\"" + restaurant + ", " + user + " : Delivery(" + String.format("%02d:%02d):", h, m); 
		
		for(Map.Entry<String, Integer> m: menus.entrySet()) {
				str += "\n\t" + m.getKey() + "->" + m.getValue();
		}
		
		str +="\n\"";
		return str;
	}
	
	
}
