package org.example.RamdaDsl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PrintNumbers {

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("one", "two", "three");

        System.out.println("Anonymous class:");
        numbers.forEach(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }

        });

        System.out.println("Lambda expression:");
        numbers.forEach(s -> System.out.println(s));

        System.out.println("Method reference:");
        numbers.forEach(System.out::println);

        String fileName = "";

      try {
        List<String> errors = Files.lines(Paths.get(fileName))
                .filter(line -> line.startsWith("ERROR"))
                .limit(40)
                .collect(Collectors.toList());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

}
