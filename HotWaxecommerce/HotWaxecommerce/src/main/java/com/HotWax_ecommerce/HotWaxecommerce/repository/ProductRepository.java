package com.HotWax_ecommerce.HotWaxecommerce.repository;

import com.HotWax_ecommerce.HotWaxecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}