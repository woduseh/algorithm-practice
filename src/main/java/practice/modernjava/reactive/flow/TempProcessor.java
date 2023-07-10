package practice.modernjava.reactive.flow;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import practice.modernjava.reactive.flow.model.TempInfo;
import practice.modernjava.reactive.flow.model.TemperatureType;

public class TempProcessor implements Processor<TempInfo, TempInfo> {
    private final TemperatureType temperatureType;
    private Subscriber<? super TempInfo> subscriber;

    public TempProcessor(TemperatureType temperatureType) {
        this.temperatureType = temperatureType;
    }

    @Override
    public void subscribe(Subscriber<? super TempInfo> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(TempInfo item) {
        switch (temperatureType) {
            case Celsius -> subscriber.onNext(new TempInfo(item.town(), fahToCel(item.temperature()), TemperatureType.Celsius));
            case Kelvin -> subscriber.onNext(new TempInfo(item.town(), fahToKel(item.temperature()), TemperatureType.Kelvin));
            default -> subscriber.onNext(new TempInfo(item.town(), item.temperature(), TemperatureType.Fahrenheit));
        }
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }

    private double fahToCel(double fah) {
        return (fah - 32) * 5 / 9;
    }

    private double fahToKel(double fah) {
        return (fah - 32) * 5 / 9 + 273.15;
    }
}
