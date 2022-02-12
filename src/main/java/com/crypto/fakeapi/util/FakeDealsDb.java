package com.crypto.fakeapi.util;

import com.crypto.fakeapi.dto.DealDTO;

import java.io.IOException;
import java.util.*;

public class FakeDealsDb {
    private static Map<Integer, DealDTO> db = new HashMap<>();

    public static Map<Integer, DealDTO> triggerSelect() throws IOException {
        db.put(db.size() + 1, DealDTO.generateFakeDeal());

        return db;
    }
}
