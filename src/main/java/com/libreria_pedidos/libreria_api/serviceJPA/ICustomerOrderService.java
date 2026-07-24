package com.libreria_pedidos.libreria_api.service.serviceJPA;

import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import java.util.List;
import java.util.Optional;

public interface ICustomerOrderService {
    CustomerOrder save(CustomerOrder customerOrder);
    Optional<CustomerOrder> findById(Long id);
    List<CustomerOrder> findAll();
    void delete(Long id);
    CustomerOrder update(Long id, CustomerOrder customerOrder);
}
