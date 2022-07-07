package practice.modernjava.lambda.apple;

public record Grape(int weight, int size, String color) {

    @Override
    public String toString() {
        return "Grape{" +
                "weight=" + weight +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
