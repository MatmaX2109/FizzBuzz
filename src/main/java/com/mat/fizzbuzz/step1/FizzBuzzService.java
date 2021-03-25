package com.mat.fizzbuzz.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                        fizzBuzzComponent.multipleOf(i, MultipleOf.FIFTEEN) ? "FizzBuzz" :
                                fizzBuzzComponent.multipleOf(i, MultipleOf.THREE) ? "Fizz" :
                                        fizzBuzzComponent.multipleOf(i, MultipleOf.FIVE) ? "Buzz" : String.valueOf(i))
                .toArray(String[]::new);
    }
}
