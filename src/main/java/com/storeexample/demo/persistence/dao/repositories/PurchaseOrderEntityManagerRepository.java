package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.PurchaseOrderReportProjectionCopy;

import java.util.List;

public interface PurchaseOrderEntityManagerRepository {

    List<PurchaseOrderReportProjectionCopy> getUniqueProductsInStorePerDayCopy();
}
