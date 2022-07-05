package practice.modernjava.stream.trader;

public record Transaction(Trader trader, int year, int value) {

    @Override
    public String toString() {
        return "{" + trader + ", " + year + ", " + value + "}";
    }
}
