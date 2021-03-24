package com.mat.fizzbuzz.step1;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzzComponent {

    public boolean multipleOf(int n, MultipleOf m){
       if(n % m.getValue() == 0){
           return true;
       }
       return false;
    }

}
