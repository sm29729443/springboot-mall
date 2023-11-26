package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.dao.UserDao;
import com.tong.springbootmall.dto.UserLoginRequest;
import com.tong.springbootmall.dto.UserRegisterRequest;
import com.tong.springbootmall.model.User;
import com.tong.springbootmall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
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
        // 使用 MD5 hash 生成密碼的 hash value
        // 在理論上是有可能發生不同 String 經過 hash 算法產生的 hash value 是一樣的，也就是碰撞，但教學說機率超級低，不用考慮
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);
        // 註冊帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        // 檢查 user 是否存在
        if (user == null) {
            log.warn("該 email {} 並未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 使用 MD5 hash 生成密碼的 hash value
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
        // 比較密碼
        if (user.getPassword().equals(hashedPassword)) {
            return user;
        } else {
            log.warn("email {} 的 密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}


