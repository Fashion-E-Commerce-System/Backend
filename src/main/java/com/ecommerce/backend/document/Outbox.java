package com.ecommerce.backend.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@Document(collection = "outbox")
@AllArgsConstructor
@NoArgsConstructor(force = true) // final 필드 때문에 강제로 기본 생성자 생성
public class Outbox {
    @Id
    private String id;
    private String aggregateId;
    private String payload;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
