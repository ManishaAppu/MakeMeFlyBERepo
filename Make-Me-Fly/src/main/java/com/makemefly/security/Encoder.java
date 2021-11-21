package com.makemefly.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoder {

    public static void main(String args[]){
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String passwordEncoded = encoder.encode("makemefly");

        System.out.println(passwordEncoded);
    }

}
