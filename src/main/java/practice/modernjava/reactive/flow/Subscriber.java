package practice.modernjava.reactive.flow;

@FunctionalInterface
public interface Subscriber<T> {

    void onNext(T item);
}
