package com.sullivankw.CryptoWalletTracker.Controllers;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostResponseDTO;
import com.sullivankw.CryptoWalletTracker.services.WalletService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/currentMarket")
public class CryptoPurchaseController {

    @Autowired
    private WalletService walletService;


    @ApiOperation(value = "Use this to get all latest market info for the top 400 in coin gecko. Optionally, the data can be persisted through param saveData")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CryptoPurchasePostResponseDTO getCurrentCoinMarketData(@RequestBody CryptoPurchasePostDTO postDTO) {
        return walletService.purchase(postDTO);
    }
}
