package practice.effectjvejava.item19;

public class Parent {

	public Parent() {
		// 오동작의 원인 - 상위 클래스에서 재정의 메서드 호출
		overrideMe();
	}

	public void overrideMe() {
		System.out.println("부모 override 메서드 호출");
	}
}