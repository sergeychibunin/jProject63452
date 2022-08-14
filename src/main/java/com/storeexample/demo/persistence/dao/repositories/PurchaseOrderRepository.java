package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseOrderRepository
        extends PagingAndSortingRepository<PurchaseOrder, Long>, JpaSpecificationExecutor<PurchaseOrder> {
}
