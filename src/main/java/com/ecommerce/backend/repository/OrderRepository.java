package com.ecommerce.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    // 특정 유저 주문 조회
    List<Order> findByUserId(String userId);

    // 최근 4주 주문 조회
    List<Order> findByCreatedAtAfter(LocalDateTime from);
}