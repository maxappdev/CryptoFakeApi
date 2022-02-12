package com.crypto.fakeapi.controllers;

import com.crypto.fakeapi.dto.PriceResponseDTO;
import com.crypto.fakeapi.dto.TokenNameDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class PricesController {

    @GetMapping("currencies")
    public List<TokenNameDTO>  getAllCurrencies() throws IOException {
        return TokenNameDTO.findAll();
    }

    @GetMapping("prices")
    public PriceResponseDTO getPrice(@RequestParam String code) throws IOException {
        return PriceResponseDTO.generateRandomPrice(code);
    }
}
