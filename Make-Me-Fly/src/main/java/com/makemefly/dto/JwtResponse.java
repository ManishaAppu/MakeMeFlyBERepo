package com.makemefly.dto;

public class JwtResponse {

    private final String jwttoken;
    private final String role;

    public JwtResponse(String jwttoken, String role) {
        this.jwttoken = jwttoken;
        this.role = role;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getRole() {
        return role;
    }
}