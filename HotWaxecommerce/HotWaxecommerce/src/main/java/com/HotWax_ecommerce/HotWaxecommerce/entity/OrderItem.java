package com.HotWax_ecommerce.HotWaxecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer orderItemSeqId;

        @ManyToOne
        @JoinColumn(name = "order_id")
        @JsonBackReference
        private OrderHeader orderHeader;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;

        private Integer quantity;
        private String status;


}
