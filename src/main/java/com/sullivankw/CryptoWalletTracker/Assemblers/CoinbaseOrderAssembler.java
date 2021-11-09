package com.sullivankw.CryptoWalletTracker.Assemblers;

import com.sullivankw.CryptoWalletTracker.dtos.coinbase.CoinbaseOrderDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CoinbaseOrderAssembler {

    public CoinbaseOrderDTO from(String[] row) {

        CoinbaseOrderDTO order = new CoinbaseOrderDTO();

        order.setTradeId(Integer.valueOf(row[1]));
        order.setTradingPairs(row[2]);
        order.setAction(row[3]);
        order.setExecuted(Instant.parse(row[4]));
        order.setAmount(Double.valueOf(row[5]));
        order.setAmountUnit(row[6]);
        order.setPrice(Double.valueOf(row[7]));
        order.setFee(Double.valueOf(row[8]));
        String replaced = row[9].replace("-", "");
        order.setTotalCost(Double.valueOf(replaced));
        order.setPayingUnit(row[10]);

        return order;
    }
}
