package practice.effectjvejava.item2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NutritionFacts {
	private int servingSize; // 1인분의 양 - 필수
	private int servings; // 전체 제공량 - 필수
	private int calories; // 칼로리 - 선택
	private int fat; // 지방 - 선택
	private int sodium; // 염분 - 선택
	private int carbohydrate; // 탄수화물 - 선택
	@Getter
	private boolean frozen; // Freeze 여부

	// 점진적 생성자 패턴
	public NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0, false);
	}

	public synchronized void setServingSize(int servingSize) {
		checkNotFrozen();
		this.servingSize = servingSize;
	}

	public synchronized void setServings(int servings) {
		checkNotFrozen();
		this.servings = servings;
	}

	public synchronized void setCalories(int calories) {
		checkNotFrozen();
		this.calories = calories;
	}

	public synchronized void setFat(int fat) {
		checkNotFrozen();
		this.fat = fat;
	}

	public synchronized void setSodium(int sodium) {
		checkNotFrozen();
		this.sodium = sodium;
	}

	public synchronized void setCarbohydrate(int carbohydrate) {
		checkNotFrozen();
		this.carbohydrate = carbohydrate;
	}

	public synchronized void freeze() {
		this.frozen = true;
	}

	private void checkNotFrozen() {
		if (this.isFrozen())
			throw new RuntimeException("NutritionFacts is now frozen!");
	}
}
