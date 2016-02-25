package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

public class DinnerModel extends Observable implements IDinnerModel {
	

	Set<Dish> dishes = new HashSet<Dish>();
	private int numberOfGuests;
	private Set<Dish> fullMenu = new HashSet<Dish>();
	
	/**
	 * TODO: For Lab2 you need to implement the IDinnerModel interface.
	 * When you do this you will have all the needed fields and methods
	 * for the dinner planner (number of guests, selected dishes, etc.). 
	 */
	
	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel(){
		
		//Adding some example data, you can add more
		Dish dish1 = new Dish("French toast",Dish.STARTER,"toast.jpg","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
		Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
		Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
		Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
		Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
		dish1.addIngredient(dish1ing1);
		dish1.addIngredient(dish1ing2);
		dish1.addIngredient(dish1ing3);
		dish1.addIngredient(dish1ing4);
		dish1.addIngredient(dish1ing5);
		dishes.add(dish1);

		Dish dish11 = new Dish("Chicken",Dish.STARTER,"chicken.jpg","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing11 = new Ingredient("eggs",0.5,"",1);
		Ingredient dish1ing21 = new Ingredient("milk",30,"ml",6);
		Ingredient dish1ing31 = new Ingredient("brown sugar",7,"g",1);
		Ingredient dish1ing41 = new Ingredient("ground nutmeg",0.5,"g",12);
		Ingredient dish1ing51 = new Ingredient("white bread",2,"slices",2);
		dish11.addIngredient(dish1ing11);
		dish11.addIngredient(dish1ing21);
		dish11.addIngredient(dish1ing31);
		dish11.addIngredient(dish1ing41);
		dish11.addIngredient(dish1ing51);
		dishes.add(dish11);
		
		Dish dish2 = new Dish("Meat balls",Dish.MAIN,"meatballs.jpg","Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
		Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
		Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
		Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
		Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
		Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
		Ingredient dish2ing7 = new Ingredient("red pepper flakes",0.6,"g",3);
		Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
		Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
		Ingredient dish2ing10 = new Ingredient("Parmesan cheese",5,"g",8);
		Ingredient dish2ing11 = new Ingredient("bread crumbs",115,"g",4);
		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);
		dish2.addIngredient(dish2ing4);
		dish2.addIngredient(dish2ing5);
		dish2.addIngredient(dish2ing6);
		dish2.addIngredient(dish2ing7);
		dish2.addIngredient(dish2ing8);
		dish2.addIngredient(dish2ing9);
		dish2.addIngredient(dish2ing10);
		dish2.addIngredient(dish2ing11);
		dishes.add(dish2);

		Dish dish3 = new Dish("Ice Cream",Dish.DESERT,"icecream.jpg","In a medium bowl, mix together the brown sugar, white sugar, and butter until smooth. Stir in vanilla and water. Mix in the flour until well blended. Shape into a loaf or log, and freeze for 1 to 2 hours.");
		Ingredient dish3ing1 = new Ingredient("all-purpose flour",0.5,"",1);
		Ingredient dish3ing2 = new Ingredient("milk",30,"ml",6);
		Ingredient dish3ing3 = new Ingredient("vanilla extract",2,"spoons",1);
		Ingredient dish3ing4 = new Ingredient("butter",0.5,"g",12);
		Ingredient dish3ing5 = new Ingredient("white sugar",2,"spoons",2);
		dish3.addIngredient(dish3ing1);
		dish3.addIngredient(dish3ing2);
		dish3.addIngredient(dish3ing3);
		dish3.addIngredient(dish3ing4);
		dish3.addIngredient(dish3ing5);
		dishes.add(dish3);

	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishes(){
		return dishes;
	}
	
	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
	 */
	public Set<Dish> getDishesOfType(int type){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type){
				result.add(d);
			}
		}
		return result;
	}
	
	/**
	 * Returns the set of dishes of specific type, that contain filter in their name
	 * or name of any ingredient. 
	 */
	public Set<Dish> filterDishesOfType(int type, String filter){
		Set<Dish> result = new HashSet<Dish>();
		for(Dish d : dishes){
			if(d.getType() == type && d.contains(filter)){
				result.add(d);
			}
		}
		return result;
	}


	@Override
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	@Override
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Returns the selected Dish of specific type. (1 = starter, 2 = main, 3 = desert).
	 * @param type
	 * @return
	 */
	@Override
	public Dish getSelectedDish(int type) {
		Set<Dish> selectedDish = getDishesOfType(type);
		if(selectedDish != null && !selectedDish.isEmpty()){
			return selectedDish.iterator().next();
		}
			return null;
	}

	@Override
	public Set<Dish> getFullMenu() {
		//fullMenu.addAll(getDishes());
		return fullMenu;
	}

	 public Dish getDescription(){
		 return getDishesOfType(Dish.DESERT).iterator().next();
	 }

	@Override
	public Set<Ingredient> getAllIngredients() {
		boolean ingredientIncluded = false;
		Set<Ingredient> allIngredients = new HashSet<Ingredient>();
		allIngredients.clear();
		if(fullMenu != null && !fullMenu.isEmpty()){
			for(Dish dish : fullMenu){
				Set<Ingredient> newIngredients = dish.getIngredients();
				if(newIngredients != null && !newIngredients.isEmpty()) {
					if(allIngredients != null && !allIngredients.isEmpty()) {
						for (Ingredient newIngredient : newIngredients) {
							Iterator<Ingredient> iterator = allIngredients.iterator();
							ingredientIncluded = false;
							while (iterator.hasNext() && ingredientIncluded == false) {
								Ingredient existingIngredient = iterator.next();
								if (existingIngredient.getName().equals(newIngredient.getName())) {
									existingIngredient.setQuantity(existingIngredient.getQuantity() + newIngredient.getQuantity() * numberOfGuests);
									existingIngredient.setPrice(existingIngredient.getPrice() + newIngredient.getPrice() * numberOfGuests);
									allIngredients.remove(existingIngredient);
									allIngredients.add(new Ingredient(existingIngredient.getName(), existingIngredient.getQuantity(), existingIngredient.getUnit(), existingIngredient.getPrice()));
									ingredientIncluded = true;
								}
							}
							if(ingredientIncluded == false) {
								allIngredients.add(newIngredient);
							}
						}
					} else {
						Iterator<Ingredient> iterator = newIngredients.iterator();
						while (iterator.hasNext()) {
							Ingredient newIngredient = iterator.next();
							allIngredients.add(new Ingredient(newIngredient.getName(), newIngredient.getQuantity()*numberOfGuests, newIngredient.getUnit(), newIngredient.getPrice()*numberOfGuests));
						}
					}
				}
			}
			return allIngredients;
		}
		return null;
	}

	@Override
	public float getTotalMenuPrice() {
		/*double counter = 0;
		Set<Ingredient> priceIngredients = getAllIngredients();
		if(priceIngredients != null && !priceIngredients.isEmpty()) {
			Iterator<Ingredient> iterator = priceIngredients.iterator();
			while (iterator.hasNext()) {
				Ingredient ingredient = iterator.next();
				counter = counter + ingredient.getPrice();
				System.out.println(counter);
			}
			float totalPrice = (float) counter;
			return totalPrice;
		}
		return 0;*/
		double totalPrice = 0.0;
		if(fullMenu != null){
			for(Dish menus : fullMenu){
				Set<Ingredient> ingredients =  menus.getIngredients();
				for(Ingredient ingredient : ingredients){
					totalPrice += ingredient.getPrice();
				}
			}
		}
		return (float)totalPrice;
	}

	@Override
	public void addDishToMenu(Dish dish) {
		removeDishFromMenu(dish);
		fullMenu.add(dish);
		setChanged();
		notifyObservers(this);
	}

	@Override
	public void removeDishFromMenu(Dish dish) {
		int type = dish.getType();
		Iterator<Dish> iterator = fullMenu.iterator();
		while(iterator.hasNext()) {
			Dish menu = iterator.next();
			if(menu.getType() == type){
				iterator.remove();
			}
		}
	}

	public double getIndividualItemCost(Dish dish){
		double price = 0.0;
		if(dish != null){
			Set<Ingredient> ingredients = dish.getIngredients();
			for(Ingredient ingredient : ingredients){
				price += ingredient.getPrice();
			}
		}
		return price;
	}
}
