package com.tong.springbootmall.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItem {
    private Integer orderItemId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Integer amount;
}
