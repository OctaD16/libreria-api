package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.exception.ResourceNotFoundException;
import com.libreria_pedidos.libreria_api.model.OrdersDetail;
import com.libreria_pedidos.libreria_api.repository.IOrdersDetailRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
        Optional<OrdersDetail> oDetail = odRepo.findById(id);
        if (oDetail.isPresent()){
            return oDetail.get();
        }else{
            throw new ResourceNotFoundException("No se encuentra la orden");
        }
    }

    @Override
    public List<OrdersDetail> buscarTodos() {
        return odRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        OrdersDetail oDetail = this.buscarPorId(id);
        odRepo.delete(oDetail);
    }

    @Override
    public OrdersDetail actualizar(Long id, OrdersDetail ordersDetail) {
        OrdersDetail oDetail = this.buscarPorId(id);
        oDetail.setQuantity(ordersDetail.getQuantity());
        oDetail.setPrice(ordersDetail.getPrice());
        oDetail.setSubtotal(ordersDetail.getSubtotal());
        oDetail.setProduct(ordersDetail.getProduct());
        oDetail.setCustomerOrder(ordersDetail.getCustomerOrder());

        return odRepo.save(oDetail);
    }
}
