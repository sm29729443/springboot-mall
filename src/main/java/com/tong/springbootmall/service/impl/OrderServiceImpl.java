package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.dao.OrderDao;
import com.tong.springbootmall.dao.ProductDao;
import com.tong.springbootmall.dto.BuyItem;
import com.tong.springbootmall.dto.CreatedOrderList;
import com.tong.springbootmall.model.OrderItem;
import com.tong.springbootmall.model.Product;
import com.tong.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrderServiceImpl
 * Package: com.tong.springbootmall.service.impl
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    //為了避免出現在 order table 新增數據，卻在 order_item 沒新增數據的情況，要加上_Transactional
    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreatedOrderList createdOrderList) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();

        for(BuyItem buyItem: createdOrderList.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(buyItem.getQuantity());
            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);
        return  orderId;
    }
}
