package practice.modernjava.functional;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FirstClassFunction {

    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::parseInt;
        ToIntFunction<String> strToInt2 = Integer::parseInt;

        System.out.println(strToInt.apply("123"));
        System.out.println(strToInt2.applyAsInt("123"));

        DoubleUnaryOperator convertWonToDollar = won -> won / 1185.76;
        DoubleUnaryOperator convertWonToYen = won -> won / 113.41;

        double won = 10_000;

        System.out.printf("%.0f Won is %.2f Dollar\n", won, convertWonToDollar.applyAsDouble(won));
        System.out.printf("%.0f Won is %.2f Yen\n", won, convertWonToYen.applyAsDouble(won));
    }

    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> f * x + b;
    }
}
