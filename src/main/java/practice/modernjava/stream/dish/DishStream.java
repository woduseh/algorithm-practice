package practice.modernjava.stream.dish;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import practice.modernjava.stream.dish.Dish.Type;

public class DishStream {
    public void main() {
        Logger logger = Logger.getLogger(DishStream.class.getName());

        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork", false, 800, Type.MEAT));
        menu.add(new Dish("beef", false, 700, Type.MEAT));
        menu.add(new Dish("chicken", false, 400, Type.MEAT));
        menu.add(new Dish("french fries", true, 530, Type.OTHER));
        menu.add(new Dish("rice", true, 350, Type.OTHER));
        menu.add(new Dish("pizza", true, 550, Type.OTHER));
        menu.add(new Dish("prawns", false, 300, Type.FISH));
        menu.add(new Dish("salmon", false, 450, Type.FISH));
        menu.add(new Dish("potato", true, 200, Type.VEGETABLE));
        menu.add(new Dish("carrot", true, 90, Type.VEGETABLE));

//        List<String> lowCalorieDishes = menu.parallelStream()
//                .filter(dish -> dish.getCalories() < 400)
//                .map(Dish::getName)
//                .toList();
//
//        long numOfLowCalorieDishes = menu.stream()
//                .filter(dish -> dish.getCalories() < 400)
//                .count();
//
//        logger.log(Level.FINE, () -> "Number of Low calorie dishes: " + numOfLowCalorieDishes);
//
//        System.out.println("Low Calories Dish: " + lowCalorieDishes);
//
//        List<String> vegetarianDishes = menu.stream()
//                .filter(dish -> dish.getType().equals(Type.VEGETABLE))
//                .map(Dish::getName).toList();
//
//        System.out.println("Vegetarian Dish: " + vegetarianDishes);
//
//        List<String> meatAndHighCalorieDishes = menu.stream()
//                .filter(dish -> dish.getType().equals(Type.MEAT))
//                .filter(dish -> dish.getCalories() > 300)
//                .map(Dish::getName).toList();
//
//        System.out.println("High Calories And Meat Dish: " + meatAndHighCalorieDishes);
//
//        Map<String, Integer> topThreeHighCaloriesDishes = menu.stream()
//                .filter(dish -> dish.getCalories() > 300)
//                .distinct()
//                .sorted((d1, d2) -> d2.getCalories() - d1.getCalories())
//                .limit(3)
//                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));
//
//        System.out.println("Top Three High Calories Dish: " + topThreeHighCaloriesDishes);
//
//        // equals override 잘 되었나 체크
//        Dish beefOne = new Dish("beef", false, 700, Type.MEAT);
//        Dish beefTwo = new Dish("beef", false, 700, Type.MEAT);
//        Dish beefThree = new Dish("beef", false, 700, Type.MEAT);
//
//        System.out.println("beefOne equals beefOne: " + beefOne.equals(beefOne));
//        System.out.println("beefTwo equals beefOne: " + beefTwo.equals(beefOne));
//        System.out.println("beefThree equals beefTwo: " + beefThree.equals(beefTwo));
//        System.out.println("beefThree equals beefOne: " + beefThree.equals(beefOne));
//
//        System.out.println(menu.stream()
//                .sorted((d1, d2) -> d2.getCalories() - d1.getCalories())
//                .distinct()
//                .takeWhile(dish -> dish.getCalories() > 300)
//                .map(Dish::getName)
//                .toList());
//
//        System.out.println(menu.stream()
//                .sorted((d1, d2) -> d2.getCalories() - d1.getCalories())
//                .dropWhile(dish -> dish.getCalories() > 300)
//                .map(Dish::getName)
//                .map(String::length)
//                .toList());
//
//        List<Dish> dessert = new ArrayList<>();
//        dessert.add(new Dish("cake", true, 400, Type.OTHER));
//        dessert.add(new Dish("apple pie", true, 300, Type.OTHER));
//        dessert.add(new Dish("cookie", true, 250, Type.OTHER));
//
//        System.out.println(menu.stream()
//                .flatMap(dish -> dessert.stream().map(dessertDish -> new Dish(dish.getName() + " and dessert " + dessertDish.getName(), dish.isVegetarian() && dessertDish.isVegetarian(), dish.getCalories() + dessertDish.getCalories(), dish.getType())))
//                .filter(dish -> dish.getType().equals(Type.OTHER))
//                .map(Dish::getName)
//                .distinct()
//                .toList());
//
//        System.out.println(menu.stream()
//                .distinct()
//                .reduce((maxCalorieDish, dish) -> {
//                    if (dish.getCalories() > maxCalorieDish.getCalories()) {
//                        return dish;
//                    } else {
//                        return maxCalorieDish;
//                    }
//                })
//                .map(dish -> "Highest calorie menu: " + dish.getName() + ", " + dish.getCalories()));

//        double avgCalorie = menu.stream()
//                .collect(Collectors.averagingInt(Dish::getCalories));
//
//        System.out.println("Avg Calorie: " + avgCalorie);
//
//        IntSummaryStatistics menuStatistics = menu.stream()
//                .collect(Collectors.summarizingInt(Dish::getCalories));
//
//        System.out.println("Menu Statistics: " + menuStatistics);

        // 다수준 그룹화
        var dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::type,
                            groupingBy(dish -> {
                                if (dish.calories() <= 400) {
                                    return CaloricLevel.DIET;
                                } else if (dish.calories() <= 700) {
                                    return CaloricLevel.NORMAL;
                                } else {
                                    return CaloricLevel.FAT;
                                }
                            }))
                );

        System.out.println(dishesByTypeCaloricLevel);

        
        var typesCount = menu.stream().collect(
                groupingBy(Dish::type, counting())
        );
        
        System.out.println(typesCount);
    }

    enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
