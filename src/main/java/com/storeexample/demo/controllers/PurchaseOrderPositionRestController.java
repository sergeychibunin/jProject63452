package com.storeexample.demo.controllers;

import com.storeexample.demo.controllers.requests.PurchaseOrderPositionRequest;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderPositionService;
import com.storeexample.demo.persistence.dao.services.interfaces.PurchaseOrderService;
import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.PurchaseOrder;
import com.storeexample.demo.persistence.model.PurchaseOrderPosition;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Validated
public class PurchaseOrderPositionRestController {

    @Autowired
    private PurchaseOrderPositionService positionService;

    @Autowired
    private PurchaseOrderService orderService;

    @Autowired
    private RSSFeedService rssFeedService;

    @PostMapping("/purchase-order/position")
    public PurchaseOrderPosition create(@RequestBody PurchaseOrderPositionRequest newPosition) {
        PurchaseOrder order = orderService.get(newPosition.getOrder());
        RSSFeed rssFeed = rssFeedService.get(newPosition.getRssfeed());
        PurchaseOrderPosition position = new PurchaseOrderPosition();
        position.setPurchaseOrder(order);
        position.setRssFeed(rssFeed);
        return positionService.create(position);
    }

    @DeleteMapping("/purchase-order/position/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        positionService.delete(id);
    }
}
