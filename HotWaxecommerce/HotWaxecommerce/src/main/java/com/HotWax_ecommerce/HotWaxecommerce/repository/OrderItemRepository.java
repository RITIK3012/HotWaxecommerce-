package com.HotWax_ecommerce.HotWaxecommerce.repository;

import com.HotWax_ecommerce.HotWaxecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {}
