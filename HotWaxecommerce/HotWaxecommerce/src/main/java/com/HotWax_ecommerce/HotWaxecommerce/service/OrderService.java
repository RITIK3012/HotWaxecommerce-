package com.HotWax_ecommerce.HotWaxecommerce.service;

import com.HotWax_ecommerce.HotWaxecommerce.dto.OrderItemDTO;
import com.HotWax_ecommerce.HotWaxecommerce.dto.OrderRequestDTO;
import com.HotWax_ecommerce.HotWaxecommerce.entity.OrderHeader;
import com.HotWax_ecommerce.HotWaxecommerce.entity.OrderItem;
import com.HotWax_ecommerce.HotWaxecommerce.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

        private final OrderHeaderRepository orderRepo;
        private final CustomerRepository customerRepo;
        private final ContactMechRepository contactRepo;
        private final ProductRepository productRepo;
        private final OrderItemRepository itemRepo;

        public OrderHeader createOrder(OrderRequestDTO dto) {
            OrderHeader order = new OrderHeader();
            order.setOrderDate(dto.getOrderDate());
            order.setCustomer(customerRepo.findById(dto.getCustomerId()).orElseThrow());
            order.setShippingContactMech(contactRepo.findById(dto.getShippingContactMechId()).orElseThrow());
            order.setBillingContactMech(contactRepo.findById(dto.getBillingContactMechId()).orElseThrow());

            List<OrderItem> items = dto.getItems().stream().map(i -> {
                OrderItem item = new OrderItem();
                item.setOrderHeader(order);
                item.setProduct(productRepo.findById(i.getProductId()).orElseThrow());
                item.setQuantity(i.getQuantity());
                item.setStatus(i.getStatus());
                return item;
            }).toList();

            order.setItems(items);
            return orderRepo.save(order);
        }

        public OrderHeader getOrder(Integer id) {
            return orderRepo.findById(id).orElseThrow();
        }

        public void deleteOrder(Integer id) {
            orderRepo.deleteById(id);
        }

    // Update Order
        public OrderHeader updateOrder(Integer orderId, OrderRequestDTO dto) {
            OrderHeader order = getOrder(orderId);

            if (dto.getShippingContactMechId() != null) {
                order.setShippingContactMech(
                        contactRepo.findById(dto.getShippingContactMechId()).orElseThrow()
                );
            }

            if (dto.getBillingContactMechId() != null) {
                order.setBillingContactMech(
                        contactRepo.findById(dto.getBillingContactMechId()).orElseThrow()
                );
            }

            return orderRepo.save(order);
        }

        public OrderItem addOrderItem(Integer orderId, OrderItemDTO dto) {
            OrderHeader order = getOrder(orderId);

            OrderItem item = new OrderItem();
            item.setOrderHeader(order);
            item.setProduct(productRepo.findById(dto.getProductId()).orElseThrow());
            item.setQuantity(dto.getQuantity());
            item.setStatus(dto.getStatus());

            return itemRepo.save(item);
        }

        public OrderItem updateOrderItem(Integer orderId, Integer itemId, OrderItemDTO dto) {
            OrderItem item = itemRepo.findById(itemId).orElseThrow();

            if (!item.getOrderHeader().getOrderId().equals(orderId)) {
                throw new RuntimeException("Order item does not belong to this order");
            }

            item.setQuantity(dto.getQuantity());
            item.setStatus(dto.getStatus());

            return itemRepo.save(item);
        }

        public void deleteOrderItem(Integer orderId, Integer itemId) {
            OrderItem item = itemRepo.findById(itemId).orElseThrow();

            if (!item.getOrderHeader().getOrderId().equals(orderId)) {
                throw new RuntimeException("Order item does not belong to this order");
            }

            itemRepo.delete(item);
        }
}

