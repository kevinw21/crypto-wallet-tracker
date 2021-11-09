package com.sullivankw.CryptoWalletTracker.Controllers;

import com.sullivankw.CryptoWalletTracker.dtos.coinbase.CoinbaseOrderDTO;
import com.sullivankw.CryptoWalletTracker.services.CsvImportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/import")
public class CoinbaseOrderImportController {

    @Autowired
    private CsvImportService importService;

    @ApiOperation(value = "todo make a post with multifile import") //todo make a post with multifile import
    @GetMapping //todo also note only the fills statement looks useful, bla on the accounts
    //todo also i dont see a file for transfers...
    @ResponseStatus(HttpStatus.OK)
    public List<CoinbaseOrderDTO> importStuff() throws IOException { //note cb reports seem to only give up to previous completed month
        return importService.getPurchases();
    }
}
