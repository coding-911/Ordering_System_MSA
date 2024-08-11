package com.spring_cloud.eureka.client.order;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}") // 애플리케이션이 실행 중인 포트를 주입받습니다.
    private String serverPort;

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Server-Port", serverPort);
    }

    @GetMapping
    public String getOrder() {
        return "Order details"+ serverPort;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order, @RequestParam List<Long> productIds) {
        return orderService.createOrder(order, productIds);
    }

    @PutMapping("/{orderId}")
    public void addProductToOrder(@PathVariable Long orderId, @RequestBody Long productId) {
        orderService.addProductToOrder(orderId, productId);
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

}