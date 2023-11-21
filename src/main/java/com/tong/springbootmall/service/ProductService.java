package com.tong.springbootmall.service;

import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;

/**
 * ClassName: ProductService
 * Package: com.tong.springbootmall.service
 */
public interface ProductService {
    public Product getProductById(Integer productId);

    public Integer createProduct(ProductRequest productRequest);

    public void updateProduct(Integer productId, ProductRequest productRequest);
}
