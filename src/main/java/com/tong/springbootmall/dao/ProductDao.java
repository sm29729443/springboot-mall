package com.tong.springbootmall.dao;
import com.tong.springbootmall.model.Product;

public interface ProductDao {
    public Product getProductById(Integer productId);
}
