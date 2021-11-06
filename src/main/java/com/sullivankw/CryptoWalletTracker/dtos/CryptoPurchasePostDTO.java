package com.sullivankw.CryptoWalletTracker.dtos;

import com.sullivankw.CryptoWalletTracker.models.Exchange;
import com.sullivankw.CryptoWalletTracker.models.Wallet;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CryptoPurchasePostDTO {

    private String name;

    @Enumerated(EnumType.STRING)
    private Exchange purchasedExchange;

    @Enumerated(EnumType.STRING)
    private Wallet currentWallet;

    private double totalValue;

    private double averagePrice;

    private double coins;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exchange getPurchasedExchange() {
        return purchasedExchange;
    }

    public void setPurchasedExchange(Exchange purchasedExchange) {
        this.purchasedExchange = purchasedExchange;
    }

    public Wallet getCurrentWallet() {
        return currentWallet;
    }

    public void setCurrentWallet(Wallet currentWallet) {
        this.currentWallet = currentWallet;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }
}
