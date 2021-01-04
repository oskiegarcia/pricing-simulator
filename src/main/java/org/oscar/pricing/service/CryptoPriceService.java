package org.oscar.pricing.service;

import org.oscar.pricing.CryptoPair;
import org.oscar.pricing.provider.PriceProvider;

import java.math.BigDecimal;

public class CryptoPriceService implements PriceService {

    private final PriceProvider provider;

    public CryptoPriceService(PriceProvider provider) {
        this.provider = provider;
    }

    @Override
    public BigDecimal getPrice(CryptoPair cryptoPair) {
        return provider.getPrice(cryptoPair);
    }
}
