package com.crypto.fakeapi.controllers;

import com.crypto.fakeapi.dto.DealDTO;
import com.crypto.fakeapi.dto.TokenNameDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DealsController {

    @GetMapping("deals")
    public List<DealDTO> getAllDeals() throws IOException {
        List<DealDTO> result = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            result.add(DealDTO.generateFakeDeal());
        }

        return result;
    }
}
