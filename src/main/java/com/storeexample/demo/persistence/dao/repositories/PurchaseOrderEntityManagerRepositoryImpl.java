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

    /**
     * The query is incorrect.
     * JPQL doesn't support CTE and subqueries but subqueries in WHERE, HAVING clauses only.
     * Processing the amount field in DB side is better.
     */
    @Override
    public List<PurchaseOrderReportProjectionCopy> getUniqueProductsInStorePerDayCopy() {
        return (List<PurchaseOrderReportProjectionCopy>) entityManager.createQuery("""
                select distinct
                cast(po.createdAt as date) as date,
                po.store.name as storeName,
                t.amount
                from PurchaseOrder po
                join ( select _.order, count(_.rssfeed) as amount from ( 
                    select distinct pop_.rssfeed from PurchaseOrderPosition pop_
                ) as _ group by _.order) as t on t.order = po
                """).getResultList();
    }
}
