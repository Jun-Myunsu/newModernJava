package org.example.stream05;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;
import static org.example.stream04.Dish.menu;

import org.example.stream04.Dish;

import java.util.Arrays;
import java.util.List;

public class Filtering {

    public static void main(String... args) {
        // 프레디케이트로 거름
        System.out.println("Filtering with a predicate");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        vegetarianMenu.forEach(System.out::println);

//        System.out.println("---------------------------");
//        menu.stream()
//                .filter(Dish::isVegetarian)
//                .forEach(System.out::println);

        // 고유 요소로 거름
        System.out.println("Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .sorted(comparing(Integer::intValue).reversed())
                .distinct()
                .forEach(System.out::println);

        // 스트림 슬라이스
        // 칼로리 값을 기준으로 리스트를 오름차순 정렬!
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        System.out.println("Filtered sorted menu:");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> {
                    System.out.println(dish.getCalories());
                    return dish.getCalories() < 320;
                })
                .collect(toList());
        filteredMenu.forEach(System.out::println);

        System.out.println("Sorted menu sliced with takeWhile():");
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> {
                    System.out.println(dish.getCalories());
                    return dish.getCalories() < 320;
                })
                .collect(toList());
        slicedMenu1.forEach(System.out::println);

        System.out.println();
        System.out.println("Sorted menu sliced with dropWhile():");
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        slicedMenu2.forEach(System.out::println);

        // 스트림 연결
        System.out.println();
        System.out.println("Truncating a stream:");

        List<Dish> dishesLimit3 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        dishesLimit3.forEach(System.out::println);

        // 요소 생략
        System.out.println();
        System.out.println("Skipping elements:");
        
        List<Dish> dishesSkip2 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        dishesSkip2.forEach(System.out::println);

        // Quiz 5-1
        System.out.println();
        System.out.println("Quiz 5-1 스트림을 이용해서 처음 등장하는 두 고기 요리를 필터링하시오.");
        menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .forEach(System.out::println);
    }

}
