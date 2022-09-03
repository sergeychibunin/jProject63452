package com.storeexample.demo.persistence.model;

import java.sql.Date;

public interface PurchaseOrderReportProjectionCopy {

    Date getDate();
    String getStoreName();
    Integer getAmount();
}
