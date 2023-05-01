package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import cp213.Food.Origins;

/**
 * Utilities for working with Food objects.
 *
 * @author Andrew
 * @version 2022-10-16
 */
class FoodUtilities {
    public static int averageCalories(final ArrayList<Food> foods) {
	int total = 0;

	for (int i = 0; i < foods.size(); i++) {
	    total += foods.get(i).getCalories();
	}

	total = total / foods.size();

	return total;

    }

    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {
	int av = 0;
	int i = 0;

	for (int j = 0; j < foods.size(); j++) {
	    if (foods.get(j).getOrigin() == origin) {
		av += foods.get(j).getCalories();
		i++;

	    }

	}
	av = av / i;
	return av;
    }

    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {
	ArrayList<Food> output = new ArrayList<Food>();

	for (Food f : foods) {
	    if (f.getOrigin() == origin)
		output.add(f);
	}

	return output;
    }

    public static Food getFood(final Scanner keyboard) {
	Food f = new Food();

	System.out.print("Name: ");
	f.setName(keyboard.nextLine());

	System.out.println("Origins");

	for (int i = 0; i < 12; i++)
	    System.out.println(Origins.values()[i].name());
	System.out.print("Origin Number: ");
	int on = keyboard.nextInt();
	keyboard.nextLine();

	f.setOrigin(on);

	System.out.print("Vegetarian (Y/N): ");
	char c = keyboard.nextLine().charAt(0);

	if (c == 'Y')
	    f.setVegeterian(true);
	else
	    f.setVegeterian(false);

	System.out.print("Calories: ");
	on = keyboard.nextInt();
	keyboard.nextLine();

	f.setCalories(on);

	return f;
    }

    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {
	ArrayList<Food> output = new ArrayList<>();

	for (Food f : foods) {
	    if (f.isVegetarian())
		output.add(f);
	}

	return output;
    }

    public static Food readFood(final String line) {
	String[] foodLine = line.split("[\\|]+");

	String name = foodLine[0];
	int origin = Integer.parseInt(foodLine[1]);
	boolean isVeg = Boolean.parseBoolean(foodLine[2]);
	int calories = Integer.parseInt(foodLine[3]);

	Food food = new Food(name, origin, isVeg, calories);
	return food;

    }

    public static ArrayList<Food> readFoods(final Scanner fileIn) {
	ArrayList<Food> foods = new ArrayList<Food>();
	while (fileIn.hasNextLine()) {
	    String foodLine = fileIn.nextLine();
	    Food food = FoodUtilities.readFood(foodLine);
	    foods.add(food);
	}
	return foods;
    }

    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {
	ArrayList<Food> output = new ArrayList<>();
	for (Food f : foods) {
	    if (origin == -1 || f.getOrigin() == origin)
		if (maxCalories == 0 || f.getCalories() < maxCalories)
		    if (!isVegetarian || f.isVegetarian() == isVegetarian)
			output.add(f);
	}

	return output;
    }

    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {
	for (Food f : foods) {
	    ps.println("Name: " + f.getName());
	    ps.println("Origin: " + Origins.values()[f.getOrigin()].name());
	    ps.println("Vegetarian: " + (f.isVegetarian() ? "Y" : "N"));
	    ps.println("Calories: " + f.getCalories());
	    ps.println();
	}
    }
}