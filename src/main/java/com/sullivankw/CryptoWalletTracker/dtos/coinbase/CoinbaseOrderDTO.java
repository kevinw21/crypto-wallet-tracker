package com.sullivankw.CryptoWalletTracker.dtos.coinbase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinbaseOrderDTO {

    //portfolio,trade id,product,side,created at,size,size unit,price,fee,total,price/fee/total unit

    private int tradeId;

    private String tradingPairs;

    private String action;

    private Instant executed;

    private double amount;

    private String amountUnit;

    private double price;

    private double fee;

    private double totalCost;

    private String payingUnit;

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradingPairs() {
        return tradingPairs;
    }

    public void setTradingPairs(String tradingPairs) {
        this.tradingPairs = tradingPairs;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Instant getExecuted() {
        return executed;
    }

    public void setExecuted(Instant executed) {
        this.executed = executed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPayingUnit() {
        return payingUnit;
    }

    public void setPayingUnit(String payingUnit) {
        this.payingUnit = payingUnit;
    }
}
