package com.ecommerce.backend.service;

import com.ecommerce.backend.document.Order;
import com.ecommerce.backend.document.OrderItem;
import com.ecommerce.backend.dto.OrderRequest;

import com.ecommerce.backend.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public void createOrders(List<OrderRequest> orderRequests, String username) {
        if (orderRequests == null || orderRequests.isEmpty()) {
            throw new IllegalArgumentException("Order request list cannot be null or empty");
        }

        log.info("Creating orders for user {} with requests {}", username, orderRequests);


        Order order = new Order();
        order.setUsername(username);
        order.setDate(LocalDateTime.now());


        List<OrderItem> items = orderRequests.stream()
                .map(req -> OrderItem.builder()
                        .productId(req.getProductId())
                        .quantity(req.getQuantity())
                        .build())
                .collect(Collectors.toList());

        order.setOrders(items);


        orderRepository.save(order);
    }


}