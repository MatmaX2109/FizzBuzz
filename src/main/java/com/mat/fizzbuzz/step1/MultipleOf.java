package com.mat.fizzbuzz.step1;

public enum MultipleOf {
    THREE(3),
    FIVE(5),
    FIFTEEN(15);

    private final int value;

    MultipleOf(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

}
