package org.oscar.pricing.provider;

import org.junit.jupiter.api.Test;
import org.oscar.pricing.CryptoPair;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PriceGeneratorTest {

    @Test
    void shouldEmitPrice() {
        PriceGenerator pg = PriceGenerator.create();
        BigDecimal price = pg.getPrice(CryptoPair.of("BTC", "USD"));
        assertNotNull(price);
    }

    @Test
    void shouldThrowExceptionWhenCryptoPairNotSupported() {
        PriceGenerator pg = PriceGenerator.create();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> pg.getPrice(CryptoPair.of("BTC", "PHP")));
        assertEquals("Crypto Pair is not supported: BTC/PHP", exception.getMessage());

    }
}
