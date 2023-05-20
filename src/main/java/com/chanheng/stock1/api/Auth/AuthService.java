package com.chanheng.stock1.api.Auth;

import com.chanheng.stock1.api.Auth.web.AuthDto;
import com.chanheng.stock1.api.Auth.web.RegisterDto;

public interface AuthService {
    AuthDto register(RegisterDto registerDto);
}
