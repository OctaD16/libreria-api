package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.model.OrdersDetail;
import com.libreria_pedidos.libreria_api.repository.IOrdersDetailRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailService implements IOrdersDetailService {
    @Autowired
    private IOrdersDetailRepository odRepo;

    @Override
    public OrdersDetail guardar(OrdersDetail ordersDetail) {
        return odRepo.save(ordersDetail);
    }

    @Override
    public OrdersDetail buscarPorId(Long id) {
        return odRepo.findById(id).orElse(null);
    }

    @Override
    public List<OrdersDetail> buscarTodos() {
        return odRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        odRepo.deleteById(id);
    }

    @Override
    public OrdersDetail actualizar(Long id, OrdersDetail ordersDetail) {
        return odRepo.save(ordersDetail);
    }
}
