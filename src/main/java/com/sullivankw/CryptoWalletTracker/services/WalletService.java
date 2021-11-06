package com.sullivankw.CryptoWalletTracker.services;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostResponseDTO;
import com.sullivankw.CryptoWalletTracker.repos.CryptoParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private CryptoParentRepo cryptoParentRepo;

    public CryptoPurchasePostResponseDTO purchase(CryptoPurchasePostDTO purchasePostDTO) {
        //todo get parent first?
        return null;
    }
}
