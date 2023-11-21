package com.tong.springbootmall.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.springbootmall.constants.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ProductRequest {
    @NotNull
    @JsonProperty("product_name")
    private String productName;

    @NotNull
    @JsonProperty("category")
    private ProductCategory category;

    @NotNull
    @JsonProperty("image_url")
    private String imageUrl;

    @NotNull
    @JsonProperty("price")
    private Integer price;

    @NotNull
    @JsonProperty("stock")
    private Integer stock;

    @JsonProperty("description")
    private String description;


}
