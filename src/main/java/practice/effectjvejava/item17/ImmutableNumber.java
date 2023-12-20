package practice.effectjvejava.item17;

import lombok.ToString;

@ToString
public class ImmutableNumber {
	final int number;

	public ImmutableNumber(int number) {
		this.number = number;
	}

	public ImmutableNumber add(int val) {
		return new ImmutableNumber(number + val);
	}
}
