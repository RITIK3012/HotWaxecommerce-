package com.HotWax_ecommerce.HotWaxecommerce.controller;

import com.HotWax_ecommerce.HotWaxecommerce.dto.OrderItemDTO;
import com.HotWax_ecommerce.HotWaxecommerce.dto.OrderRequestDTO;
import com.HotWax_ecommerce.HotWaxecommerce.entity.OrderHeader;
import com.HotWax_ecommerce.HotWaxecommerce.entity.OrderItem;
import com.HotWax_ecommerce.HotWaxecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {


        private final OrderService orderService;

        @PostMapping("")
        public ResponseEntity<OrderHeader> createOrder(@RequestBody OrderRequestDTO dto) {
            return new ResponseEntity<>(orderService.createOrder(dto), HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public OrderHeader getOrder(@PathVariable Integer id) {
            return orderService.getOrder(id);
        }

       @PutMapping("/{orderId}")
       public ResponseEntity<OrderHeader> updateOrder(
            @PathVariable Integer orderId,
            @RequestBody OrderRequestDTO dto) {

        return ResponseEntity.ok(orderService.updateOrder(orderId, dto));
       }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
            orderService.deleteOrder(id);
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
        }

       @PostMapping("/{orderId}/items")
       public ResponseEntity<OrderItem> addOrderItem(
            @PathVariable Integer orderId,
            @RequestBody OrderItemDTO dto) {

        return new ResponseEntity<>(
                orderService.addOrderItem(orderId, dto),
                HttpStatus.CREATED
        );
       }

       @PutMapping("/{orderId}/items/{itemId}")
       public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable Integer orderId,
            @PathVariable Integer itemId,
            @RequestBody OrderItemDTO dto) {

        return ResponseEntity.ok(
                orderService.updateOrderItem(orderId, itemId, dto)
        );
       }

    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<String> deleteOrderItem(
            @PathVariable Integer orderId,
            @PathVariable Integer itemId) {

        orderService.deleteOrderItem(orderId, itemId);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

    }


