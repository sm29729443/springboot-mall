package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.dao.ProductDao;
import com.tong.springbootmall.dao.impl.ProductDaoImpl;
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
}
