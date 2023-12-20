package practice.effectjvejava.item17;

import java.lang.reflect.Field;

public class MutableNumberTest {
	public static void main(String[] args) throws Exception {
		MutableNumber mutableNumber = new MutableNumber(100);
		ImmutableNumber mutableNumberTwo = mutableNumber.add(100);

		// mutableNumber는 ImmutableNumber임에도 불구하고 더 이상 불변 객체임을 보장할 수 없다.
		System.out.println(mutableNumber);
		System.out.println(mutableNumberTwo);
		System.out.println(mutableNumber == mutableNumberTwo);
	}
}
