package com.tong.springbootmall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName: UserRegisterRequest
 * Package: com.tong.springbootmall.dto
 */
@Setter
@Getter
public class UserRegisterRequest {
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
}
