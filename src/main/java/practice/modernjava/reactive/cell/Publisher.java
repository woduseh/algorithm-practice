package practice.modernjava.reactive.cell;

@FunctionalInterface
public interface Publisher<T> {

    void subscribe(Subscriber<? super T> subscriber);
}
