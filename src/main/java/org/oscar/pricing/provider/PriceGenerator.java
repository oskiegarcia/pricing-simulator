package org.oscar.pricing.provider;

import org.oscar.pricing.CryptoPair;
import org.oscar.pricing.Initial;
import org.oscar.pricing.Volatility;
import org.oscar.pricing.engine.CryptoPriceEngine;
import org.oscar.pricing.engine.PriceEngine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceGenerator implements PriceProvider {


    private final Map<CryptoPair, PriceEngine> engine;

    private PriceGenerator() {
        engine = new HashMap<>();
        addPriceEngines();
    }

    public static PriceGenerator create() {
        return new PriceGenerator();
    }

    private void addPriceEngines() {
        // BTC/USD - Bitcoin
        PriceEngine btcUsd = CryptoPriceEngine.create(Initial.valueOf(30000.0d), Volatility.range(1, 15));
        engine.put(CryptoPair.of("BTC", "USD"), btcUsd);

        // ETH/USD - Ethereum
        PriceEngine ethUsd = CryptoPriceEngine.create(Initial.valueOf(900.0d), Volatility.range(1, 10));
        engine.put(CryptoPair.of("ETH", "USD"), ethUsd);

        // LTC/USD - Litecoin
        PriceEngine ltcUsd = CryptoPriceEngine.create(Initial.valueOf(155.0d), Volatility.range(1, 10));
        engine.put(CryptoPair.of("LTC", "USD"), ltcUsd);

        // DOT/USD - Polkadot
        PriceEngine dotUsd = CryptoPriceEngine.create(Initial.valueOf(9.0d), Volatility.range(1, 10));
        engine.put(CryptoPair.of("DOT", "USD"), dotUsd);

        // UNI/USD - Uniswap
        PriceEngine uniUsd = CryptoPriceEngine.create(Initial.valueOf(5.0d), Volatility.range(1, 10));
        engine.put(CryptoPair.of("UNI", "USD"), uniUsd);

        // XRP/USD - Ripple
        PriceEngine xrpUsd = CryptoPriceEngine.create(Initial.valueOf(0.2280d), Volatility.range(1, 20));
        engine.put(CryptoPair.of("XRP", "USD"), xrpUsd);

        // BAT/USD - Basic Attention Token
        PriceEngine batUsd = CryptoPriceEngine.create(Initial.valueOf(0.2089d), Volatility.range(1, 10));
        engine.put(CryptoPair.of("XRP", "USD"), batUsd);

        // ZIL/USD - Ziliqa
        PriceEngine zilUsd = CryptoPriceEngine.create(Initial.valueOf(0.0690d), Volatility.range(1, 10));
        engine.put(CryptoPair.of("XRP", "USD"), zilUsd);

        // XLM/USD - Stellar
        PriceEngine xlmUsd = CryptoPriceEngine.create(Initial.valueOf(0.0263d), Volatility.range(1, 8));
        engine.put(CryptoPair.of("XLM", "USD"), xlmUsd);

    }


    @Override
    public BigDecimal getPrice(CryptoPair pair) {

        if (!engine.containsKey(pair)) {
            throw new IllegalArgumentException("Crypto Pair is not supported: " + pair.crypto() + "/" + pair.currency());
        }

        return engine.get(pair).getPrice();

    }

}
