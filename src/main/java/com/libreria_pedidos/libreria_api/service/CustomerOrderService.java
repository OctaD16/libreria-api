package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.exception.ResourceNotFoundException;
import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import com.libreria_pedidos.libreria_api.repository.ICustomerOrderRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Optional<CustomerOrder> cuOrder = coRepo.findById(id);
        if (cuOrder.isPresent()){
            return cuOrder.get();
        }else {
            throw new ResourceNotFoundException("La orden no existe");
        }
    }

    @Override
    public List<CustomerOrder> buscarTodos() {
        return coRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        CustomerOrder cuOrder = this.buscarPorId(id);
        coRepo.delete(cuOrder);
    }

    @Override
    public CustomerOrder actualizar(Long id, CustomerOrder customerOrder){
        CustomerOrder cuOrder = this.buscarPorId(id);

        cuOrder.setDate(customerOrder.getDate());
        cuOrder.setCustomerName(customerOrder.getCustomerName());
        cuOrder.setAddress(customerOrder.getAddress());
        cuOrder.setPhone(customerOrder.getPhone());

        cuOrder.setEmail(customerOrder.getEmail());
        cuOrder.setTotal(customerOrder.getTotal());
        cuOrder.setPaymentMethod(customerOrder.getPaymentMethod());
        cuOrder.setStatus(customerOrder.getStatus());
        cuOrder.setObservations(customerOrder.getObservations());
        cuOrder.setDeliveryType(customerOrder.getDeliveryType());
        cuOrder.setDeliveryDate(customerOrder.getDeliveryDate());
    return coRepo.save(cuOrder);
    }

    @Override
    public Boolean existe(Long id) {
        return coRepo.existsById(id);
    }
}
