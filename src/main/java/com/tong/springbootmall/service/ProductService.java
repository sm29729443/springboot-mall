package com.tong.springbootmall.service;

import com.tong.springbootmall.constants.ProductCategory;
import com.tong.springbootmall.dto.ProductQueryParams;
import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;

import java.util.List;

/**
 * ClassName: ProductService
 * Package: com.tong.springbootmall.service
 */
public interface ProductService {
    public Product getProductById(Integer productId);

    public Integer createProduct(ProductRequest productRequest);

    public void updateProduct(Integer productId, ProductRequest productRequest);

    public void deleteProduct(Integer productId);

    public List<Product> getProducts(ProductQueryParams params);

    Integer countProducts(ProductQueryParams params);
}
