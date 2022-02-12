package com.crypto.fakeapi.util;

import com.crypto.fakeapi.dto.DealDTO;

import java.io.IOException;
import java.util.*;

public class FakeDealsDb {
    private static List<DealDTO> db = new ArrayList<>();

    public static List<DealDTO> triggerSelect() throws IOException {
        db.add(DealDTO.generateFakeDeal());

        return db;
    }
}
