package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.dao.UserDao;
import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;
import com.tong.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.tong.springbootmall.service.impl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}


