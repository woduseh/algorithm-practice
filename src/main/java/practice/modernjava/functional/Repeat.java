package practice.modernjava.functional;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Repeat {

    public static void main(String[] args) {
        System.out.println(repeat(2, (Integer x) -> x * x).apply(2));
    }

    static <A> Function<A, A> repeat(int i, UnaryOperator<A> f) {
        return i == 0 ? a -> a : f.compose(repeat(i - 1, f));
    }
}
