package com.HotWax_ecommerce.HotWaxecommerce.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequestDTO {

        private LocalDate orderDate;
        private Integer customerId;
        private Integer shippingContactMechId;
        private Integer billingContactMechId;
        private List<OrderItemDTO> items;


}
