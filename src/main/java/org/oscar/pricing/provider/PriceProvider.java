package org.oscar.pricing.provider;

import org.oscar.pricing.CryptoPair;

import java.math.BigDecimal;

public interface PriceProvider {
    BigDecimal getPrice(CryptoPair pair);
}
