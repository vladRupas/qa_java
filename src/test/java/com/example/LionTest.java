package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test(expected = Exception.class)
    public void lionThrowsExceptionIfInvalidSex() throws Exception {
        new Lion("Неопределён", felineMock);
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(mockFood);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(mockFood, lion.getFood());
    }

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самка", felineMock);
        assertEquals(3, lion.getKittens());
    }
}
