package org.oscar.pricing.service;

import org.junit.jupiter.api.Test;
import org.oscar.pricing.CryptoPair;
import org.oscar.pricing.provider.PriceProvider;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CryptoPriceServiceTest {

    @Test
    void shouldGetPrice() {
        PriceProvider provider = mock(PriceProvider.class);

        PriceService ps = new CryptoPriceService(provider);
        when(provider.getPrice(CryptoPair.of("BTC", "USD"))).thenReturn(BigDecimal.valueOf(100));
        BigDecimal price = ps.getPrice(CryptoPair.of("BTC", "USD"));
        assertNotNull(price);
        assertEquals(BigDecimal.valueOf(100), price);

    }
}
