package com.sullivankw.CryptoWalletTracker.services;

import com.sullivankw.CryptoWalletTracker.Assemblers.CryptoAssembler;
import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.TotalCryptoPurchaseValueResponseDTO;
import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import com.sullivankw.CryptoWalletTracker.models.CryptoPurchaseEntity;
import com.sullivankw.CryptoWalletTracker.repos.CryptoParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private CryptoParentRepo cryptoParentRepo;

    @Autowired
    private CryptoAssembler cryptoAssembler;

    public TotalCryptoPurchaseValueResponseDTO purchase(CryptoPurchasePostDTO purchasePostDTO) {
        CryptoParentEntity parentEntity = cryptoParentRepo.findByNameAndWallet(purchasePostDTO.getName(), purchasePostDTO.getWallet())
                .orElse(buildCryptoParentEntity(purchasePostDTO));
        addPurchase(parentEntity, purchasePostDTO);
        setAveragePrice(parentEntity);

        CryptoParentEntity savedEntity = cryptoParentRepo.save(parentEntity); //todo failing here
        
        return cryptoAssembler.from(savedEntity, purchasePostDTO);
    }

    private CryptoParentEntity buildCryptoParentEntity(CryptoPurchasePostDTO purchasePostDTO) {
        return new CryptoParentEntity(purchasePostDTO.getName(), //todo polly should put an average price on indy purchases as well
                purchasePostDTO.getSymbol(), //todo add the acceptable values on enum
                purchasePostDTO.getWallet());
    }

    private void addPurchase(CryptoParentEntity parentEntity, CryptoPurchasePostDTO purchasePostDTO) {
        CryptoPurchaseEntity purchaseEntity = new CryptoPurchaseEntity(purchasePostDTO.getPurchasedExchange(),
                purchasePostDTO.getValue(),
                purchasePostDTO.getCoins(),
                purchasePostDTO.getFee());
        parentEntity.addPurchase(purchaseEntity);
    }

    private void setAveragePrice(CryptoParentEntity parentEntity) {

        List<CryptoPurchaseEntity> purchases = parentEntity.getPurchases();

        double totalPurchasedCoins = purchases.stream()
                .mapToDouble(CryptoPurchaseEntity::getCoins)
                .sum();
        double totalPurchasedValue = purchases.stream()
                .mapToDouble(CryptoPurchaseEntity::getValue)
                .sum();

        double average = totalPurchasedValue / totalPurchasedCoins;

        parentEntity.setAveragePrice(average);
    }
}
