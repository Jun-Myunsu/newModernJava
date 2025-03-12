package org.example.defaultMethod;

public class Ambiguous implements BB, AA {
    public static void main(String... args) {
        new Ambiguous().hello();
    }
}

