package com.tong.springbootmall.dto;

import com.tong.springbootmall.constants.ProductCategory;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: ProductQueryParams
 * Package: com.tong.springbootmall.dto
 */
@Getter
@Setter
public class ProductQueryParams {
    private ProductCategory productCategory;
    private String search;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;
}
