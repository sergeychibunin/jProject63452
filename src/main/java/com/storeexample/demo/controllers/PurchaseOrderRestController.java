package com.storeexample.demo.controllers;

import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PurchaseOrderRestController {

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

    /**
     * Create a new empty purchase order
     */
    @PostMapping("/purchase-order")
    public PurchaseOrder create(@RequestBody PurchaseOrder newOrder) {
        return service.create(newOrder);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/purchase-order/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
