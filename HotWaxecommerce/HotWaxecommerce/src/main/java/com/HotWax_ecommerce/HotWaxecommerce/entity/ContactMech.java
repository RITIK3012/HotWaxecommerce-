package com.HotWax_ecommerce.HotWaxecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ContactMech {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer contactMechId;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        private Customer customer;

        private String streetAddress;
        private String city;
        private String state;
        private String postalCode;
        private String phoneNumber;
        private String email;


}
