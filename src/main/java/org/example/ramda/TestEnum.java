package org.example.ramda;

public enum TestEnum {
        MON("Monday"),
        TUE("Tuesday");

    private final String label;

    TestEnum(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
