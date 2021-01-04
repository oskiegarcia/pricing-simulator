package org.oscar.pricing;

import org.oscar.pricing.provider.PriceGenerator;
import org.oscar.pricing.service.CryptoPriceService;
import org.oscar.pricing.service.PriceService;

public class CryptoPriceServiceDriver {
    public static void main(String[] args) {
        PriceService service = new CryptoPriceService(PriceGenerator.create());
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%.8f\n", service.getPrice(CryptoPair.of("XRP", "USD")));
        }
    }
}
