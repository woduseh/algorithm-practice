package practice.modernjava.reactive.flow;

import java.util.random.RandomGenerator;

public record TempInfo(String town, int temp) {

    public static final RandomGenerator generator = RandomGenerator.getDefault();

    public static TempInfo fetch(String town) {
        if (generator.nextInt(10) == 0) {
            throw new RuntimeException("Failed to fetch temp info");
        }

        return new TempInfo(town, generator.nextInt(100));
    }

    @Override
    public String toString() {
        return String.format("%s: %d", town, temp);
    }
}
