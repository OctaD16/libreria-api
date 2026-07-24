package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.repository.IUserStoreRepository;
import com.libreria_pedidos.libreria_api.service.serviceJPA.IUserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoreService implements IUserStoreService {
    @Autowired
    private IUserStoreRepository usRepo;
    @Override
    public com.libreria_pedidos.libreria_api.model.UserStore save(com.libreria_pedidos.libreria_api.model.UserStore userStore) {
        return null;
    }

    @Override
    public java.util.Optional<com.libreria_pedidos.libreria_api.model.UserStore> findById(Long id) {
        return java.util.Optional.empty();
    }

    @Override
    public java.util.List<com.libreria_pedidos.libreria_api.model.UserStore> findAll() {
        return java.util.Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public com.libreria_pedidos.libreria_api.model.UserStore update(Long id, com.libreria_pedidos.libreria_api.model.UserStore userStore) {
        return null;
    }
}
