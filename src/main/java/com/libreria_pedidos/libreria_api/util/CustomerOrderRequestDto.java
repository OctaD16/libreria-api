package com.libreria_pedidos.libreria_api.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CustomerOrderRequestDto {
    private Long storeConfigId; // En qué local se hizo la venta
    private List<OrderItemRequestDto> items; // La lista de productos
}
