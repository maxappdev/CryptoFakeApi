package com.crypto.fakeapi.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Data
public class TokenNameDTO {
    private static String tokensString = "[\n" +
            "  {\n" +
            "    \"name\" : \"Bitcoin\",\n" +
            "    \"code\" : \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Ethereum\",\n" +
            "    \"code\" : \"ETH\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Binance Coin\",\n" +
            "    \"code\" : \"BNB\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Tether\",\n" +
            "    \"code\" : \"USDT\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Cardano\",\n" +
            "    \"code\" : \"ADA\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Solana\",\n" +
            "    \"code\" : \"SOL\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"USD Coin\",\n" +
            "    \"code\" : \"USDC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Commemorative Token\",\n" +
            "    \"code\" : \"MCT\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Abele\",\n" +
            "    \"code\" : \"ABELE\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Aquachain\",\n" +
            "    \"code\" : \"AQUA\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\" : \"Dogecoin\",\n" +
            "    \"code\" : \"DOGE\"\n" +
            "  }\n" +
            "]";

    private String name;
    private String code;

    public static List<TokenNameDTO> findAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TokenNameDTO[] tokens = mapper.readValue(tokensString, TokenNameDTO[].class);
        return Arrays.asList(tokens);
    }

    public static TokenNameDTO findByCode(String code) throws IOException {
        TokenNameDTO result = null;

        List<TokenNameDTO> tokenNamesList = findAll();

        for (TokenNameDTO token : tokenNamesList) {
            if ((token != null) && (token.getCode().equalsIgnoreCase(code))) {
                result = token;
                break;
            }
        }

        return result;
    }
}
