package com.sullivankw.CryptoWalletTracker.Controllers;

import com.sullivankw.CryptoWalletTracker.dtos.CryptoPurchasePostDTO;
import com.sullivankw.CryptoWalletTracker.dtos.SingleCryptoInWalletSummaryDTO;
import com.sullivankw.CryptoWalletTracker.dtos.TotalCryptoPurchaseValueResponseDTO;
import com.sullivankw.CryptoWalletTracker.models.Wallet;
import com.sullivankw.CryptoWalletTracker.services.WalletService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "get purchases for a given symbol and wallet")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SingleCryptoInWalletSummaryDTO getCurrentHoldings(@RequestParam String symbol, @RequestParam Wallet wallet) {
        return walletService.getBySymbolAndWallet(symbol.toUpperCase(), wallet);
    }

    @GetMapping(value = "get ALL current holdings")
    @ResponseStatus(HttpStatus.OK)
    public List<SingleCryptoInWalletSummaryDTO> getAllHoldings() {
        return walletService.getAllHoldings();
    }
}
