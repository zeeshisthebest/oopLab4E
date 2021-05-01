package diet;

public class Items implements NutritionalElement{
	private String name;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	private boolean per100;
	
	Items (String name, double calories, double proteins,
						double carbs, double fat, boolean per100){
		this.name = name;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.fat = fat;
		this.per100 = per100;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getCalories() {
		// TODO Auto-generated method stub
		return calories;
	}

	@Override
	public double getProteins() {
		// TODO Auto-generated method stub
		return proteins;
	}

	@Override
	public double getCarbs() {
		// TODO Auto-generated method stub
		return carbs;
	}

	@Override
	public double getFat() {
		// TODO Auto-generated method stub
		return fat;
	}

	@Override
	public boolean per100g() {
		// TODO Auto-generated method stub
		return per100;
	}

}
