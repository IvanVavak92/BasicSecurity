package com.ivan.basicsecurityproject.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

    public static String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "12345";
        String encodedPassword = encodePassword(password);
        System.out.println("Encoded password: " + encodedPassword);
    }
}

