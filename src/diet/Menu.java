package diet;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	@Override
	public String toString() {
		return "Menu {recipe=" + recipe + ", quantityR=" + quantityR+"} Product = " + product;
	}

	private String name;
	@SuppressWarnings("unused")
	private String recipe;
	@SuppressWarnings("unused")
	private double quantityR;
	@SuppressWarnings("unused")
	private String product;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	
	private Map<String, Recipe> r = new TreeMap<>();
	private Map<String, Items> p = new TreeMap<>();
	
	Menu (String name, TreeMap<String, Recipe>  r, TreeMap<String, Items> p){
		this.name = name;
		this.r = r;
		this.p = p;
	}
	/**
	 * Adds a given serving size of a recipe.
	 * 
	 * The recipe is a name of a recipe defined in the
	 * {@Link Food} in which this menu has been defined.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	public Menu addRecipe(String recipe, double quantity) {
		this.recipe = recipe;
		quantityR = quantity;
		quantity /= 100;
		calories += r.get(recipe).getCalories() * quantity;
		proteins += r.get(recipe).getProteins() * quantity;
		carbs += r.get(recipe).getCarbs() * quantity;
		fat += r.get(recipe).getFat() * quantity;
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the
	 * {@Link Food} in which this menu has been defined.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
	public Menu addProduct(String product) {
		this.product = product;
		calories += p.get(product).getCalories();
		proteins += p.get(product).getProteins();
		carbs += p.get(product).getCarbs();
		fat += p.get(product).getFat();
		return this;
	}

	/**
	 * Name of the menu
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		return calories;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		return proteins;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		return carbs;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		return fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean 	indicator
	 */
	@Override
	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
