package com.sullivankw.CryptoWalletTracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class CryptoParentEntity {

    @Id
    private UUID uuid = UUID.randomUUID();

    private String name;

    private String symbol;

    @Enumerated(EnumType.STRING)
    private Wallet wallet;

    private double averagePrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CryptoPurchaseEntity> purchases = new ArrayList<>();


    public UUID getUuid() {
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
        this.purchases.clear();
        this.purchases.addAll(purchases);
    }

    //calculate property for totals
}
