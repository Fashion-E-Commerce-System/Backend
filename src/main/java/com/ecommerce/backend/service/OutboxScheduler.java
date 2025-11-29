package com.ecommerce.backend.service;

import com.ecommerce.backend.document.Outbox;
import com.ecommerce.backend.repository.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutboxScheduler {

    private final OutboxRepository outboxRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Scheduled(fixedRate = 3000)
    public void processOutbox() {
        List<Outbox> outboxMessages = outboxRepository.findAll();
        for (Outbox outbox : outboxMessages) {
            kafkaTemplate.send(topicName, outbox.getPayload());
            outboxRepository.delete(outbox);
        }
    }
}
