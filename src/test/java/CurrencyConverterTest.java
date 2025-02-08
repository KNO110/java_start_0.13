package test.java;

import main.java.CurrencyConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyConverterTest {
    @Test
    public void testConvertCurrency() {
        assertEquals(100.0, CurrencyConverter.convertCurrency(100, 1, 1), 0.001);
        assertEquals(100 / 1.1, CurrencyConverter.convertCurrency(100, 1, 2), 0.001);
    }
}
