package com.mat.fizzbuzz.step1;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzzComponent {

    public boolean multipleOf(final int n, final MultipleOf m){
       return (n % m.getValue() == 0)?true:false;
    }

    public boolean hasString(final int s, final String c){
        return hasString(String.valueOf(s), c);
    }

    public boolean hasString(final String s, final String c){
        return s.contains(c)?true:false;
    }


}
