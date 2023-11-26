package com.tong.springbootmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //當加上此 annotation 後，Spring boot 在執行 Object -> JSON 時就不會去轉換這個 FIELD
    @JsonIgnore
    private String password;
    private Date createdDate;
    private Date lastModifiedDate;
}
