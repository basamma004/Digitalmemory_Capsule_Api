package com.example.digitalmemorycapsuleAPI.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean matches(String raw, String encoded) {
        return BCrypt.checkpw(raw, encoded);
    }
}
