import diet.*;

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
        
        ta.registerUser("MUhammad", "Zeeshan", "muhammadzeesha1670@gmail.com", "+92 336 2322 679");
        ta.registerUser("MUhammad", "Qamar", "muhammadzeesha1670@gmail.com", "+92 336 2322 679");
        ta.registerUser("MUhammad", "Taha", "muhammadzeesha1670@gmail.com", "+92 336 2322 679");
        ta.registerUser("MUhammad", "Ert", "muhammadzeesha1670@gmail.com", "+92 336 2322 679");
        
        ta.users().forEach(user -> System.out.println(user));
        
	}

	
}
