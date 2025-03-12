package org.example.ramda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalTestConsumer {

    static <T> void forEach(List<T> list, Consumer<T> fn) {
        for (T t : list) {
            fn.accept(t);
        }
    }

    public static void main(String... args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
    }
}
