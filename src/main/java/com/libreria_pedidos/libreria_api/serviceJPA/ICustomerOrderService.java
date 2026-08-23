package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.CustomerOrder;
import java.util.List;

public interface ICustomerOrderService {
    CustomerOrder guardar(CustomerOrder customerOrder);
    CustomerOrder buscarPorId(Long id);
    List<CustomerOrder> buscarTodos();
    void eliminar(Long id);
    CustomerOrder actualizar(Long id, CustomerOrder customerOrder);
    Boolean existe(Long id);
}
