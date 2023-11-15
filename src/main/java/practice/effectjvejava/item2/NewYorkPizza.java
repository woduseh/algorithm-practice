package practice.effectjvejava.item2;

import java.util.Objects;

public class NewYorkPizza extends Pizza {
	public enum Size { SMALL, MEDIUM, LARGE }
	public final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		public final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public NewYorkPizza build() {
			return new NewYorkPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private NewYorkPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
}
