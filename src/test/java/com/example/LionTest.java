package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void lionManeBasedOnSex() throws Exception {
        Predator mockPredator = mock(Predator.class);
        Lion lion = new Lion(sex, mockPredator);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Predator mockPredator = mock(Predator.class);
        List<String> expectedFood = List.of("Мясо", "Птицы");
        when(mockPredator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion(sex, mockPredator);
        assertEquals(expectedFood, lion.getFood());

        verify(mockPredator, times(1)).eatMeat();
    }

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        Feline feline = spy(new Feline());
        Lion lion = new Lion(sex, feline);
        assertEquals(1, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }

    @Test(expected = Exception.class)
    public void throwsExceptionIfSexIsInvalid() throws Exception {
        new Lion("Средний род", mock(Predator.class));
    }
}
