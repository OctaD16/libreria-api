package com.libreria_pedidos.libreria_api.serviceJPA;

import com.libreria_pedidos.libreria_api.model.UserStore;
import java.util.List;

public interface IUserStoreService {
    UserStore guardar(UserStore userStore);
    UserStore buscarPorId(Long id);
    List<UserStore> buscarTodos();
    void eliminar(Long id);
    UserStore actualizar(Long id, UserStore userStore);
    boolean existe(Long id);
}
