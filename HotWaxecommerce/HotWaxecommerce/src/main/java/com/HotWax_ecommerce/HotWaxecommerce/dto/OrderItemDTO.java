package com.HotWax_ecommerce.HotWaxecommerce.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

        private Integer productId;
        private Integer quantity;
        private String status;


}
