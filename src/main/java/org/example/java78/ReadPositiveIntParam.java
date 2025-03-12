package org.example.java78;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

import java.util.Optional;
import java.util.Properties;

public class ReadPositiveIntParam {


    public static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
            }
        }
        return 0;
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return ofNullable(props.getProperty(name))
                .flatMap(ReadPositiveIntParam::StringToInt)
                .filter(i -> i > 0).orElse(0);
    }

    public static Optional<Integer> StringToInt(String strNum) {
        try {
            return of(Integer.parseInt(strNum));
        } catch (NumberFormatException e) {
            return empty();
        }
    }

}
