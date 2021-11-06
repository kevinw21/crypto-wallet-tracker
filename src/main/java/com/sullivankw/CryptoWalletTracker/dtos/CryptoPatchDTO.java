package com.sullivankw.CryptoWalletTracker.dtos;

import com.sullivankw.CryptoWalletTracker.models.Exchange;
import com.sullivankw.CryptoWalletTracker.models.Wallet;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

public class CryptoPatchDTO {

    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private Wallet currentWallet;

    private double totalValue;

    private double averagePrice;

    private double coins;
}
