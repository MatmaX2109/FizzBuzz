package com.mat.fizzbuzz.step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void count(){
        List list = new ArrayList();
        list.add(SpecificWords.FIZZ.getValue());
        list.add(SpecificWords.FIZZ.getValue());

        assertEquals(fizzBuzzComponent.count(list, SpecificWords.FIZZ.getValue()), 2);
        assertNotEquals(fizzBuzzComponent.count(list, SpecificWords.FIZZ.getValue()), 1);
    }

    @Test
    public void countTheRest(){

        List list = new ArrayList();
        list.add(SpecificWords.FIZZ.getValue());
        list.add(1);

        assertEquals(fizzBuzzComponent.countTheRest(list),1);
        assertNotEquals(fizzBuzzComponent.countTheRest(list),0);
    }

//    @Test
//    private void existInArray(){
//        assertTrue(fizzBuzzComponent.existInArray(SpecificWords.FIZZ.getValue(), SpecificWords.FIZZ.getValue()));
//    }
}
