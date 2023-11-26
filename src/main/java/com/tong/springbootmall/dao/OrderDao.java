package com.tong.springbootmall.dao;

import com.tong.springbootmall.model.OrderItem;

import java.util.List;

/**
 * ClassName: OrderDao
 * Package: com.tong.springbootmall.dao
 */
public interface OrderDao {
    Integer createOrder(Integer userId, int totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
