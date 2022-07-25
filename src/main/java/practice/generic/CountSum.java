package practice.generic;

import java.util.stream.LongStream;

public class CountSum {
    public static void main(String[] args) {
        CountSum countSum = new CountSum();
        final long THRESHOLD = 1_000_000_000L;

        // Parallel vs iterative
        long startTime = System.currentTimeMillis();
        System.out.println(countSum.iterativeSum(THRESHOLD));
        long endTime = System.currentTimeMillis();

        System.out.println("Iterative sum time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(countSum.streamSum(THRESHOLD));
        endTime = System.currentTimeMillis();

        System.out.println("Stream sum time: " + (endTime - startTime) + "ms");

        // Generic
        System.out.println("Generic Arithmetic Operation");
        System.out.println(countSum.add(10, 2.3));
        System.out.println(countSum.sub(10, 25L));

        // Number 인터페이스릐 doubleValue() 를 이용하기에 오차가 발생할 수 있음
        System.out.println(countSum.mul(10, 2.3F));
        System.out.println(countSum.mul(10, 2.3D));

        System.out.println(countSum.div(10, 5.5D));

        // Number 인터페이스릐 doubleValue() 를 이용하기에 오차가 발생할 수 있음
        System.out.println(countSum.div(new StringNumber("-3.3"), new StringNumber(".1")));
    }

    private long iterativeSum(long i) {
        long sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    private long streamSum(long i) {
        return LongStream.rangeClosed(1, i).parallel().sum();
    }

    private <T extends Number> double add(T first, T second) {
        return first.doubleValue() + second.doubleValue();
    }

    private <T extends Number> double sub(T first, T second) {
        return first.doubleValue() - second.doubleValue();
    }

    private <T extends Number> double mul(T first, T second) {
        return first.doubleValue() * second.doubleValue();
    }

    private <T extends Number> double div(T first, T second) {
        return first.doubleValue() / second.doubleValue();
    }

    static final class StringNumber extends Number {
        private final String value;
        public StringNumber(String value) {
            if (value.matches("(([+-])?(\\d+)(\\.\\d+)?)|(([+-])?\\.?\\d+)")) {
                this.value = value;
            } else {
                throw new IllegalArgumentException("Invalid value: not a number");
            }
        }

        @Override
        public int intValue() {
            return Integer.parseInt(value);
        }

        @Override
        public long longValue() {
            return Long.parseLong(value);
        }

        @Override
        public float floatValue() {
            return Float.parseFloat(value);
        }

        @Override
        public double doubleValue() {
            return Double.parseDouble(value);
        }
    }
}
