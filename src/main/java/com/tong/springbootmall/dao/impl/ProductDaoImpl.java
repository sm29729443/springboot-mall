package com.tong.springbootmall.dao.impl;

import com.tong.springbootmall.dao.ProductDao;
import com.tong.springbootmall.dto.ProductRequest;
import com.tong.springbootmall.model.Product;
import com.tong.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.crypto.KeyGenerator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date FROM product WHERE product_id = :productId;";
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("productId", productId);
        List<Product> productList = jdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product (product_name, category, image_url, price, stock," +
                " description, created_date, last_modified_date)\n" +
                "VALUES (:productName, :category, :imageUrl, :price, :stock," +
                " :description, :createdDate, :lastModifiedDate);";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productName", productRequest.getProductName());
        // 這邊記得一定要把 enum 轉成 String
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        // 時間由Spring boot 程式產生，而非由前端資訊所決定
        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        //使用 auto increment id 時的設定
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product\n" +
                "SET product_name = :productName, category = :category," +
                " image_url = :imageUrl, price = :price, stock = :stock," +
                " description = :description, last_modified_date = :lastModifiedDate\n" +
                "WHERE product_id = :productId;";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productId", productId);
        map.put("productName", productRequest.getProductName());
        //一樣記得 enum 轉 string
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());
        jdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProduct(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId;";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        jdbcTemplate.update(sql, map);
    }
}
