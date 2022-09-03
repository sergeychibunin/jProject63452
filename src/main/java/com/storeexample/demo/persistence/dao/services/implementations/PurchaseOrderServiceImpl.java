package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.controllers.responses.PurchaseOrderReport;
import com.storeexample.demo.exceptions.PurchaseOrderNotFoundException;
import com.storeexample.demo.persistence.dao.repositories.PurchaseOrderRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<PurchaseOrder> listAll(Specification<PurchaseOrder> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    @Override
    public PurchaseOrder get(Long id) {
        return repository.findById(id).orElseThrow(() -> new PurchaseOrderNotFoundException(id));
    }

    @Override
    public PurchaseOrder create(PurchaseOrder newOrder) {
        newOrder.setCreatedAt(ZonedDateTime.now());
        return repository.save(newOrder);
    }

    @Override
    public PurchaseOrderReport getReport() {
        return repository.getUniqueProductsInStorePerDay();
    }
}
