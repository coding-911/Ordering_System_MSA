package com.spring_cloud.eureka.client.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductMappingRepository orderProductMappingRepository;

    public Order createOrder(Order order, List<Long> productIds) {
        order = orderRepository.save(order);
        for (Long productId : productIds) {
            OrderProductMapping mapping = new OrderProductMapping();
            mapping.setOrder(order);
            mapping.setProductId(productId);
            orderProductMappingRepository.save(mapping);
        }
        return order;
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void addProductToOrder(Long orderId, Long productId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderProductMapping mapping = new OrderProductMapping();
        mapping.setOrder(order);
        mapping.setProductId(productId);
        orderProductMappingRepository.save(mapping);
    }
}
