package com.chanheng.stock1.api.user.web;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record SavedUserDto(
        @NotBlank(message = "You have to fill username..!")
        String username,
        @NotBlank(message = "You have to fill family name..!")
        String familyName,
        @NotBlank(message = "You have to fill given name..!")
        String givenName,
        String gender,
        Integer phone,
        LocalDate dob,
        String biography,
        Boolean status) {
}
