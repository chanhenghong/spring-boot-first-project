package com.chanheng.stock1.api.user;

import com.chanheng.stock1.api.user.web.SavedUserDto;
import com.chanheng.stock1.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMap {
    User fromSavedUserDto(SavedUserDto savedUserDto);

    UserDto toUserDto(User user);

    PageInfo<UserDto> toUserDtoPageInfo(PageInfo<User> userPageInfo);
}
