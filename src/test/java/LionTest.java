import com.example.IFeline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LionTest {

    @Mock
    private IFeline felineMock;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Mockito.when(felineMock.getKittens()).thenReturn(2);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));

        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void lionHasManeIfMale() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getKittensReturnsMockedValue() {
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void getFoodReturnsMockedList() throws Exception {
        assertEquals(List.of("Мясо"), lion.getFood());
    }

    @Test(expected = Exception.class)
    public void throwsExceptionIfSexIsInvalid() throws Exception {
        new Lion("Неизвестно", felineMock);
    }
}
