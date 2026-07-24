package com.libreria_pedidos.libreria_api.service.serviceJPA;

import com.libreria_pedidos.libreria_api.model.OrdersDetail;
import java.util.List;
import java.util.Optional;

public interface IOrdersDetailService {
    OrdersDetail save(OrdersDetail ordersDetail);
    Optional<OrdersDetail> findById(Long id);
    List<OrdersDetail> findAll();
    void delete(Long id);
    OrdersDetail update(Long id, OrdersDetail ordersDetail);
}
