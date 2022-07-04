package com.modernjava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransactionQuiz {
    public static void main() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

//        System.out.println("질문 1");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .filter(transaction -> transaction.year() == 2011)
//                        .sorted(Comparator.comparingInt(Transaction::value))
//                        .toList()
//        );
//
//        System.out.println("질문 2");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .map(Transaction::trader)
//                        .map(Trader::city)
//                        .distinct()
//                        .toList()
//        );
//
//        System.out.println("질문 3");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .map(Transaction::trader)
//                        .distinct()
//                        .sorted(Comparator.comparing(Trader::name))
//                        .toList()
//        );
//
//        System.out.println("질문 4");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .map(Transaction::trader)
//                        .map(Trader::name)
//                        .distinct()
//                        .sorted()
//                        .toList()
//        );
//
//
//        System.out.println("질문 5");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .map(Transaction::trader)
//                        .anyMatch(trader -> trader.city().equals("Milan"))
//        );
//
//        System.out.println("질문 6");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .filter(transaction -> transaction.trader().city().equals("Cambridge"))
//                        .toList()
//        );
//
//        System.out.println("질문 7");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .map(Transaction::value)
//                        .reduce(Integer::max)
//        );
//
//        System.out.println("질문 8");
//        System.out.println("=================================");
//        System.out.println(
//                transactions.stream()
//                        .map(Transaction::value)
//                        .reduce(Integer::min)
//        );
        String homeValue = System.getProperty("user.home");

        System.out.println("피보나치 수열 스트림");

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
//                .forEach(t -> System.out.println(t[0] + " " + t[1]));
    }
}
