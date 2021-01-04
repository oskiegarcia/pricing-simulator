package org.oscar.pricing.service;

import org.oscar.pricing.CryptoPair;

import java.math.BigDecimal;

public interface PriceService {
    BigDecimal getPrice(CryptoPair cryptoPair);
}
