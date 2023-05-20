package com.chanheng.stock1.api.user.web;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record SavedUserDto(
        @NotBlank
        String username,
        String familyName,
        String givenName,
        String gender,
        Integer phone,
        LocalDate dob,
        String biography,
        Boolean status) {
}
