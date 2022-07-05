package practice.modernjava.lambda.apple;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AppleLambda {

  public static void main(String[] args) {
    List<Apple> inventory = new ArrayList<>();
    inventory.add(new Apple(200, "Green"));
    inventory.add(new Apple(150, "Red"));

    // 1단계 : 코드 전달
    prettyPrintApple(inventory, new AppleWeightFormatter());
    prettyPrintApple(inventory, new AppleWeightAndColorFormatter());

    // 2단계 : 익명 클래스
    inventory.sort(new Comparator<Apple>() {
      @Override
      public int compare(Apple a, Apple b) {
        return a.weight() > b.weight() ? 1 : -1;
      }
    });

    // 3단계 : 람다 표현식
    prettyPrintApple(inventory, apple -> "A " + apple.weight() + " g apple");
    inventory.sort(comparing(apple -> apple.weight()));

    // 4단계 : 메서드 참조
    inventory.sort(comparing(Apple::weight));

    BiFunction<Integer, String, Apple> formatter = Apple::new;

    Function<String, Integer> func = Integer::parseInt;

    System.out.println(func.apply("25"));
  }

  // 사과를 입력받으면 이 사과가 무거운지 / 가벼운지 여부와 사과의 색을 반환하기?
  public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
    for (Apple apple : inventory) {
      String output = appleFormatter.accept(apple);
      System.out.println(output);
    }
  }

  @FunctionalInterface
  interface AppleFormatter {
    String accept(Apple apple);
  }

  static class AppleWeightFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
      return "A apple weight " + apple.weight();
    }
  }

  static class AppleWeightAndColorFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
      return "A " + apple.color() + " apple weight " + apple.weight();
    }
  }
}