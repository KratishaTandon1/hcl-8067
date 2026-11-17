package com.hcld2.jwtdemo.dto;

public record AuthRequest(
    String username,
    String password
) {}