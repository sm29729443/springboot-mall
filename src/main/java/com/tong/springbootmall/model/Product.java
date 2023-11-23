package com.tong.springbootmall.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.springbootmall.constants.ProductCategory;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Product {

    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("category")
    private ProductCategory category;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("stock")
    private Integer stock;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_date")
    private Date createdDate;
    @JsonProperty("last_modified_date")
    private Date lastModifiedDate;


}
