package practice.modernjava.stream.dish;

public record Dish(String name, boolean vegetarian, int calories,
                   Dish.Type type) {

    public enum Type {MEAT, FISH, VEGETABLE, OTHER}

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Dish)) {
            return false;
        }
        return this.name.equals(((Dish) other).name) && this.vegetarian == ((Dish) other).vegetarian
                && this.calories == ((Dish) other).calories && this.type == ((Dish) other).type;
    }
}
