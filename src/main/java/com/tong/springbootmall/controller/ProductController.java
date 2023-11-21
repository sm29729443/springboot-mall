package com.tong.springbootmall.controller;
import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;
import com.tong.springbootmall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName: ProductController
 * Package: com.tong.springbootmall.controller
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    //查詢商品
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if(product != null){
        return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //新增商品
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    //修改商品
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {
        // 檢查商品是否存在
        Product product = productService.getProductById(productId);
        if ( product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改商品
        productService.updateProduct(productId, productRequest);
        Product updateProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    //刪除商品
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        // 影片是說前端只在意商品最後是否存在，所以不管是一開始就不存在，還是被刪除後不存在意義都一樣
        // 因此不用先檢查此商品事先是否存在
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
