package com.crypto.fakeapi.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class TokenNameDTO {
    private String name;
    private String code;
    private float price;

    public static TokenNameDTO findByCode(String code) throws IOException {
        TokenNameDTO result = null;

        Path tokensJson = ResourceUtils.getFile("fakedata/token_names.json").toPath(); //TODO this string does not work
        ObjectMapper mapper = new ObjectMapper();
        TokenNameDTO[] tokens = mapper.readValue(tokensJson.toFile(), TokenNameDTO[].class);
        List<TokenNameDTO> tokenNamesList = Arrays.asList(tokens);

        for (TokenNameDTO token : tokenNamesList) {
            if ((token != null) && (token.getCode().equalsIgnoreCase(code))) {
                result = token;
                break;
            }
        }

        return result;
    }
}
