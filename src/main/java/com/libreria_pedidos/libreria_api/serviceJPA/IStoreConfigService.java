package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.StoreConfig;
import java.util.List;

public interface IStoreConfigService {
    StoreConfig guardar(StoreConfig storeConfig);
    StoreConfig buscarPorId(Long id);
    List<StoreConfig> buscarTodos();
    void eliminar(Long id);
    StoreConfig actualizar(Long id, StoreConfig storeConfig);
    boolean existe(Long id);
}
