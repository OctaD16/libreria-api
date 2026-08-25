package com.libreria_pedidos.libreria_api.service;

import com.libreria_pedidos.libreria_api.exception.ResourceNotFoundException;
import com.libreria_pedidos.libreria_api.model.StoreConfig;
import com.libreria_pedidos.libreria_api.repository.IStoreConfigRepository;
import com.libreria_pedidos.libreria_api.serviceJPA.IStoreConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<StoreConfig> storeConfig = scRepo.findById(id);
        if (storeConfig.isPresent()) {
            return storeConfig.get();
        } else {
            throw new ResourceNotFoundException("La configuracion no existe");
        }
    }

    @Override
    public List<StoreConfig> buscarTodos() {
        return scRepo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        StoreConfig storeConfig = this.buscarPorId(id);
        scRepo.delete(storeConfig);
    }

    @Override
    public StoreConfig actualizar(Long id, StoreConfig storeConfig) {
        StoreConfig sConfig = this.buscarPorId(id);
        sConfig.setName(storeConfig.getName());
        sConfig.setWappNumber(storeConfig.getWappNumber());
        sConfig.setAddress(storeConfig.getAddress());
        sConfig.setEmail(storeConfig.getEmail());
        sConfig.setLogo(storeConfig.getLogo());
        sConfig.setFavicon(storeConfig.getFavicon());
        sConfig.setCurrency(storeConfig.getCurrency());
        //   sConfig.setOpen(storeConfig.getIsOpen());
        sConfig.setOpeningHours(storeConfig.getOpeningHours());
        sConfig.setClosingHours(storeConfig.getClosingHours());
        sConfig.setDeliveryHours(storeConfig.getDeliveryHours());
        sConfig.setAliasStore(storeConfig.getAliasStore());
        return scRepo.save(sConfig);
}

    @Override
    public boolean existe(Long id) {
        return scRepo.existsById(id);
    }
}
