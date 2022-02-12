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
    private String name;
    private String code;

    public static List<TokenNameDTO> findAll() throws IOException {
        Path tokensJson = ResourceUtils.getFile("classpath:token_names.json").toPath();
        ObjectMapper mapper = new ObjectMapper();
        TokenNameDTO[] tokens = mapper.readValue(tokensJson.toFile(), TokenNameDTO[].class);
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
