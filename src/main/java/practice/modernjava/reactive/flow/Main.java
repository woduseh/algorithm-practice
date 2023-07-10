package practice.modernjava.reactive.flow;

import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.random.RandomGenerator;

import practice.modernjava.reactive.flow.model.TempInfo;
import practice.modernjava.reactive.flow.model.TemperatureType;

public class Main {
    public static final RandomGenerator generator = RandomGenerator.getDefault();
    public static final List<String> CITY_LIST = List.of("Seoul", "Busan", "Incheon", "Daegu", "Gwangju", "Daejeon", "Ulsan", "Sejong");

    public static void main(String[] args) {
        getTemperatures(CITY_LIST.get(generator.nextInt(8)), TemperatureType.Celsius).subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }

    private static Publisher<TempInfo> getTemperatures(String town, TemperatureType temperatureType) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor(temperatureType);
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
