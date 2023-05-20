package com.chanheng.stock1.api.Auth.web;

public record AuthDto(
        String email,
        String familyName,
        String givenName,
        String gender
) {
}
