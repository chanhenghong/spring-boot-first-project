package com.chanheng.stock1.api.user;

import com.chanheng.stock1.api.user.web.SavedUserDto;
import com.chanheng.stock1.api.user.web.UpdateUserDto;
import com.chanheng.stock1.api.user.web.UserDto;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final UserMap userMap;
    @Override
    public UserDto saveUser(SavedUserDto savedUserDto) {
        User user = userMap.fromSavedUserDto(savedUserDto);
        user.setUuid(UUID.randomUUID().toString());
        log.info("Uer = {}", user);

        userMapper.insert(user);

        log.info("User = {}", user);

        Optional<User> userOptional = userMapper.selectById(user.getId());
        User latestUser = userOptional.orElseThrow(()->
                new RuntimeException("User is not found"));

        return userMap.toUserDto(latestUser);
    }

    @Override
    public PageInfo<UserDto> findUsers(int pageSize, int pageNum) {
        PageInfo<User> userPageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> userMapper.select(true));

        return userMap.toUserDtoPageInfo(userPageInfo);
    }

    @Override
    public UserDto findUserByUuid(String uuid) {
        return null;
    }

    @Override
    public void deleteByUuid(String uuid) {

    }

    @Override
    public UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto) {
        return null;
    }
}
