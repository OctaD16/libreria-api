package com.libreria_pedidos.libreria_api.service.serviceJPA;

import com.libreria_pedidos.libreria_api.model.UserStore;
import java.util.List;
import java.util.Optional;

public interface IUserStoreService {
    UserStore save(UserStore userStore);
    Optional<UserStore> findById(Long id);
    List<UserStore> findAll();
    void delete(Long id);
    UserStore update(Long id, UserStore userStore);
}
