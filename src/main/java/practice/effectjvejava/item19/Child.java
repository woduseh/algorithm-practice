package practice.effectjvejava.item19;

import java.time.Instant;

final class Child extends Parent {

	// 생성자에서 초기화
	private final Instant instant;

	Child() {
		instant = Instant.now();
	}

	// 재정의 가능 메서드
	@Override
	public void overrideMe() {
		System.out.println(instant);
	}
}