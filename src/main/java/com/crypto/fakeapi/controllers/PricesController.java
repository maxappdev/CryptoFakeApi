package com.crypto.fakeapi.controllers;

import com.crypto.fakeapi.dto.PriceResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PricesController {

    @GetMapping("/price")
    public PriceResponseDTO getPrice(@RequestParam String code) throws IOException {
        return PriceResponseDTO.generateRandomPrice(code);
    }
}
