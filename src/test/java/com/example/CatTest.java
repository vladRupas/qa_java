package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    Predator predatorMock;
    Cat cat;

    @Before
    public void setUp() {
        predatorMock = mock(Predator.class);
        cat = new Cat((Feline) predatorMock);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Рыба", "Птицы");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);

        verify(predatorMock, times(1)).eatMeat();
    }
}
