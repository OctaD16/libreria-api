package com.libreria_pedidos.libreria_api.repository;

import com.libreria_pedidos.libreria_api.model.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersDetail extends JpaRepository<OrdersDetail, Long> {
}
