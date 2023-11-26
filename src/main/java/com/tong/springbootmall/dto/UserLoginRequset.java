package com.tong.springbootmall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * ClassName: UserLoginRequset
 * Package: com.tong.springbootmall.dto
 */
@Setter
@Getter
public class UserLoginRequset {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}
