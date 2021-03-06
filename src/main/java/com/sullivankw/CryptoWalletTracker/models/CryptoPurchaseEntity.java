package com.sullivankw.CryptoWalletTracker.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CryptoPurchaseEntity {

    @Id
    private String uuid;

    @Enumerated(EnumType.STRING)
    private Exchange purchasedExchange;

    private double value;

    private double coins;

    private double averagePrice;

    private double fee;

    @ManyToOne(fetch = FetchType.LAZY) //todo maybe wrong fetch
    private CryptoParentEntity cryptoParentEntity;

    public CryptoPurchaseEntity(Exchange purchasedExchange, double value, double coins, double fee) {
        this.uuid = UUID.randomUUID().toString();
        this.purchasedExchange = purchasedExchange;
        this.value = value;
        this.coins = coins;
        this.fee = fee;
        this.averagePrice = this.value / this.coins;
    }

    public CryptoPurchaseEntity() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public CryptoParentEntity getCryptoParentEntity() {
        return cryptoParentEntity;
    }

    public void setCryptoParentEntity(CryptoParentEntity cryptoParentEntity) {
        this.cryptoParentEntity = cryptoParentEntity;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
