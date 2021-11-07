package com.sullivankw.CryptoWalletTracker.dtos;

import com.sullivankw.CryptoWalletTracker.models.Wallet;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class TotalCryptoPurchaseValueResponseDTO {

    private String uuid;

    private String name;

    private String symbol;

    @Enumerated(EnumType.STRING)
    private Wallet wallet;

    private double averagePrice;

    private double totalCoins;

    private double totalValue;

    private double totalFees;

    private CryptoPurchaseResponseDTO addedPurchase;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public CryptoPurchaseResponseDTO getAddedPurchase() {
        return addedPurchase;
    }

    public void setAddedPurchase(CryptoPurchaseResponseDTO addedPurchase) {
        this.addedPurchase = addedPurchase;
    }

    public double getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(double totalCoins) {
        this.totalCoins = totalCoins;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }
}
