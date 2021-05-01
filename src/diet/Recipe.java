package diet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	private String name;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	private double recipeQuantity;
	private boolean per100 = true;
	Map<String, Items> items = new TreeMap<>();
	
	Map<String, Double> ingredients = new HashMap<>();	
	
	Recipe (String name, TreeMap<String, Items> rawIngredients){
		this.name = name;
		this.items = rawIngredients;
	}
	
	
	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {
		ingredients.put(material, quantity);
		nutritionCalculator(material, quantity);
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCalories() {
		return calories / recipeQuantity * 100;
	}

	@Override
	public double getProteins() {
		return proteins / recipeQuantity * 100;
	}

	@Override
	public double getCarbs() {
		return carbs / recipeQuantity * 100;
	}

	@Override
	public double getFat() {
		return fat / recipeQuantity * 100;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return per100;
	}
	
	
	/**
	 * Returns the ingredients composing the recipe.
	 * 
	 * A string that contains all the ingredients, one per per line, 
	 * using the following format:
	 * {@code "Material : ###.#"} where <i>Material</i> is the name of the 
	 * raw material and <i>###.#</i> is the relative quantity. 
	 * 
	 * Lines are all terminated with character {@code '\n'} and the ingredients 
	 * must appear in the same order they have been added to the recipe.
	 */
	@Override
	public String toString() {
		String str = "";
		for (Map.Entry<String, Double> i: ingredients.entrySet()) {
			str += String.format("%s : %3.1f\n", i.getKey(), i.getValue()/recipeQuantity*100);
		}
		return str;
	}
	
	void nutritionCalculator(String itemName, double quantity) {
		Items i = items.get(itemName);
		recipeQuantity += quantity;
		quantity /= 100;
		calories += i.getCalories() * quantity;
		proteins += i.getProteins() * quantity;
		carbs += i.getCarbs() * quantity;
		fat += i.getFat() * quantity;
	}
}
