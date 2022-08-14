package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.PurchaseOrderRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repository;

    @Override
    public Page<PurchaseOrder> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
