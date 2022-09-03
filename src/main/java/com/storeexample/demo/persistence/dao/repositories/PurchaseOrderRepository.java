package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import com.storeexample.demo.persistence.model.PurchaseOrderReportProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PurchaseOrderRepository
        extends PagingAndSortingRepository<PurchaseOrder, Long>, JpaSpecificationExecutor<PurchaseOrder> {

    @Query(value = """
            select distinct
            po.created_at\\:\\:date date,
            s.name storeName,
            (select count(*) from (
                select distinct pop_.rssfeed_id from purchase_order_position pop_
                where pop_.order_id = po.id
            ) _ ) amount
            from purchase_order po
            join store s on s.id = po.store_id
            """, nativeQuery = true)
    List<PurchaseOrderReportProjection> getUniqueProductsInStorePerDay();
}
