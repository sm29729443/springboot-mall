package com.tong.springbootmall.service.impl;

import com.tong.springbootmall.constants.ProductCategory;
import com.tong.springbootmall.dao.ProductDao;
import com.tong.springbootmall.dao.impl.ProductDaoImpl;
import com.tong.springbootmall.dto.ProductQueryParams;
import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;
import com.tong.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams params) {
        return productDao.getProducts(params);
    }
}
