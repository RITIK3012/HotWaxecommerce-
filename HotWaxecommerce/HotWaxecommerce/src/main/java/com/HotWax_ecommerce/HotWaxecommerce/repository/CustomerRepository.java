package com.HotWax_ecommerce.HotWaxecommerce.repository;

import com.HotWax_ecommerce.HotWaxecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {}