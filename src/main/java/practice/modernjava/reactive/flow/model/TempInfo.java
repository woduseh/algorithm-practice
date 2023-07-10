package practice.modernjava.reactive.flow.model;

import java.util.random.RandomGenerator;

public record TempInfo(String town, double temperature, TemperatureType temperatureType) {

    public static final int FAIL_PROBABILITY = 1;
    public static final RandomGenerator generator = RandomGenerator.getDefault();

    public static TempInfo fetch(String town) {
        if (generator.nextInt(100 / FAIL_PROBABILITY) == 0) {
            throw new RuntimeException("Failed to fetch temperature info - " + town);
        }

        return new TempInfo(town, generator.nextInt(100), TemperatureType.Fahrenheit);
    }

    @Override
    public String toString() {
        return String.format("%s: %.1f %s", town, temperature, temperatureType);
    }
}
