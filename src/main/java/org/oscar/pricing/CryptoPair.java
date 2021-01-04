package org.oscar.pricing;

import java.util.Objects;

public class CryptoPair {
    private final String crypto;
    private final String currency;

    private CryptoPair(String crypto, String currency) {
        this.crypto = crypto;
        this.currency = currency;
    }

    public static CryptoPair of(String crypto, String currency) {
        return new CryptoPair(crypto, currency);
    }

    public String crypto() {
        return crypto;
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoPair that = (CryptoPair) o;
        return crypto.equals(that.crypto) && currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crypto, currency);
    }
}
