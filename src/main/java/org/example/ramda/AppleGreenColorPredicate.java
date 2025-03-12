package org.example.ramda;

public class AppleGreenColorPredicate {

    private enum Color {RED, GREEN}

    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
