package com.chanheng.stock1.api.Auth;

import com.chanheng.stock1.api.Auth.web.AuthDto;
import com.chanheng.stock1.api.Auth.web.RegisterDto;
import com.chanheng.stock1.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthMapper authMapper;
    @Override
    public AuthDto register(RegisterDto registerDto) {

//        START:  Set and Intert to database
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setEmail(registerDto.email());
        user.setFamilyName(registerDto.familyName());
        user.setGivenName(registerDto.givenName());
        user.setGender(registerDto.gender());
        user.setPassword(registerDto.password());
        authMapper.register(user);
//        END:  Set and Intert to database


//        START: Get for Return to controller for respone to client
        AuthDto authDto = new AuthDto(
                user.getEmail(),
                user.getFamilyName(),
                user.getGivenName(),
                user.getGender()
        );
        return authDto;
//        END: Get for Return to controller for respone to client
    }
}
