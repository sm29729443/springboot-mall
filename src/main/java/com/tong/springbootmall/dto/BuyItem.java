package com.tong.springbootmall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Setter
@Getter
public class BuyItem {
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;
}
