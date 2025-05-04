package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParamReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParamReturnsCorrectValue() {
        assertEquals(3, feline.getKittens(3));
    }
}
