package com.sullivankw.CryptoWalletTracker.Assemblers;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchaseResponseDTO;
import com.sullivankw.CryptoWalletTracker.dtos.TotalCryptoPurchaseValueResponseDTO;
import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import com.sullivankw.CryptoWalletTracker.models.CryptoPurchaseEntity;
import org.springframework.stereotype.Component;

@Component
public class CryptoAssembler {

    public CryptoPurchaseResponseDTO from(CryptoPurchaseEntity purchaseEntity, CryptoPurchasePostDTO postDTO) {
        return new CryptoPurchaseResponseDTO(purchaseEntity.getUuid(), postDTO.getPurchasedExchange(),
                postDTO.getValue(),
                postDTO.getCoins(),
                postDTO.getFee(),
                purchaseEntity.getAveragePrice());
    }

    public TotalCryptoPurchaseValueResponseDTO from(CryptoParentEntity parentEntity,
                                                    CryptoPurchasePostDTO postDTO) {
        TotalCryptoPurchaseValueResponseDTO response = new TotalCryptoPurchaseValueResponseDTO();
        response.setName(parentEntity.getName());
        response.setSymbol(parentEntity.getSymbol());
        response.setAveragePrice(parentEntity.getAveragePrice());
        response.setUuid(parentEntity.getUuid());
        response.setAddedPurchase(from(getRecentPurchaseEntity(parentEntity), postDTO));
        return response;
    }

    private CryptoPurchaseEntity getRecentPurchaseEntity(CryptoParentEntity parentEntity) {
        return parentEntity.getPurchases().get(parentEntity.getPurchases().size() -1);
    }
}
