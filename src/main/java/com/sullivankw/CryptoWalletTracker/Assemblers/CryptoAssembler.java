package com.sullivankw.CryptoWalletTracker.Assemblers;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.models.CryptoParentEntity;
import org.springframework.stereotype.Component;

@Component
public class CryptoAssembler {

    public CryptoParentEntity from(CryptoPurchasePostDTO postDTO) {
        return null;
    }

//    public MarketChartParentEntity from(MarketChartResponseWrapperDTO wrapperDTO) {
//        MarketChartParentEntity parentEntity = new MarketChartParentEntity();
//        parentEntity.setCoinGeckoId(wrapperDTO.getCoinGeckoId());
//        parentEntity.setChildren(wrapperDTO.getMarketData().stream()
//                .map(this::toMarketChartChildEntity)
//                .collect(Collectors.toList()));
//        return parentEntity;
//    }

}
