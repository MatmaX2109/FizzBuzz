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

    public String generateReport(final List strings){
        StringBuilder sb = new StringBuilder();
        sb.append(SpecificWords.FIZZ.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.FIZZ.getValue())).append(" ");
        sb.append(SpecificWords.BUZZ.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.BUZZ.getValue())).append(" ");
        sb.append(SpecificWords.FIZZBUZZ.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.FIZZBUZZ.getValue())).append(" ");
        sb.append(SpecificWords.ALFRESCO.getValue()).append(" ").append(fizzBuzzComponent.count(strings,SpecificWords.ALFRESCO.getValue())).append(" ");
        sb.append(SpecificWords.ALFRESCO.getValue()).append(" ").append(fizzBuzzComponent.countTheRest(strings));

        return sb.toString();
    }

    public String generateString(final List<String> list){
        return String.join(", ", list);

    }

}
