package com.mat.fizzbuzz.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {

    private FizzBuzzComponent fizzBuzzComponent;

    @Autowired
    public void setFizzBuzzComponent(FizzBuzzComponent fizzBuzzComponent) {
        this.fizzBuzzComponent = fizzBuzzComponent;
    }

    public String[] transform(final int startInterval, final int endInterval){
        return IntStream.rangeClosed(startInterval, endInterval)
                .mapToObj(i -> fizzBuzzComponent.hasString(i, MultipleOf.THREE.toString())?"alfresco":
                        fizzBuzzComponent.multipleOf(i, MultipleOf.FIFTEEN) ? "fizzbuzz" :
                                fizzBuzzComponent.multipleOf(i, MultipleOf.THREE) ? "fizz" :
                                        fizzBuzzComponent.multipleOf(i, MultipleOf.FIVE) ? "buzz" : String.valueOf(i))
                .toArray(String[]::new);
    }

    public void printReport(final List strings){
        StringBuilder sb = new StringBuilder();
        sb.append(SpecificWords.FIZZ.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.FIZZ.getValue())).append(" ");
        sb.append(SpecificWords.BUZZ.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.BUZZ.getValue())).append(" ");
        sb.append(SpecificWords.FIZZBUZZ.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.FIZZBUZZ.getValue())).append(" ");
        sb.append(SpecificWords.ALFRESCO.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.ALFRESCO.getValue())).append(" ");
        sb.append("Integer").append(" ").append(fizzBuzzComponent.countTheRest(strings)).append(" ");

        System.out.print(sb);
    }

    public void printString(final List list){
        System.out.print(list.stream()
                .collect(Collectors.joining(", ")));
        System.out.println("");

    }

}
