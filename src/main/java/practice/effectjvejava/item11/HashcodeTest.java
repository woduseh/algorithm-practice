package practice.effectjvejava.item11;

import java.time.LocalDateTime;
import java.util.HashMap;

public class HashcodeTest {
	private final static String RED = "RED";
	private final static int HUNDRED = 100;
	private final static LocalDateTime NOW = LocalDateTime.now();

	public static void main(String[] args) throws Exception {


		Apple1 apple1 = Apple1.builder()
			.color(RED)
			.weight(HUNDRED)
			.harvestDay(NOW)
			.build();

		Apple2 apple2 = Apple2.builder()
			.color(RED)
			.weight(HUNDRED)
			.harvestDay(NOW)
			.build();

		// Lombok의 .hashcode() 는 값만을 가지고 비교하므로 동일하다
		System.out.println(apple1.hashCode() == apple2.hashCode());

		// 두 객체는 equal 이므로 해시코드도 일치한다
		System.out.println(apple1.hashCode() == Apple1.builder()
				.color(RED)
				.weight(HUNDRED)
				.harvestDay(NOW)
				.build()
			.hashCode());

		// Lombok의 .equals()는 클래스가 같은지도 비교하므로 동일하지 않다
		System.out.println(apple1.equals(apple2));

		HashMap<? super AppleParent, String> appleParentHashMap = new HashMap<>();

		appleParentHashMap.put(apple1, "Apple1");

		// appleParentHashMap.put(Apple1.builder()
		// 	.color(RED)
		// 	.weight(HUNDRED)
		// 	.harvestDay(NOW)
		// 	.build(), "Apple3");

		appleParentHashMap.put(apple2, "Apple2");

		// 서로 같은 해시코드를 반환하는데 어떻게 이를 구분할 수 있는가?
		System.out.println(appleParentHashMap.get(apple1));

		System.out.println(appleParentHashMap.get(Apple1.builder()
			.color(RED)
			.weight(HUNDRED)
			.harvestDay(NOW)
			.build()));

		System.out.println(appleParentHashMap.get(apple2));

		System.out.println(appleParentHashMap);
	}
}
