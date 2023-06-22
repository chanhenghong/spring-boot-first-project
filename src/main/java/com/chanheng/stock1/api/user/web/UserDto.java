package com.chanheng.stock1.api.user.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDto(
         String uuid,
         String username,
         String email,
         String familyName,
         String givenName,
         LocalDate dob,
         String gender,
         String profile,
         String biography,
         LocalDateTime createdAt,
         Boolean status) {
}
