package com.storeexample.demo.persistence.dao.specifications;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import com.storeexample.demo.persistence.model.Store;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;

@AllArgsConstructor
public class PurchaseOrderSpecification implements Specification<PurchaseOrder> {

    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<PurchaseOrder> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            // related attribute
            if (criteria.getKey().indexOf(".") > 0) {
                String[] relatedAttributeKey = criteria.getKey().split("\\.");
                if (root.get(relatedAttributeKey[0]).getJavaType() == Store.class) {
                    Path<Object> objectPath = root.get(relatedAttributeKey[0]).get(relatedAttributeKey[1]);
                    if (objectPath.getJavaType() == long.class) {
                        return criteriaBuilder.equal(objectPath, criteria.getValue());
                    }
                }
            }
        }
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), (String) criteria.getValue());
            }
        }
        if (criteria.getOperation().equalsIgnoreCase("<")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), (ZonedDateTime) criteria.getValue());
            }
        }
        return null;
    }
}
