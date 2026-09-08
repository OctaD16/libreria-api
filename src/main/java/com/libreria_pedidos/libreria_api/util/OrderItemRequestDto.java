package com.libreria_pedidos.libreria_api.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDto {
    private Long productId;
    private Integer quantity;
}
