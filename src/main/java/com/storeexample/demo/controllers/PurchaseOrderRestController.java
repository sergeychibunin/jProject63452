package com.storeexample.demo.controllers;

import com.storeexample.demo.controllers.responses.PurchaseOrderReport;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.dao.specifications.PurchaseOrderSpecificationBuilder;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import com.storeexample.demo.util.StoreExampleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;

@RestController
@RequestMapping("/api/v1")
public class PurchaseOrderRestController {

    @Autowired
    private PurchaseOrderService service;

    @GetMapping("/purchase-order")
    public Page<PurchaseOrder> getAll(
            @RequestParam(value = "search", required = false) String search, Pageable pageable) {

        Specification<PurchaseOrder> specification = null;
        if (search != null) {
            PurchaseOrderSpecificationBuilder specificationBuilder = new PurchaseOrderSpecificationBuilder();
            Matcher matcher = StoreExampleUtil.getRequestDynamicFilterMatcher(search);
            while (matcher.find()) {
                specificationBuilder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
            specification = specificationBuilder.build();
        }
        return service.listAll(specification, pageable);
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

    @GetMapping("/purchase-order/report")
    public PurchaseOrderReport get() {
        return service.getReport();
    }
}
