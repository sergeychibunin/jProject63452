package com.storeexample.demo.persistence.model;

import java.util.Date;

public interface PurchaseOrderReportProjection {

    Date getDate();
    String getStoreName();
    Integer getAmount();
}
