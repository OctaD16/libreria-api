package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.repository.IOrdersDetailRepository;
import com.libreria_pedidos.libreria_api.service.serviceJPA.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersDetailService implements IOrdersDetailService {
    @Autowired
    private IOrdersDetailRepository odRepo;
    @Override
    public com.libreria_pedidos.libreria_api.model.OrdersDetail save(com.libreria_pedidos.libreria_api.model.OrdersDetail ordersDetail) {
        return null;
    }

    @Override
    public java.util.Optional<com.libreria_pedidos.libreria_api.model.OrdersDetail> findById(Long id) {
        return java.util.Optional.empty();
    }

    @Override
    public java.util.List<com.libreria_pedidos.libreria_api.model.OrdersDetail> findAll() {
        return java.util.Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public com.libreria_pedidos.libreria_api.model.OrdersDetail update(Long id, com.libreria_pedidos.libreria_api.model.OrdersDetail ordersDetail) {
        return null;
    }
}
