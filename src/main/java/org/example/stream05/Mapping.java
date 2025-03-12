package org.example.stream05;

import static java.util.stream.Collectors.toList;
import static org.example.stream04.Dish.menu;

import org.example.stream04.Dish;

import java.util.Arrays;
import java.util.List;

public class Mapping {

    public static void main(String... args) {
        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        // 스트림의 각 값을 다름 스트림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs = numbers1.stream()
                .flatMap((Integer i) -> numbers2.stream().map((Integer j) -> new int[]{i, j}))
                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                .collect(toList());
        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));

        // Quiz 5-2-1
        System.out.println();
        System.out.println("Quiz 5-2-1 숫자 리스트가 주어졌을 때 숫자의 제곱근으로 이루어진 리스트를 반환하시오.");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map(i -> i * i).forEach(System.out::println);
    }

}
