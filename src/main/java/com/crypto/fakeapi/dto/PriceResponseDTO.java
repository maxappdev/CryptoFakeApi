package com.crypto.fakeapi.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Random;

@Data
public class PriceResponseDTO {
    private String name;
    private String code;
    private float price;
    private Currency currency;

    private enum Currency{
        USD;
    }

    @Nullable
    public static PriceResponseDTO generateRandomPrice(String code) throws IOException {
        PriceResponseDTO result = null;
        TokenNameDTO foundDTO = TokenNameDTO.findByCode(code);
        if(foundDTO != null){
            result = new PriceResponseDTO();
            result.setName(foundDTO.getName());
            result.setCode(foundDTO.getCode());
            result.setCurrency(Currency.USD);
        }

        return result;
    }

    private static float fakePriceChange(float price) {
        Random randToAdd = new Random();
        int low = 1;
        int high = 10;
        int intToAdd = randToAdd.nextInt(high-low) + low;

        return price + intToAdd;
    }
}
