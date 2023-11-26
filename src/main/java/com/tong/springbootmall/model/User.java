package com.tong.springbootmall.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * ClassName: User
 * Package: com.tong.springbootmall.model
 */
@Setter
@Getter
public class User {
    private Integer userId;
    private String email;
    private String password;
    private Date createdDate;
    private Date lastModifiedDate;
}
