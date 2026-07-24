package com.libreria_pedidos.libreria_api.service.serviceJPA;

import com.libreria_pedidos.libreria_api.model.StoreConfig;
import java.util.List;
import java.util.Optional;

public interface IStoreConfigService {
    StoreConfig save(StoreConfig storeConfig);
    Optional<StoreConfig> findById(Long id);
    List<StoreConfig> findAll();
    void delete(Long id);
    StoreConfig update(Long id, StoreConfig storeConfig);
}
