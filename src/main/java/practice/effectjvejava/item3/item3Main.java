package practice.effectjvejava.item3;

import practice.effectjvejava.item2.NewYorkPizza;
import practice.effectjvejava.item2.NutritionFacts;
import practice.effectjvejava.item2.Pizza;

public class item3Main {
	public static void main(String[] args) {
		Faker faker = Faker.getT1Faker();

		Elvis elvis = Elvis.INSTANCE;

		elvis.leaveTheBuilding();
		elvis.sing();
	}
}
