package diet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;


/**
 * Facade class for the diet management.
 * It allows defining and retrieving raw materials and products.
 *
 */
public class Food {
	
	private TreeMap<String, Items> rawIngredients = new TreeMap<>();
	private TreeMap<String, Items> product = new TreeMap<>();
	private TreeMap<String, Recipe> recipes = new TreeMap<>();
	private TreeMap<String, Menu> menus = new TreeMap<>();

	/**
	 * Define a new raw material.
	 * 
	 * The nutritional values are specified for a conventional 100g amount
	 * @param name 		unique name of the raw material
	 * @param calories	calories per 100g
	 * @param proteins	proteins per 100g
	 * @param carbs		carbs per 100g
	 * @param fat 		fats per 100g
	 */
	public void defineRawMaterial(String name,
									  double calories,
									  double proteins,
									  double carbs,
									  double fat){
		Items ingeredient = new Items(name, calories, proteins, carbs, fat, true);
		rawIngredients.put(name, ingeredient);//for the sake of testing
	}
	
	/**
	 * Retrieves the collection of all defined raw materials
	 * 
	 * @return collection of raw materials though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> rawMaterials(){
		List<NutritionalElement> ingredientsList = new ArrayList<>();
		ingredientsList.addAll(rawIngredients.values());
		return ingredientsList;
	}
	
	/**
	 * Retrieves a specific raw material, given its name
	 * 
	 * @param name  name of the raw material
	 * 
	 * @return  a raw material though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRawMaterial(String name){
		if ( rawIngredients.containsKey(name) ){
			NutritionalElement rawMaterial = rawIngredients.get(name);
			return rawMaterial;
		}
		
		NutritionalElement notFound = new Items(name + " Not Found", 0, 0, 0, 0, false);
		return notFound;
	}

	/**
	 * Define a new packaged product.
	 * The nutritional values are specified for a unit of the product
	 * 
	 * @param name 		unique name of the product
	 * @param calories	calories for a product unit
	 * @param proteins	proteins for a product unit
	 * @param carbs		carbs for a product unit
	 * @param fat 		fats for a product unit
	 */
	public void defineProduct(String name,
								  double calories,
								  double proteins,
								  double carbs,
								  double fat){
		Items item = new Items(name, calories, proteins, carbs, fat, false);
		product.put(name, item);		
	}
	
	/**
	 * Retrieves the collection of all defined products
	 * 
	 * @return collection of products though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> products(){
		List <NutritionalElement> tmp = new ArrayList<>();
		tmp.addAll(product.values());
		return tmp;
	}
	
	/**
	 * Retrieves a specific product, given its name
	 * @param name  name of the product
	 * @return  a product though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getProduct(String name){
		if ( product.containsKey(name) ) {
			NutritionalElement tmp = product.get(name);
			return tmp;
		}
		
		NutritionalElement notFound = new Items(name + " Not Found", 0, 0, 0, 0, false);
		return notFound;
	}
	
	/**
	 * Creates a new recipe stored in this Food container.
	 *  
	 * @param name name of the recipe
	 * 
	 * @return the newly created Recipe object
	 */
	public Recipe createRecipe(String name) {
		Recipe recipe = new Recipe(name, rawIngredients);
		recipes.put(name, recipe);
		
		return recipe;
	}
	
	/**
	 * Retrieves the collection of all defined recipes
	 * 
	 * @return collection of recipes though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> recipes(){
		List<NutritionalElement> ne = new ArrayList<>();
		ne.addAll(recipes.values());
		return ne;
	}
	
	/**
	 * Retrieves a specific recipe, given its name
	 * 
	 * @param name  name of the recipe
	 * 
	 * @return  a recipe though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRecipe(String name){
		NutritionalElement ne = recipes.get(name);
		return ne;
	}
	
	/**
	 * Creates a new menu
	 * 
	 * @param name name of the menu
	 * 
	 * @return the newly created menu
	 */
	public Menu createMenu(String name) {
		Menu menu = new Menu(name, recipes, product);
		menus.put(name, menu);
		return menu;
	}
	
	public Menu getMenu(String name) {
		return menus.get(name);
	}
	
}
