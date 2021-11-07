package com.sullivankw.CryptoWalletTracker.Controllers;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.TotalCryptoPurchaseValueResponseDTO;
import com.sullivankw.CryptoWalletTracker.services.WalletService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/purchase")
public class CryptoPurchaseController {

    @Autowired
    private WalletService walletService;


    @ApiOperation(value = "Add individual purchase from exchanges aqui")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TotalCryptoPurchaseValueResponseDTO addPurchase(@RequestBody CryptoPurchasePostDTO postDTO) {
        return walletService.purchase(postDTO);
    }

    @ApiOperation(value = "get purchases for a given parent uuid")
    @GetMapping(value = "{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public TotalCryptoPurchaseValueResponseDTO getPurchases(@PathVariable UUID uuid) {
        return null;
    }

    @GetMapping(value = "get ALL purchases")
    @ResponseStatus(HttpStatus.OK)
    public TotalCryptoPurchaseValueResponseDTO getAllPurchases() {
        return null;
    }
}
