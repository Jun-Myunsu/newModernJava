package org.example.ramda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class SortComparator {
    public static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }

    public static void main(String...agrs) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        // 기본 코드 전달
        inventory.sort(new AppleComparator());

        // 익명 클래스
        inventory.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        // 람다 표현식 사용
        /*
        public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
                Function<? super T, ? extends U> keyExtractor)
        {
            Objects.requireNonNull(keyExtractor);
            return (Comparator<T> & Serializable)
                    (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        }
         */

        /*
        comparing(apple -> apple.getWeight()) 실행하면
        (c1, c2) -> c1.getWeight().compareTo(c2.getWeight()) 을 리턴함

         */
        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        inventory.sort(comparing(apple -> apple.getWeight()));

        // 메소드 참조
        inventory.sort(comparing(Apple::getWeight));

        /* 람다 표현식을 조합할 수 있는 유용한 메서드 */

        // Comparator 조합
        // 1. 역정렬
        inventory.sort(comparing(Apple::getWeight).reversed()); // 내림차순 정렬

        // 2. Comperator 연결(비교 결과를 더 추가할 수 있는 구문)
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));

        // Predicate 조합
        // 결과 반전
        Predicate<Apple> redApple = (Apple a1) -> a1.getWeight().equals("red");
        Predicate<Apple> notRedApple = redApple.negate();

        // And
        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);

        // Or
        Predicate<Apple> reAndHeavyAppleOrGreen = redApple.and(apple -> apple.getWeight() > 150)
                .or(apple -> "GREEN".equals(apple.getColor()));

        // Function 조합
        // andThen
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result1 = h.apply(1);    // 결과 4 f를 먼저 실행

        Function<Integer, Integer> f2 = x -> x + 1;
        Function<Integer, Integer> g2 = x -> x * 2;
        Function<Integer, Integer> h2 = f2.compose(g2);
        int result2 = h.apply(1);    // 결과 3 g를 먼저 실행
    }
}
