package com.sullivankw.CryptoWalletTracker.services;

import com.sullivankw.CryptoWalletTracker.Assemblers.CryptoAssembler;
import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.SingleCryptoInWalletSummaryDTO;
import com.sullivankw.CryptoWalletTracker.dtos.TotalCryptoPurchaseValueResponseDTO;
import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import com.sullivankw.CryptoWalletTracker.models.CryptoPurchaseEntity;
import com.sullivankw.CryptoWalletTracker.models.Wallet;
import com.sullivankw.CryptoWalletTracker.repos.CryptoParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.lang.String.format;

@Service
public class WalletService {

    @Autowired
    private CryptoParentRepo cryptoParentRepo;

    @Autowired
    private CryptoAssembler cryptoAssembler;

    public TotalCryptoPurchaseValueResponseDTO purchase(CryptoPurchasePostDTO purchasePostDTO) {
        CryptoParentEntity parentEntity = cryptoParentRepo.findBySymbolAndWallet(purchasePostDTO.getSymbol(),
                purchasePostDTO.getWallet())
                .orElse(buildCryptoParentEntity(purchasePostDTO));
        addPurchase(parentEntity, purchasePostDTO);
        setTotals(parentEntity);

        CryptoParentEntity savedEntity = cryptoParentRepo.save(parentEntity);
        
        return cryptoAssembler.from(savedEntity, purchasePostDTO);
    }

    public SingleCryptoInWalletSummaryDTO getBySymbolAndWallet(String symbol, Wallet wallet) {
        CryptoParentEntity parentEntity = cryptoParentRepo.findBySymbolAndWallet(symbol,
                wallet).orElseThrow((() -> new EntityNotFoundException(
                format("No holdings for %s in wallet %s", symbol, wallet))));
        return cryptoAssembler.from(parentEntity);
    }

    public List<SingleCryptoInWalletSummaryDTO> getAllHoldings() {
        List<CryptoParentEntity> parentList =  cryptoParentRepo.findAll();
        return cryptoAssembler.from(parentList);
    }

    private CryptoParentEntity buildCryptoParentEntity(CryptoPurchasePostDTO purchasePostDTO) {
        return new CryptoParentEntity(purchasePostDTO.getName(),
                purchasePostDTO.getSymbol(),
                purchasePostDTO.getWallet());
    }

    private void addPurchase(CryptoParentEntity parentEntity, CryptoPurchasePostDTO purchasePostDTO) {
        CryptoPurchaseEntity purchaseEntity = new CryptoPurchaseEntity(purchasePostDTO.getPurchasedExchange(),
                purchasePostDTO.getValue(),
                purchasePostDTO.getCoins(),
                purchasePostDTO.getFee());
        parentEntity.addPurchase(purchaseEntity);
    }

    private void setTotals(CryptoParentEntity parentEntity) {
        List<CryptoPurchaseEntity> purchases = parentEntity.getPurchases();

        double totalPurchasedCoins = purchases.stream()
                .mapToDouble(CryptoPurchaseEntity::getCoins)
                .sum();

        double totalPurchasedValue = purchases.stream()
                .mapToDouble(CryptoPurchaseEntity::getValue)
                .sum();

        double average = totalPurchasedValue / totalPurchasedCoins;

        double totalFees = purchases.stream()
                .mapToDouble(CryptoPurchaseEntity::getFee)
                .sum();

        parentEntity.setAveragePrice(average);
        parentEntity.setTotalCoins(totalPurchasedCoins);
        parentEntity.setTotalValue(totalPurchasedValue);
        parentEntity.setTotalFees(totalFees);
    }
}
