package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.OrdersDetail;
import java.util.List;

public interface IOrdersDetailService {
    OrdersDetail guardar(OrdersDetail ordersDetail);
    OrdersDetail buscarPorId(Long id);
    List<OrdersDetail> buscarTodos();
    void eliminar(Long id);
    OrdersDetail actualizar(Long id, OrdersDetail ordersDetail);
}
