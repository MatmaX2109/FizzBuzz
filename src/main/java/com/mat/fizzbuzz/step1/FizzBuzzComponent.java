package com.mat.fizzbuzz.step1;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

    public long count(final List strings, final String s){
        return strings.stream()
                .filter(e->(e.equals(s)))
                .count();
    }

    public long countTheRest(final List<String> strings){
        return strings.stream()
                .filter(e-> !existInArray(e, SpecificWords.FIZZ.getValue(), SpecificWords.BUZZ.getValue(), SpecificWords.FIZZBUZZ.getValue(), SpecificWords.ALFRESCO.getValue()))
                .count();
    }

    private boolean existInArray(final String s, final String... strings){
        return Arrays.stream(strings).anyMatch(s::equals);
    }

}
