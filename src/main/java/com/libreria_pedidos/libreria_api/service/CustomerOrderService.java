package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.repository.ICustomerOrderRepository;
import com.libreria_pedidos.libreria_api.service.serviceJPA.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService implements ICustomerOrderService {
    @Autowired
    private ICustomerOrderRepository coRepo;
    @Override
    public com.libreria_pedidos.libreria_api.model.CustomerOrder save(com.libreria_pedidos.libreria_api.model.CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public java.util.Optional<com.libreria_pedidos.libreria_api.model.CustomerOrder> findById(Long id) {
        return java.util.Optional.empty();
    }

    @Override
    public java.util.List<com.libreria_pedidos.libreria_api.model.CustomerOrder> findAll() {
        return java.util.Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public com.libreria_pedidos.libreria_api.model.CustomerOrder update(Long id, com.libreria_pedidos.libreria_api.model.CustomerOrder customerOrder) {
        return null;
    }
}
