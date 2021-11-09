package com.sullivankw.CryptoWalletTracker.services;

import com.sullivankw.CryptoWalletTracker.Assemblers.CoinbaseOrderAssembler;
import com.sullivankw.CryptoWalletTracker.dtos.coinbase.CoinbaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CsvImportService {

    @Autowired
    private CoinbaseOrderAssembler assembler;

    private static final String CSV_FILE_SEPARATOR = ",";

    public List<CoinbaseOrderDTO> getPurchases() throws IOException { //todo will also need to store and convert to reposne

        String line;

        boolean readFile = true;

        int counter = 0;

        List<CoinbaseOrderDTO> orders = new ArrayList();

        ClassPathResource classPathResource = new ClassPathResource("fills.csv");

        byte[] binaryData = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());

        InputStream inputStream = new ByteArrayInputStream(binaryData);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        while (readFile) {

            line = reader.readLine();

            if (isNull(line) || line.equals("")) {
                readFile = false;
            } else {
                if (counter > 0) {
                    String[] row = line.split(CSV_FILE_SEPARATOR);
                    CoinbaseOrderDTO order = assembler.from(row); //sells currently mixed in
                    orders.add(order);
                }
                counter++;
            }
        }

        reader.close();

        orders.sort(Comparator.comparing(CoinbaseOrderDTO::getExecuted));

        return orders;
    }
}
