package org.example.stream05;

import static org.example.stream04.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.example.stream04.Dish;

/*
 anyMatch   : 주어진 스트림 안에서 적어도 한 요소와 일치하는지 확인할 때 return true
 allMatch   : 주어진 스트림 모두가 일치하는 경우 return true
 noneMatch  : allMatch와 반대 모두가 일치하는 않는 경우 return true
 findAny    : 현재 스트림에서 임의의 요소를 반환한다.
 findFirst  : 현재 스트림의 첫번째 요소를 반환한다.

 Optional 값이 없을 수도 있을 때 사용
 .isPresent() : 값이 포함되면 true, 아니면 false
 .ifPresent(Consumer<T> block) : 값이 있을 경우 주어진 블럭을 실행
 .get() return T : 값이 존재하면 값을 반환하고, 값이 없으면 NoSuchElementException
 .orElse(T other) return T : 값이 존재하면 값을 반화하고, 값이 없으면 기본값을 반환한다.
 */
public class Finding {

    public static void main(String... args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream().map(i -> i * i).filter(i -> (i % 3) == 0).findFirst().ifPresent(System.out::println);
    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

}
