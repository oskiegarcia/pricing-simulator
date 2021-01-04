package org.oscar.pricing;

public class Volatility {
    private final int min;
    private final int max;

    private Volatility(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Volatility range(int min, int max) {
        return new Volatility(min, max);
    }

    public int min() {
        return min;
    }

    public int max() {
        return max;
    }
}
