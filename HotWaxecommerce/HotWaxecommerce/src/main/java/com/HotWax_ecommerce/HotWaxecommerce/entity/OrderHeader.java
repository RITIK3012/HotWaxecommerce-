package com.HotWax_ecommerce.HotWaxecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

//@Entity
//@Data
//public class OrderHeader {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Integer orderId;
//
//        private LocalDate orderDate;
//
//        @ManyToOne
//        private Customer customer;
//
//        @ManyToOne
//        private ContactMech shippingContactMech;
//
//        @ManyToOne
//        private ContactMech billingContactMech;
//
//        @OneToMany(mappedBy = "orderHeader", cascade = CascadeType.ALL)
//        @JsonManagedReference
//        private List<OrderItem> items;
//
//
//}
@Entity
@Table(name = "order_header")
@Data
public class OrderHeader {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer orderId;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate orderDate;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        private Customer customer;

        @ManyToOne
        @JoinColumn(name = "shipping_contact_mech_id", nullable = false)
        private ContactMech shippingContactMech;

        @ManyToOne
        @JoinColumn(name = "billing_contact_mech_id", nullable = false)
        private ContactMech billingContactMech;

        @OneToMany(mappedBy = "orderHeader", cascade = CascadeType.ALL)
        @JsonManagedReference
        private List<OrderItem> items;
}


