package org.example.defaultMethod;

public interface AA {
    default void hello() {
        System.out.println("Hello from A");
    }
}
