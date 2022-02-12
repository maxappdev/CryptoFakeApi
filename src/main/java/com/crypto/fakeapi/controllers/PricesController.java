package com.crypto.fakeapi.controllers;

import com.crypto.fakeapi.dto.TokenNameDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class PricesController {

    private final Random r = new Random();

    @GetMapping("currencies")
    public List<TokenNameDTO>  getAllCurrencies() throws IOException {
        return TokenNameDTO.findAll();
    }

    @GetMapping("prices")
    public Float getPrice(@RequestParam String code) throws IOException {
        return 50 + r.nextFloat() * (55 - 50);
    }
}
