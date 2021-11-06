package com.sullivankw.CryptoWalletTracker.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CryptoPurchaseEntity {

    @Id
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private Exchange purchasedExchange;

    private double value;

    private double coins;

    @ManyToOne
    @JoinTable(
            name = "crypto_purchase_entity_purchases",
            joinColumns = @JoinColumn(name = "purchase_uuid"),
            inverseJoinColumns = @JoinColumn(name = "crypto_parent_entity_uuid")
    )
    private CryptoParentEntity parent;

    public CryptoPurchaseEntity(Exchange purchasedExchange, double value, double coins) {
        this.uuid = UUID.randomUUID();
        this.purchasedExchange = purchasedExchange;
        this.value = value;
        this.coins = coins;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Exchange getPurchasedExchange() {
        return purchasedExchange;
    }

    public void setPurchasedExchange(Exchange purchasedExchange) {
        this.purchasedExchange = purchasedExchange;
    }

    public double getTotalValue() {
        return value;
    }

    public void setTotalValue(double value) {
        this.value = value;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }
}
