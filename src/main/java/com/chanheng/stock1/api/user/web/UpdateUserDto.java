package com.chanheng.stock1.api.user.web;

import java.time.LocalDate;

public record UpdateUserDto(
        String familyName,
        String givenName,
        LocalDate dob,
        String gender,
        String biography
) {
}
