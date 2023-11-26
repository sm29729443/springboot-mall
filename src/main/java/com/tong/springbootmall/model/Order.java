package com.tong.springbootmall.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer totalAmount;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
}
