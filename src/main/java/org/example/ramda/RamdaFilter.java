package org.example.ramda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class RamdaFilter {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String...agrs) {
//        List<Apple> inventory = Arrays.asList(
//                new Apple(80, "green"),
//                new Apple(155, "green"),
//                new Apple(120, "red")
//        );
//
//        List<Apple> result = Test.filterApples(inventory, (Apple apple) -> FilteringApples.Color.RED.equals(apple.getColor()));

//        Comparator<Apple> byWeight1 = new Comparator<Apple>() {
//            @Override
//            public int compare(Apple a1, Apple a2) {
//                return a1.getWeight().compareTo(a2.getWeight());
//            }
//        };
//
//        Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        List<String> listOfStrings = Arrays.asList("11", null, "22", "33", "");
//        Predicate<String> nonEmptyStringPredicate = (String s) -> (s != null && !s.isEmpty());
//        List<String> nonEmptyList = filter(listOfStrings, (String s) -> (s != null && !s.isEmpty()));

        List<String> nonEmptyList = filter(listOfStrings, new Predicate<String>() {

                    @Override
                    public boolean test(String s) {
                        return (s != null && !s.isEmpty());
                    }
                });


        System.out.println(nonEmptyList.toString());

        ToIntFunction<String> stringToInt1 = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInt2 = Integer::parseInt;

        System.out.println(stringToInt2.apply("2323"));

        BiPredicate<List<String>, String> contains1 = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;

        List<Integer> weights = Arrays.asList(7,3,4,10);
        List<Apple> apples = map(weights, Apple::new);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i: list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
