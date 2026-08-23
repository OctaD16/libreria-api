package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import com.libreria_pedidos.libreria_api.repository.ICustomerOrderRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService implements ICustomerOrderService {
    @Autowired
    private ICustomerOrderRepository coRepo;

    @Override
    public CustomerOrder guardar(CustomerOrder customerOrder) {
        return coRepo.save(customerOrder);
    }

    @Override
    public CustomerOrder buscarPorId(Long id) {
        return coRepo.findById(id).orElse(null);
    }

    @Override
    public List<CustomerOrder> buscarTodos() {
        return coRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        coRepo.deleteById(id);
    }

    @Override
    public CustomerOrder actualizar(Long id, CustomerOrder customerOrder) {
        return coRepo.save(customerOrder);
    }

    @Override
    public Boolean existe(Long id) {
        return coRepo.existsById(id);
    }
}
