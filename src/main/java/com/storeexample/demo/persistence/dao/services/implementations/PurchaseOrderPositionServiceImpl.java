package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.PurchaseOrderPositionRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderPositionService;
import com.storeexample.demo.persistence.model.PurchaseOrderPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderPositionServiceImpl implements PurchaseOrderPositionService {

    @Autowired
    private PurchaseOrderPositionRepository repository;

    @Override
    public PurchaseOrderPosition create(PurchaseOrderPosition newPosition) {
        return repository.save(newPosition);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
