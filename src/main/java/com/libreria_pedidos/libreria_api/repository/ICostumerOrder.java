package com.libreria_pedidos.libreria_api.repository;

import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICostumerOrder extends JpaRepository<CustomerOrder, Long> {
}
