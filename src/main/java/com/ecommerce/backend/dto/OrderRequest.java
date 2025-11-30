package com.ecommerce.backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Data
public class OrderRequest {
    private String productId;
    private int quantity;


}