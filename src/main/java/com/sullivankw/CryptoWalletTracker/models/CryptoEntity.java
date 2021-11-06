package com.sullivankw.CryptoWalletTracker.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CryptoEntity {

    @Id
    private UUID uuid;

    private String name;

    @Enumerated(EnumType.STRING)
    private Exchange purchasedExchange;

    @Enumerated(EnumType.STRING)
    private Wallet currentWallet;

    private double totalValue;

    private double averagePrice;

    private double coins;

    public CryptoEntity(String name, Exchange purchasedExchange, Wallet currentWallet,
                        double totalValue, double averagePrice, double coins) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.purchasedExchange = purchasedExchange;
        this.currentWallet = currentWallet;
        this.totalValue = totalValue;
        this.averagePrice = averagePrice;
        this.coins = coins;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

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
