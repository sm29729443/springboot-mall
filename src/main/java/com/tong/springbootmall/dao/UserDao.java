package com.tong.springbootmall.dao;

import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;

/**
 * ClassName: UserDao
 * Package: com.tong.springbootmall.dao
 */
public interface UserDao {
    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
