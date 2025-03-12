package org.example.ramda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalTestFunction {
    static <T, R> List<R> map(List<T> list, Function<T, R> fn) {
        List<R> result = new ArrayList<>();
        for(T t : list) {
            result.add(fn.apply(t));
        }
        return result;
    }
    public static void main(String...args) {
        List<Integer> list = map(Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length());

        System.out.println(list.toString());
        System.out.println(list.get(0).getClass().getName());

        Runnable r = () -> System.out.println("Tricky eample");
        Object o = (Runnable) () -> System.out.println("Tricky eample");
        r.run();
        ((Runnable) o).run();
    }
}
