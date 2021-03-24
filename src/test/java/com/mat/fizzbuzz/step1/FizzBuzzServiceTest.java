package com.mat.fizzbuzz.step1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService = new FizzBuzzService();

    @BeforeAll
    void init() {
        fizzBuzzService.setFizzBuzzComponent(new FizzBuzzComponent());
    }
    @Test
    void transform() {
        String[] test = fizzBuzzService.transform(1, 5);

        assertTrue(test[0].equals("1"));
        assertTrue(test[1].equals("2"));
        assertTrue(test[2].equals("Fizz"));
        assertTrue(test[3].equals("4"));
        assertTrue(test[4].equals("Buzz"));

//        Arrays.stream(test).forEach(System.out::print);

    }
}