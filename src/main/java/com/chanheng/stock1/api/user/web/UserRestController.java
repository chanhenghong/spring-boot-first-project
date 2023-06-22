package com.chanheng.stock1.api.user.web;

import com.chanheng.stock1.api.base.Rest;
import com.chanheng.stock1.api.user.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;
    @PostMapping
    Rest<?> saveUser(@Valid @RequestBody SavedUserDto savedUserDto){

        var userDto = userService.saveUser(savedUserDto);

//        START: Return base data to client via "Our base rest class"
        var rest = Rest.builder()
                .status(true)
                .message("You have created user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDto)
                .build();
//        END:

        return rest;
    }
    @GetMapping
    Rest<?> findUsers(@RequestParam(required = false, defaultValue = "20") int pageSize,
                      @RequestParam(required = false, defaultValue = "1") int pageNum){
        PageInfo<UserDto> userDtoPageInfo = userService.findUsers(pageSize, pageNum);

        return Rest.builder()
                .status(true)
                .message("You have retrieved user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDtoPageInfo)
                .build();
    }
}
