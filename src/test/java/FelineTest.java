import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getDefaultKittensReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensReturnsProvidedValue() {
        assertEquals(3, feline.getKittens(3));
    }
}
