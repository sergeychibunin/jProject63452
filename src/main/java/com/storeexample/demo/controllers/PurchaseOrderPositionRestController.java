package com.storeexample.demo.controllers;

import com.storeexample.demo.controllers.requests.PurchaseOrderPositionRequest;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderPositionService;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import com.storeexample.demo.persistence.model.PurchaseOrderPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Validated
public class PurchaseOrderPositionRestController {

    @Autowired
    private PurchaseOrderPositionService positionService;

    @Autowired
    private PurchaseOrderService orderService;

    @PostMapping("/purchase-order/position")
    public PurchaseOrderPosition create(@RequestBody PurchaseOrderPositionRequest newPosition) {
        PurchaseOrder order = orderService.get(newPosition.getOrder());
        PurchaseOrderPosition position = new PurchaseOrderPosition();
        position.setPurchaseOrder();
        return service.create(newPosition);
    }
}
