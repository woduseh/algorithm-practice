package practice.effectjvejava.item17;

import java.lang.reflect.Field;

public class MutableNumber extends ImmutableNumber {
	public MutableNumber(int val) {
		super(val);
	}

	// reflection을 통해 강제로 final 변수의 값을 변경시킨다
	@Override
	public ImmutableNumber add(int val) {
		try {
			Class numberClass = ImmutableNumber.class;
			Field field = numberClass.getDeclaredField("number");
			field.setAccessible(true);

			field.setInt(this, number + val);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}
}
