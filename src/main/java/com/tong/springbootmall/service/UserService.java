package com.tong.springbootmall.service;

import com.tong.springbootmall.dto.UserLoginRequest;
import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;

/**
 * ClassName: UserService
 * Package: com.tong.springbootmall.service
 */

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequset);
}
