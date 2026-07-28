package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.model.UserStore;
import com.libreria_pedidos.libreria_api.repository.IUserStoreRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IUserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoreService implements IUserStoreService {
    @Autowired
    private IUserStoreRepository usRepo;

    @Override
    public UserStore guardar(UserStore userStore) {
        return usRepo.save(userStore);
    }

    @Override
    public UserStore buscarPorId(Long id) {
        return usRepo.findById(id).orElse(null);
    }

    @Override
    public List<UserStore> buscarTodos() {
        return usRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        usRepo.deleteById(id);
    }

    @Override
    public UserStore actualizar(Long id, UserStore userStore) {
        return usRepo.save(userStore);
    }
}
