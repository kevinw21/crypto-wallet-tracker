package com.sullivankw.CryptoWalletTracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class CryptoParentEntity {

    @Id
    private String uuid = UUID.randomUUID().toString();

    private String name;

    private String symbol;

    @Enumerated(EnumType.STRING)
    private Wallet wallet;

    private double averagePrice;

    private double totalValue;

    private double totalCoins;

    private double totalFees;

    @OneToMany(mappedBy = "cryptoParentEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CryptoPurchaseEntity> purchases = new ArrayList<>();

    public CryptoParentEntity(String name, String symbol, Wallet wallet) {
        this.name = name;
        this.symbol = symbol;
        this.wallet = wallet;
    }

    public CryptoParentEntity() {
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public List<CryptoPurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<CryptoPurchaseEntity> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(CryptoPurchaseEntity cryptoPurchaseEntity)  {
        this.getPurchases().add(cryptoPurchaseEntity);
        cryptoPurchaseEntity.setCryptoParentEntity(this);
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(double totalCoins) {
        this.totalCoins = totalCoins;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }
}
