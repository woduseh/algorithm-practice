package practice.modernjava.reactive.cell;

@FunctionalInterface
public interface Subscriber<T> {

    void onNext(T item);
}
