package com.tong.springbootmall.dao;
import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;

public interface ProductDao {
    public Product getProductById(Integer productId);

    public Integer createProduct(ProductRequest productRequest);
    public void updateProduct(Integer productId, ProductRequest productRequest);

    public void deleteProduct(Integer productId);
}
