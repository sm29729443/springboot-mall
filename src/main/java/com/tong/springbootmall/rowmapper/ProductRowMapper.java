package com.tong.springbootmall.rowmapper;

import com.tong.springbootmall.constants.ProductCategory;
import com.tong.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        // 將 String 轉換成 enum，實際工作中很常見
        // 當 資料庫 get 到的 String 是一個 ProductCategory 沒有定義好的 enum 時
        // 會發生 String 轉 enum 的 Exception，這種 Exception 在開發中是好的，可以更快釐清錯誤的原因
        // 而不是返回一個沒意義的值給前端
        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));

        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        return product;
    }
}
