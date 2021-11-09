package com.sullivankw.CryptoWalletTracker.Assemblers;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchaseResponseDTO;
import com.sullivankw.CryptoWalletTracker.dtos.SingleCryptoInWalletSummaryDTO;
import com.sullivankw.CryptoWalletTracker.dtos.TotalCryptoPurchaseValueResponseDTO;
import com.sullivankw.CryptoWalletTracker.dtos.coinbase.CoinbaseOrderDTO;
import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import com.sullivankw.CryptoWalletTracker.models.CryptoPurchaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CryptoAssembler {

    private ModelMapper modelMapper = new ModelMapper();

    public CryptoPurchaseResponseDTO from(CryptoPurchaseEntity purchaseEntity, CryptoPurchasePostDTO postDTO) {
        return new CryptoPurchaseResponseDTO(purchaseEntity.getUuid(), postDTO.getPurchasedExchange(),
                postDTO.getValue(),
                postDTO.getCoins(),
                postDTO.getFee(),
                purchaseEntity.getAveragePrice());
    }

    public SingleCryptoInWalletSummaryDTO from(CryptoParentEntity parentEntity) {
        return modelMapper.map(parentEntity, SingleCryptoInWalletSummaryDTO.class);
    }

    public List<SingleCryptoInWalletSummaryDTO> from(List<CryptoParentEntity> parentList) {
        return parentList.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public TotalCryptoPurchaseValueResponseDTO from(CryptoParentEntity parentEntity,
                                                    CryptoPurchasePostDTO postDTO) {
        TotalCryptoPurchaseValueResponseDTO response = new TotalCryptoPurchaseValueResponseDTO();
        response.setName(parentEntity.getName());
        response.setSymbol(parentEntity.getSymbol());
        response.setAveragePrice(parentEntity.getAveragePrice());
        response.setUuid(parentEntity.getUuid());
        response.setAddedPurchase(from(getRecentPurchaseEntity(parentEntity), postDTO));
        response.setTotalCoins(parentEntity.getTotalCoins());
        response.setTotalValue(parentEntity.getTotalValue());
        response.setTotalFees(parentEntity.getTotalFees());
        response.setWallet(parentEntity.getWallet());
        return response;
    }

    private CryptoPurchaseEntity getRecentPurchaseEntity(CryptoParentEntity parentEntity) {
        return parentEntity.getPurchases().get(parentEntity.getPurchases().size() -1);
    }
}
