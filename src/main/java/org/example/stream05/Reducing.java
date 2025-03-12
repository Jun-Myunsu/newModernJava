package org.example.stream05;

import static org.example.stream04.Dish.menu;

import org.example.stream04.Dish;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
리듀싱 연산 : 결과가 나올 때까지 스트림의 모든 요소를 반복적으로 처리하는 것

public abstract T reduce(T identity, BinaryOperator<T> accumulator )

reduce 장점 : reduce를 이용하면 내부 반복이 추상화되면서 내부 구현에서 병렬로 reduce를 실행할 수 있게 된다.

 */

public class Reducing {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min); // (x, y) -> x < y ? x : y
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);

        System.out.println(menu.stream().map(Dish::getCalories).distinct()
                .map(dish -> 1).reduce(0, (a, b) -> a + b));

        menu.stream().map(Dish::getCalories).distinct().findAny().ifPresent(System.out::println);

        System.out.println("Duplication value");

        Set<Integer> set = new HashSet<>();
        menu.stream().filter(dish -> !set.add(dish.getCalories())).map(Dish::getCalories).forEach(System.out::println);

        /*
        Stream<String> stream = Stream.of("A", "B", "B", "C", "D", "D");

        Map<String, Integer> map = stream.collect(
                Collectors.toMap(Function.identity(), value -> 1, Integer::sum)
        );

        System.out.println(map);
        */
    }

}
