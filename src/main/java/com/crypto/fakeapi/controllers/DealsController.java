package com.crypto.fakeapi.controllers;

import com.crypto.fakeapi.dto.DealDTO;
import com.crypto.fakeapi.dto.TokenNameDTO;
import com.crypto.fakeapi.util.FakeDealsDb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DealsController {

    @GetMapping("deals")
    public List<DealDTO> getAllDeals() throws IOException {
        return FakeDealsDb.triggerSelect();
    }
}
