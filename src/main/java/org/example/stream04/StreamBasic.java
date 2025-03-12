package org.example.stream04;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.*;

/*
스트림이란 '데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소'로 정의할 수 있다.
1. 연속된 요소, 소스, 데이터 처리 연산, 파이프 라이닝, 내부 반복

■ filter : 람다를 인수로 받아 스트림에서 특정 요소를 제외시킨다.
■ map : 람다를 이용해서 한 요소를 다른 요소로 반환하거나 정보를 추출한다.
■ limit : 정해진 개수 이상의 요소가 스트림에 저장되지 못하게 스트림 크기를 축소 truncate한다.
■ collect : 스트림을 다른 형식으로 변환한다. ex) collect(toList())

 */
public class StreamBasic {

    public static void main(String... args) {
        // 자바 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // 자바 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

        List<String> threeHighCaloricDishNames = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)       // 선착순 3개만 선택
                .collect(toList());

        System.out.println("---");

        threeHighCaloricDishNames.forEach(System.out::println);

        System.out.println("---");

        // for-each를 이용한 외부 반복
        List<String> names = new ArrayList<>();
        for(Dish dish: Dish.menu) {
            names.add(dish.getName());
        }
        // 반복자를 사용한 외부 반복
        names = new ArrayList<>();
        Iterator<Dish> iterator = Dish.menu.iterator();
        while(iterator.hasNext()) {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }
        // 스트림 내부 반복
        Dish.menu.stream().map(Dish::getName).collect(toList());

        System.out.println("---");

        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> itr = Dish.menu.iterator();
        while(itr.hasNext()) {
            Dish dish = itr.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }

        highCaloricDishes =
                Dish.menu.stream()
                        .filter(dish -> dish.getCalories() > 300) // 중간 연산
                        .map(Dish::getName) // 중간연산
                        .collect(toList()); // 최종연산

        highCaloricDishes.forEach(System.out::println);
    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)                     // 요리명 추출
                .collect(toList());                     // 모든 요리명을 리스트에 저장
    }
}
