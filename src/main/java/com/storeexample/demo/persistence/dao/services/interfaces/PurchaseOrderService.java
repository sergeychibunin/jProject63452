package com.storeexample.demo.persistence.dao.services.interfaces;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface PurchaseOrderService {

    void delete(Long id);

    Page<PurchaseOrder> listAll(Specification<PurchaseOrder> specification, Pageable pageable);

    PurchaseOrder get(Long id);

    PurchaseOrder create(PurchaseOrder newOrder);
}
