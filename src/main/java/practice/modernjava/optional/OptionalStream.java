package practice.modernjava.optional;

import java.util.List;
import java.util.Optional;
import practice.util.OptionalUtil;

public class OptionalStream {

    public static void main(String[] args) {
        Optional<Car> BMW = Optional.of(new Car("BMW", Optional.of("X5")));
        Optional<Car> Toyota = Optional.of(new Car("Toyota", Optional.of("Corolla")));
        Optional<Car> Audi = Optional.of(new Car("Audi", Optional.empty()));

        List<Optional<Car>> cars = List.of(BMW, Toyota, Audi);

        List<String> colorList = cars.stream()
                .map(optCar -> optCar.flatMap(Car::model))
                .flatMap(Optional::stream)
                .toList();

        System.out.println(colorList);

        System.out.println(OptionalUtil.stringToInt("1sa23").isPresent());
    }

    record Car(String make, Optional<String> model) {

        @Override
        public String toString() {
            return make + " " + model.toString();
        }
    }
}
