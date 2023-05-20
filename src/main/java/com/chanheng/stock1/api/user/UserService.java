package com.chanheng.stock1.api.user;

import com.chanheng.stock1.api.user.web.SavedUserDto;
import com.chanheng.stock1.api.user.web.UpdateUserDto;
import com.chanheng.stock1.api.user.web.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(SavedUserDto savedUserDto);

    List<UserDto> findUsers();

    UserDto findUserByUuid(String uuid);

    void deleteByUuid(String uuid);

    UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto);
}
