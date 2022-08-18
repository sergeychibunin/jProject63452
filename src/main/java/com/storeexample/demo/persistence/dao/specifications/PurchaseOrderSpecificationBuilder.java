package com.storeexample.demo.persistence.dao.specifications;

import com.storeexample.demo.persistence.model.PurchaseOrder;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseOrderSpecificationBuilder {

    private final List<SearchCriteria> params;

    public PurchaseOrderSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public PurchaseOrderSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<PurchaseOrder> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<PurchaseOrder>> specs = params.stream()
                .map(PurchaseOrderSpecification::new).collect(Collectors.toList());

        Specification<PurchaseOrder> result = specs.get(0);
        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
