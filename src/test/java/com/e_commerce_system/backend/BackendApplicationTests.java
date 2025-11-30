package com.e_commerce_system.backend;

import com.ecommerce.backend.dto.OrderRequest;
import com.ecommerce.backend.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BackendApplicationTests {

    @InjectMocks
    private OrderService orderService;

    @Test
    void whenCreateOrdersIsCalledWithEmptyList_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.createOrders(Collections.emptyList(), "testuser");
        });
    }
}
