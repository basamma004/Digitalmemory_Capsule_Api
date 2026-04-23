package com.example.digitalmemorycapsuleAPI.util;

import java.util.UUID;

public class CommonUtil {

    public static String generateCode() {
        return UUID.randomUUID().toString();
    }
}