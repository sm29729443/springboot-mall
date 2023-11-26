package com.tong.springbootmall.controller;

import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;
import com.tong.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ClassName: UserController
 * Package: com.tong.springbootmall.controller
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //使用 Post 的原因: 1. 註冊帳號就是在資料表中新增一筆新的數據，此行為對應到 RESTful 的 Post
    //                2. 資安層面上，註冊帳號這種行為要用Response Body 才安全，故不可能用 GET
    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        Integer userId = userService.register(userRegisterRequest);
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
