package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.PurchaseOrderPosition;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseOrderPositionRepository
        extends PagingAndSortingRepository<PurchaseOrderPosition, Long>,
        JpaSpecificationExecutor<PurchaseOrderPosition> {
}
