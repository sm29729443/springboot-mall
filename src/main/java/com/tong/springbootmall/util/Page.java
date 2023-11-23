package com.tong.springbootmall.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page<T> {
    private Integer limit;
    private Integer offset;

    // 商品總數
    private Integer total;
    private List<T> results;
}
