package practice.modernjava.reactive.flow;

import java.util.concurrent.Flow.Publisher;

public class Main {

    public static void main(String[] args) {
//        getTemperatures("Tokyo").subscribe(new TempSubscriber());
        getCelsiusTemperatures("Seoul").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }

    private static Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
