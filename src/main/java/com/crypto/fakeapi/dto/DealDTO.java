package com.crypto.fakeapi.dto;

import com.github.javafaker.Faker;
import lombok.Data;

import java.io.IOException;
import java.util.Random;

@Data
public class DealDTO {

    final static Random rand = new Random();
    final static Faker faker = new Faker();
    String from;
    String to;
    String description;

    private DealDTO(String from, String to, String description) {
        this.from = from;
        this.to = to;
        this.description = description;
    }

    public static DealDTO generateFakeDeal() throws IOException {
        String sender = faker.name().fullName();
        String receiver = faker.name().fullName();

        String currencyCode = TokenNameDTO.findAll().get((int) (Math.random() * TokenNameDTO.findAll().size())).getCode();
        Float sum = 1 + rand.nextFloat() * (15 - 1);
        String operationName = getRandomOperationName();
        String operation = operationName + " " + sum + " " + currencyCode;

        return new DealDTO(sender, receiver, operation);
    }

    private static String getRandomOperationName() {
        String[] operations = new String[]{"Sold", "Bought"};

        return operations[(int) (Math.random()*operations.length)];
    }

}
