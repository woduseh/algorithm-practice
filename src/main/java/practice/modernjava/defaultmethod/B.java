package practice.modernjava.defaultmethod;

public interface B extends A {
    @Override
    default void hello() {
        System.out.println("Hello from B");
    }
}