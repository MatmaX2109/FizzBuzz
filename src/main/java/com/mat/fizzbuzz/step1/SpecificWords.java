package com.mat.fizzbuzz.step1;

public enum SpecificWords {
    FIZZ("fizz"),
    BUZZ("buzz"),
    FIZZBUZZ("fizzbuzz"),
    ALFRESCO("alfresco");

    private final String value;

    SpecificWords(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
