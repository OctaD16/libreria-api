package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.repository.IStoreConfigRepository;
import com.libreria_pedidos.libreria_api.service.serviceJPA.IStoreConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreConfigService implements IStoreConfigService {
    @Autowired
    private IStoreConfigRepository scRepo;
    @Override
    public com.libreria_pedidos.libreria_api.model.StoreConfig save(com.libreria_pedidos.libreria_api.model.StoreConfig storeConfig) {
        return null;
    }

    @Override
    public java.util.Optional<com.libreria_pedidos.libreria_api.model.StoreConfig> findById(Long id) {
        return java.util.Optional.empty();
    }

    @Override
    public java.util.List<com.libreria_pedidos.libreria_api.model.StoreConfig> findAll() {
        return java.util.Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public com.libreria_pedidos.libreria_api.model.StoreConfig update(Long id, com.libreria_pedidos.libreria_api.model.StoreConfig storeConfig) {
        return null;
    }
}
