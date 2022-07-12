package practice.modernjava.reactive.flow;

@FunctionalInterface
public interface Publisher<T> {

    void subscribe(Subscriber<? super T> subscriber);
}
