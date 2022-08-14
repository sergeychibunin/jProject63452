package com.storeexample.demo.persistence.dao.services.interfaces;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseOrderService {

    Page<PurchaseOrder> listAll(Pageable pageable);

    PurchaseOrder get(Long id);

    PurchaseOrder create(PurchaseOrder newOrder);
}
