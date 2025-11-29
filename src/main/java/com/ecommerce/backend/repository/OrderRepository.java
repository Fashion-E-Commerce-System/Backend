package com.ecommerce.backend.repository;

import com.ecommerce.backend.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}