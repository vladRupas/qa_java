package com.example;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals("eatMeat должен возвращать список хищной еды", expected, actual);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("getFamily должен возвращать 'Кошачьи'", expected, actual);
    }

    @Test
    public void getKittensReturnsDefaultValueOne() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals("getKittens без параметров должен возвращать 1", expected, actual);
    }

    @Test
    public void getKittensWithParamReturnsCorrectValue() {
        int expected = 3;
        int actual = feline.getKittens(3);
        assertEquals("getKittens с параметром должен возвращать его же", expected, actual);
    }
}
