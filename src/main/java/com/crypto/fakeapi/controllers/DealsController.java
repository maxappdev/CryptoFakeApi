package com.crypto.fakeapi.controllers;

import com.crypto.fakeapi.dto.TokenNameDTO;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

public class DealsController {

    @GetMapping("deals")
    public List<TokenNameDTO> getAllCurrencies() throws IOException {
        return TokenNameDTO.findAll();
    }
}
