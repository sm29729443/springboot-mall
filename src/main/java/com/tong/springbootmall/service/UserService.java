package com.tong.springbootmall.service;

import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Package: com.tong.springbootmall.service
 */

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
