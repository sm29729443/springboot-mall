package com.tong.springbootmall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
public class CreatedOrderList {
    @NotEmpty
    private List<BuyItem> buyItemList;
}
