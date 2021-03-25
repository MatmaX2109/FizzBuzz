package com.mat.fizzbuzz.step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FizzBuzzComponentTest {

    @InjectMocks FizzBuzzComponent fizzBuzzComponent;

    @Test
    void multipleOf3True() {
        assertTrue(fizzBuzzComponent.multipleOf(3, MultipleOf.THREE));
        assertFalse(fizzBuzzComponent.multipleOf(1, MultipleOf.THREE));
    }


    @Test
    void multipleOf5True() {
        assertTrue(fizzBuzzComponent.multipleOf(5, MultipleOf.FIVE));
        assertFalse(fizzBuzzComponent.multipleOf(1, MultipleOf.FIVE));
    }

    @Test
    void multipleOf15True() {
        assertTrue(fizzBuzzComponent.multipleOf(15, MultipleOf.FIFTEEN));
        assertFalse(fizzBuzzComponent.multipleOf(1, MultipleOf.FIFTEEN));
    }

    @Test
    void hasStringString(){
        assertTrue(fizzBuzzComponent.hasString("3", MultipleOf.THREE.toString()));
        assertFalse(fizzBuzzComponent.hasString("1", MultipleOf.THREE.toString()));
    }

    @Test
    void hasStringInt(){
        assertTrue(fizzBuzzComponent.hasString(3, MultipleOf.THREE.toString()));
        assertFalse(fizzBuzzComponent.hasString(1, MultipleOf.THREE.toString()));

    }
}