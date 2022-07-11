package practice.modernjava.defaultmethod;

public interface A {

    default void hello() {
        System.out.println("Hello from A");
    }
}
