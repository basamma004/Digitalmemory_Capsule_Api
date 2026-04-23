package com.example.digitalmemorycapsuleAPI.util;

import java.time.LocalDateTime;

public class DateUtil {

    public static boolean isUnlocked(LocalDateTime time) {
        return LocalDateTime.now().isAfter(time);
    }
}
