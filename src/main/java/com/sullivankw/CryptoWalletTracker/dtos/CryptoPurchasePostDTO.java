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
    private Wallet wallet;

    private double value;

    private double coins;

    private Double fee;

    private String symbol;

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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
