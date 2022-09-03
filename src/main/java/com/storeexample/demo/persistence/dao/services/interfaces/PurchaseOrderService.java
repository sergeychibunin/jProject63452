package com.storeexample.demo.persistence.dao.services.interfaces;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import com.storeexample.demo.persistence.model.PurchaseOrderReportProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface PurchaseOrderService {

    void delete(Long id);

    Page<PurchaseOrder> listAll(Specification<PurchaseOrder> specification, Pageable pageable);

    PurchaseOrder get(Long id);

    PurchaseOrder create(PurchaseOrder newOrder);

    List<PurchaseOrderReportProjection> getReport();
}
