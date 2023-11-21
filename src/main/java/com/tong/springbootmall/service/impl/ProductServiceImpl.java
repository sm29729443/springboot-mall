package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.dao.ProductDao;
import com.tong.springbootmall.dao.impl.ProductDaoImpl;
import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;
import com.tong.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: ProductServiceImpl
 * Package: com.tong.springbootmall.service.impl
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }
}
