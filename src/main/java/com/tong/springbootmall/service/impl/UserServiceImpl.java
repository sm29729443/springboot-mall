package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.dao.UserDao;
import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;
import com.tong.springbootmall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * ClassName: UserServiceImpl
 * Package: com.tong.springbootmall.service.impl
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊的 email 是否已被註冊過
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user != null) {
            log.warn("該 email {} 已被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 註冊帳號
        return userDao.createUser(userRegisterRequest);
    }
}


