package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.model.StoreConfig;
import com.libreria_pedidos.libreria_api.repository.IStoreConfigRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IStoreConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreConfigService implements IStoreConfigService {
    @Autowired
    private IStoreConfigRepository scRepo;

    @Override
    public StoreConfig guardar(StoreConfig storeConfig) {
        return scRepo.save(storeConfig);
    }

    @Override
    public StoreConfig buscarPorId(Long id) {
        return scRepo.findById(id).orElse(null);
    }

    @Override
    public List<StoreConfig> buscarTodos() {
        return scRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        scRepo.deleteById(id);
    }

    @Override
    public StoreConfig actualizar(Long id, StoreConfig storeConfig) {
        return scRepo.save(storeConfig);
    }

    @Override
    public Boolean existe(Long id) {
        return scRepo.existsById(id);
    }
}
