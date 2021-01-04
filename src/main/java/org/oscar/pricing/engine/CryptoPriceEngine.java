package org.oscar.pricing.engine;

import org.oscar.pricing.Volatility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CryptoPriceEngine implements PriceEngine {
    private BigDecimal currentPrice;
    private final Volatility volatilityRange;
    private final BigDecimal minPrice = BigDecimal.valueOf(0.00000001d);

    private CryptoPriceEngine(BigDecimal initialPrice, Volatility volatilityRange) {
        this.currentPrice = initialPrice;
        this.volatilityRange = volatilityRange;
    }

    public static CryptoPriceEngine create(BigDecimal initialPrice, Volatility volatilityRange) {
        return new CryptoPriceEngine(initialPrice, volatilityRange);
    }

    @Override
    public BigDecimal getPrice() {

        BigDecimal newPrice = currentPrice.add(delta()).setScale(8, RoundingMode.FLOOR);
        this.currentPrice = newPrice.compareTo(minPrice) > 0 ? newPrice : minPrice;

        return this.currentPrice;
    }

    private BigDecimal volatilityFactor() {
        Random random = new Random();

        int randomValue = random.nextInt(volatilityRange.max() - volatilityRange.min() + 1) + volatilityRange.min();
        BigDecimal volatilityFactor = BigDecimal.valueOf(randomValue / 100.0);
        return volatilityFactor;
    }

    private BigDecimal delta() {
        BigDecimal delta = this.currentPrice.multiply(volatilityFactor());
        boolean isPositive = Math.random() > 0.45; //bias to positive
        BigDecimal sign = isPositive ? BigDecimal.valueOf(1) : BigDecimal.valueOf(-1);
        delta = delta.compareTo(minPrice) > 0 ? delta.multiply(sign) : minPrice;
        return delta;
    }
}
