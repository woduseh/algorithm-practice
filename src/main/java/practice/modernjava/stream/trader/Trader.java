package practice.modernjava.stream.trader;

public record Trader(String name, String city) {

    @Override
    public String toString() {
        return "Trader: " + name + " in " + city;
    }
}
