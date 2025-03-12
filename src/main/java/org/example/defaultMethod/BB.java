package org.example.defaultMethod;

public interface BB extends AA {
    default void hello() {
        System.out.println("Hello from B");
    }
}
