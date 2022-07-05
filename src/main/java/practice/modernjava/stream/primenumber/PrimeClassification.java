package practice.modernjava.stream.primenumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeClassification {
    public static void main(String[] args) {
        PrimeClassification primeClassification = new PrimeClassification();
        final int THRESHOLD = 10;
        final int TRY_COUNT = 1_000_000;

        long nonImprovedAverageTime = 0;
        long improvedAverageTime = 0;

        System.out.printf("%d 까지 소수 찾기 알고리즘 시간 비교%n", TRY_COUNT);

        for (int i = 0; i < THRESHOLD; i++) {
            long startTime = System.currentTimeMillis();
            primeClassification.partitionPrimes(TRY_COUNT);
            long endTime = System.currentTimeMillis();
            nonImprovedAverageTime += (endTime - startTime);
        }
        System.out.println("개선 전 평균 실행 시간 : " + (nonImprovedAverageTime / THRESHOLD) + "ms");

        for (int i = 0; i < THRESHOLD; i++) {
            long startTime = System.currentTimeMillis();
            primeClassification.improvedPartitionPrimes(TRY_COUNT);
            long endTime = System.currentTimeMillis();
            improvedAverageTime += (endTime - startTime);
        }
        System.out.println("개선 후 평균 실행 시간 : " + (improvedAverageTime / THRESHOLD) + "ms");

        System.out.println("성능 항상도: " + ((nonImprovedAverageTime / Double.parseDouble(String.valueOf(improvedAverageTime))) * 100 - 100) + "%");
    }
    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(Collectors.partitioningBy(this::isPrime));
    }

    private boolean isPrime(int n) {
        int candidateRoot = (int) Math.round(Math.sqrt(n));

        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> n % i == 0);
    }

    public Map<Boolean, List<Integer>> improvedPartitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new PrimeNumbersCollector());
    }
}
