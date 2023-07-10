package practice.modernjava.reactive.flow.model;

public enum TemperatureType {
	Fahrenheit("Fah"),
	Celsius("Cel"),
	Kelvin("Kal");
	private final String value;

	TemperatureType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
