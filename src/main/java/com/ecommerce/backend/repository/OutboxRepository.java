package com.ecommerce.backend.repository;

import com.ecommerce.backend.document.Outbox;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutboxRepository extends MongoRepository<Outbox, String> {
}
