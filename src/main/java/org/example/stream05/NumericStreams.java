package org.example.stream05;
import static org.example.stream04.Dish.menu;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.example.stream04.Dish;

/*
기본형 특화 스트림
IntStream, DoubleStream, LongStream\
.boxed

.mapToInt, .mapToDouble, .mapToLong 지원 메서드 (max, min, sum, average...)
.mapToObj

OptionalInt, OptionalDouble, OptionalLong

* 값으로 스트림 만들기
 : 임의의 수를 인수로 받는 정적 메서드 Steam.of를 이용해서 스트림을 만들 수 있다

 */
public class NumericStreams {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray())
                .forEach(System.out::println);

        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories:" + calories);

        // 객체 스트림으로 복원
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        // max와 OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(1);
/*
        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            // 기본값을 선택할 수 있음
            max = 1;
        }
 */
        System.out.println(max);

        // 숫자 범위 (range 종료값 포함 X, rangeClosed 종료값 포함
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println("숫자 범위 range : " + evenNumbers.count());

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)
                );

        System.out.println("피타고라스");
        pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        //
        Stream<String> strm = Stream.of("Modern", "Java", "In ", "Action");
        strm.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();    // 비워진 스트림

        // null이 될 수 있는 객체를 스트림(객체가 null이라면 빈 스트림)으로 만들어야 할 수 있다.
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        // 배열로 스트림 만들기
        int[] arrNums = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(arrNums).sum();

        // 파일로 스트림 만들기
        // : 파일을 처리하는 등의 I/O 연산에 사용하는 자바의 NIO API(비블록I/O)도 스트림 API를 활용할 수 있도록 업데이트 되었다.
        long uniqueWords = 0;
        try {
            Stream<String> lines = Files.lines(Paths.get("C:\\Dev\\Java\\ModernJava\\src\\main\\resources\\data.txt"), Charset.defaultCharset());
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
//                    .forEach(System.out::println);
                    .distinct()
                    .count();
        } catch (IOException e){

        }
        System.out.println("uniqueWords = " + uniqueWords);

//            Stream<String> lines = Files.lines(Paths.get("../resources/data.txt"), Charset.defaultCharset()))

        // 함수로 무한 스트림 만들기
        // iterate 초기값을 가지고 계속된 함수 실행, 연속된 일련의 값을 만들 때 사용
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 피보나치 수열
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        // iterate 예제
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        // generate 메서도
        // Supplier<T> () -> T 인수를 받아 새로운 값을 생산
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }

    public static boolean isPerfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

}
