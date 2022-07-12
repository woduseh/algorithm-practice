package practice.modernjava.reactive.flow;

import java.util.ArrayList;
import java.util.List;

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {

    private int value = 0;
    public String name;
    private List<Subscriber> subscribers = new ArrayList<>();


    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(value));
    }

    @Override
    public void onNext(Integer item) {
        this.value = item;
        System.out.println(this.name + ": " + this.value);
        notifyAllSubscribers();
    }
}
