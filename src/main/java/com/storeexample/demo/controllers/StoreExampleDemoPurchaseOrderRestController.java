package com.storeexample.demo.controllers;

import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StoreExampleDemoPurchaseOrderRestController {

    @Autowired
    private PurchaseOrderService service;

    @GetMapping("/purchase-order")
    public Page<PurchaseOrder> getAll(Pageable pageable) {
        // TODO filtering
        return service.listAll(pageable);
    }

    @GetMapping("/purchase-order/{id}")
    public PurchaseOrder get(@PathVariable Long id) {
        return service.get(id);
    }
}
