package com.sullivankw.CryptoWalletTracker.dtos;

import com.sullivankw.CryptoWalletTracker.models.Exchange;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CryptoPurchaseResponseDTO {

    private String uuid;

    @Enumerated(EnumType.STRING)
    private Exchange purchasedExchange;

    private double value;

    private double coins;

    private Double fee;

    private double averagePrice;

    public CryptoPurchaseResponseDTO(String uuid, Exchange purchasedExchange, double value,
                                     double coins, Double fee, double averagePrice) {
        this.uuid = uuid;
        this.purchasedExchange = purchasedExchange;
        this.value = value;
        this.coins = coins;
        this.fee = fee;
        this.averagePrice = averagePrice;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Exchange getPurchasedExchange() {
        return purchasedExchange;
    }

    public void setPurchasedExchange(Exchange purchasedExchange) {
        this.purchasedExchange = purchasedExchange;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
