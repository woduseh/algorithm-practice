package practice.effectjvejava.item2;
public class item2Main {
	public static void main(String[] args) {
		// NutritionFacts

		// 점진적 생성자
		NutritionFacts coke = new NutritionFacts(240, 8);

		// 자바빈
		NutritionFacts coke2 = new NutritionFacts();
		coke2.setServingSize(240);
		coke2.setServings(8);
		coke2.freeze(); // 더 이상 setter로 객체를 변경할 수 없음

		// 빌더
		NutritionFacts coke3 = NutritionFacts.builder()
			.servingSize(240)
			.servings(8)
			.build();

		// PIZZA
		NewYorkPizza newYorkPizza = new NewYorkPizza.Builder(NewYorkPizza.Size.LARGE)
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.MUSHROOM)
			.build();
	}
}
