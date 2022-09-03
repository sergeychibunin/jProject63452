package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.PurchaseOrderReportProjectionCopy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PurchaseOrderEntityManagerRepositoryImpl implements PurchaseOrderEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PurchaseOrderReportProjectionCopy> getUniqueProductsInStorePerDayCopy() {
        return (List<PurchaseOrderReportProjectionCopy>) entityManager.createQuery("""
                select distinct
                cast(po.createdAt as date) date,
                po.store.name storeName,
                (select count(*) from (
                    select distinct pop_.rssfeed from PurchaseOrderPosition pop_
                    where pop_.order.id = po.id
                ) _ ) amount
                from PurchaseOrder po
                """).getResultList();
    }
}
