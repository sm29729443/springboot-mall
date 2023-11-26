package com.tong.springbootmall.service;

import com.tong.springbootmall.dto.CreatedOrderList;

/**
 * ClassName: OrderService
 * Package: com.tong.springbootmall.service
 */
public interface OrderService {
    Integer createOrder(Integer userId, CreatedOrderList createdOrderList);
}
