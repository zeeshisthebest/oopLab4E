import diet.*;
import diet.Order.OrderStatus;
import diet.Order.PaymentMethod;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food foods = new Food();
		Restaurant r = new Restaurant("Pizzeria", foods);
		r.setHours( "08:15", "14:00", "19:00", "00:00");
		
		Restaurant r2 = new Restaurant("Fark", foods);
		r2.setHours( "08:15", "14:00", "19:00", "00:00");
		
		foods.defineRawMaterial("Onion", 40, 3, 20.3, 1);
        foods.defineProduct("Crackers", 111, 2.6, 17.2, 3.5);
        foods.defineProduct("Crackers2", 222, 2.6, 17.2, 3.5);
        
        foods.createRecipe("recipe").addIngredient("Onion", 100);
        
        foods.createMenu("menu1").addRecipe("recipe" , 100).addProduct("Crackers");
        foods.createMenu("menu2").addRecipe("recipe" , 50).addProduct("Crackers");
        
        r.createMenu("menu1").addProduct("Crackers2");
        r2.createMenu("menu1");
        r2.createMenu("menu2");
        
        System.out.println(r);
        System.out.println(r2);
        
        Takeaway ta = new Takeaway();
        ta.addRestaurant(r);
        ta.addRestaurant(r2);
        System.out.println(ta.restaurants().toString());
        
        User mz = ta.registerUser("MUhammad", "Zeeshan", "muhammadzeesha1670@gmail.com", "+92 336 2322 679");
        User zm = ta.registerUser("Zeeshan", "Muhammad", "muhammadzeesha1670@gmail.com", "+92 336 2322 679");
     
        
        ta.users().forEach(user -> System.out.println(user));
        
        
        String time1 = compareTime("09:00", "12:00", "17:00", "20:00",  "10:00");
        String time2 = compareTime("09:00", "12:00", "17:00", "20:00",  "19:00");
        String time3 = compareTime("09:00", "12:00", "17:00", "20:00",  "08:00");
        String time4 = compareTime("09:00", "12:00", "17:00", "20:00",  "15:00");
        String time5 = compareTime("09:00", "12:00", "17:00", "20:00",  "23:00");
        
        System.out.println(time1 + " " + time2 + " " + time3 + " " + time4 + " " + time5);
	}

	public static String compareTime(String oh1, String ch1, String oh2, String ch2, String ct) {
		System.out.println(oh1.compareTo(ct) + " " + ch2.compareTo(ct));
		if (ch2.compareTo(ct) <= 0 && oh1.compareTo(ct) > 0) {
			return oh1;
		} else if (ch1.compareTo(ct) <= 0 && oh2.compareTo(ct) > 0) {
			return oh2;
		}
		
		return ct;
	}
	
}
