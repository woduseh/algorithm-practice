package practice.effectjvejava.item3;

import java.util.function.Supplier;

public class Faker {
	public static final Faker T1Faker = new Faker();

	private Faker() {
		throw new IllegalStateException("You can't make new instance of Faker!");
	}
	public static Faker getT1Faker() {
		// return new Faker(); // 간단히 싱글턴이 아니게 변경할 수 있음

		// Supplier<Faker> fakerSupplier = Faker::getT1Faker; // Supplier로 사용 가능
		return T1Faker;
	}
}
