package org.example.stream06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static org.example.stream06.Dish.menu;

public class Reducing {

  public static void main(String... args) {

    long howManyDishes1 = menu.stream().collect(Collectors.counting());
    long howManyDishes2 = menu.stream().count();

    Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(comparingInt(Dish::getCalories)));

    // summingInt, summingLong, summingDouble
    int totalColories = menu.stream().collect(summingInt(Dish::getCalories));

    // averagingInt, averagingLong, averagingDouble
    double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

    // IntSummaryStatistics, LongSummaryStatistics, DoubleSummaryStatistics
    IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

    String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
    System.out.println("shortMenu = " + shortMenu);

//    int total = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));
    int total = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));

    int total1 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    int total2 = menu.stream().mapToInt(Dish::getCalories).sum();
//
//    System.out.println("Total calories in MENU: " + calculateTotalCalories());
//    System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
//    System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
//    System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());

    // quiz 6-1 리듀싱으로 문자열 연결하기
    String shortMenu1 = menu.stream().map(Dish::getName).collect(joining());
    String shortMenu2 = menu.stream().map(Dish::getName)
            .collect(reducing((s1, s2) -> s1 + s2)).get();
//    String shortMenu3 = menu.stream().collect(reducing(s1, s2) -> s1.getName() + s2.getName())).get(); 오류
    String shortMenu4 = menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));

    System.out.println("shortMenu1 = " + shortMenu1);
    System.out.println("shortMenu2 = " + shortMenu2);
  }

  private static int calculateTotalCalories() {
    return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
  }

  private static int calculateTotalCaloriesWithMethodReference() {
    return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
  }

  private static int calculateTotalCaloriesWithoutCollectors() {
    return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
  }

  private static int calculateTotalCaloriesUsingSum() {
    return menu.stream().mapToInt(Dish::getCalories).sum();
  }

}
