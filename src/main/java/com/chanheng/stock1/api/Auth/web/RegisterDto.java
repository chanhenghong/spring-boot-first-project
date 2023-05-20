package com.chanheng.stock1.api.Auth.web;


public record RegisterDto(
        String email,
        String familyName,
        String givenName,
        String gender,
        String password,
        String confirmedPassword
) {
}
