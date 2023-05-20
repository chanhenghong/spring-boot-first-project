package com.chanheng.stock1.api.Auth.web;

import com.chanheng.stock1.api.Auth.AuthServiceImpl;
import com.chanheng.stock1.api.base.Rest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthServiceImpl authService;
    @PostMapping("register")
    Rest<?> register(@RequestBody RegisterDto registerDto){

        log.info("Register DTO = {}", registerDto);

        var authDto = authService.register(registerDto);

        var rest = Rest.builder()
                .status(true)
                .message("You have retrieved user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(authDto)
                .build();
        return rest;
    }
}
